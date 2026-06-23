package wywyy3cee.quiz_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wywyy3cee.quiz_application.model.Question;
import wywyy3cee.quiz_application.model.Quiz;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuizOrderByOrderIndexAsc(Quiz quiz);
}
