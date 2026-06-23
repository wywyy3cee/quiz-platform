package wywyy3cee.quiz_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wywyy3cee.quiz_application.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
