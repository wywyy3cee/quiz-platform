package wywyy3cee.quiz_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wywyy3cee.quiz_application.model.Answer;
import wywyy3cee.quiz_application.model.Question;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestion(Question question);
}
