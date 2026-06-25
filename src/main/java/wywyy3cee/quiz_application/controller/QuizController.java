package wywyy3cee.quiz_application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wywyy3cee.quiz_application.dto.request.CreateQuestionRequest;
import wywyy3cee.quiz_application.dto.request.CreateQuizRequest;
import wywyy3cee.quiz_application.model.Question;
import wywyy3cee.quiz_application.model.Quiz;
import wywyy3cee.quiz_application.service.QuizService;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody CreateQuizRequest request) {
        Quiz result = quizService.createQuiz(request, "test_user"); // ToDo AFTER MAKE AUTH
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/{quizId}/questions")
    public ResponseEntity<Question> addQuestion(@PathVariable Long quizId,
                                                @RequestBody CreateQuestionRequest request) {
        Question result = quizService.addQuestion(request, quizId);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
