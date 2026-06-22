package wywyy3cee.quiz_application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false, unique = false)
    private Question question;

    @Column(name = "answer", nullable = false, unique = false)
    private String answerText;

    @Column(name = "is_correct", nullable = false, unique = false)
    private Boolean isCorrect;

}
