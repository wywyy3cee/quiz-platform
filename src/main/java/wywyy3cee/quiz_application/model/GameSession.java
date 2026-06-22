package wywyy3cee.quiz_application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "sessions")
public class GameSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false, unique = false)
    private Quiz quiz;

    @Column(name = "room_code", nullable = false, unique = true)
    private String roomCode;

    @Column(name = "status", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private GameStatus status;

    @Column(name = "question_index", nullable = false, unique = false)
    private Integer currentQuestionIndex;

    @Column(name = "created_at", nullable = false, unique = false)
    private LocalDateTime createdAt;
}
