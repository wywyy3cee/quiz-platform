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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", unique = false, nullable = false)
    private String password;

    @Column(name = "role", unique = false, nullable = true)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column (name = "created_at", unique = false, nullable = false)
    private LocalDateTime createdAt;
}
