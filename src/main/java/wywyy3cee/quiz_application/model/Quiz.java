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
@Table(name = "quizzes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",nullable = false, unique = false )
    private String title;

    @Column(name = "description", nullable = true, unique = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false, unique = false)
    private User owner;

    @Column(name = "created_at", unique = false, nullable = false)
    private LocalDateTime createdAt;
}
