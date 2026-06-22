package wywyy3cee.quiz_application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "scores")
public class PlayerScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false, unique = false)
    private GameSession session;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false, unique = false)
    private User player;

    @Column(name = "score", nullable = false, unique = false)
    private Integer score;
}
