package in.rupam.QuizService.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionAnswers {
    private int questionId;
    private String answer;
}
