package wywyy3cee.quiz_application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAnswerRequest {
    private String answerText;
    private Boolean isCorrect;
}
