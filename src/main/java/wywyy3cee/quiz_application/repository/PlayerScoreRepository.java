package wywyy3cee.quiz_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wywyy3cee.quiz_application.model.GameSession;
import wywyy3cee.quiz_application.model.PlayerScore;

import java.util.List;

public interface PlayerScoreRepository extends JpaRepository<PlayerScore, Long> {
    List<PlayerScore> findBySession(GameSession session);
}
