package wywyy3cee.quiz_application.service;

import org.springframework.stereotype.Service;
import wywyy3cee.quiz_application.model.User;
import wywyy3cee.quiz_application.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User with this username not found"));
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User with this email not found"));
    }
}
