package wywyy3cee.quiz_application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false, unique = false)
    private Quiz quiz;

    @Column(name = "text", nullable = false, unique = false)
    private String questionText;

    @Column(name = "image_url", nullable = true, unique = false)
    private String imageUrl;

    @Column(name = "type", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @Column(name = "order_index", nullable = false, unique = false)
    private int orderIndex;

    @Column(name = "time_limit", nullable = false, unique = false)
    private int timeLimitSeconds;
}
