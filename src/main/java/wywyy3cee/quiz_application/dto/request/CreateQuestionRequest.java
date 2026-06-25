package wywyy3cee.quiz_application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wywyy3cee.quiz_application.model.QuestionType;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuestionRequest {
    private String questionText;
    private String imageUrl;
    private QuestionType questionType;
    private Integer orderIndex;
    private Integer timeLimitSeconds;
    private List<CreateAnswerRequest> answers;
}
