package wywyy3cee.quiz_application.service;

import org.springframework.stereotype.Service;
import wywyy3cee.quiz_application.dto.request.CreateQuestionRequest;
import wywyy3cee.quiz_application.dto.request.CreateQuizRequest;
import wywyy3cee.quiz_application.model.Answer;
import wywyy3cee.quiz_application.model.Question;
import wywyy3cee.quiz_application.model.Quiz;
import wywyy3cee.quiz_application.model.User;
import wywyy3cee.quiz_application.repository.AnswerRepository;
import wywyy3cee.quiz_application.repository.QuestionRepository;
import wywyy3cee.quiz_application.repository.QuizRepository;
import wywyy3cee.quiz_application.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;

    public QuizService(QuizRepository quizRepository,
                       QuestionRepository questionRepository,
                       AnswerRepository answerRepository,
                       UserRepository userRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
    }

    public Quiz createQuiz(CreateQuizRequest quizRequest, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()->new RuntimeException("User with this username not found"));
        Quiz quiz = new Quiz();

        quiz.setTitle(quizRequest.getTitle());
        quiz.setDescription(quizRequest.getDescription());
        quiz.setOwner(user);
        quiz.setCreatedAt(LocalDateTime.now());

        quizRepository.save(quiz);
        return quiz;
    }

    public Question addQuestion(CreateQuestionRequest questionRequest, Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz with this id is not found"));
        Question question = new Question();
        question.setQuiz(quiz);
        question.setQuestionType(questionRequest.getQuestionType());
        question.setQuestionText(questionRequest.getQuestionText());
        question.setImageUrl(questionRequest.getImageUrl());
        question.setTimeLimitSeconds(questionRequest.getTimeLimitSeconds());
        question.setOrderIndex(questionRequest.getOrderIndex());
        Question saved = questionRepository.save(question);

        List<Answer> answerList = questionRequest.getAnswers().stream()
                .map(answerRequest -> {
                    Answer answer = new Answer();
                    answer.setQuestion(saved);
                    answer.setAnswerText(answerRequest.getAnswerText());
                    answer.setIsCorrect(answerRequest.getIsCorrect());
                    return answer;
                }).toList();
        answerRepository.saveAll(answerList);

        return saved;
    }
}
