package wywyy3cee.quiz_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wywyy3cee.quiz_application.model.Quiz;
import wywyy3cee.quiz_application.model.User;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByOwner(User owner);
}
