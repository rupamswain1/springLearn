package in.rupam.QuizApp.model;

import lombok.Data;
import java.util.List;

@Data
public class SubmitQuiz {
    private int quizId;
    private List<QuestionAnswers> answers;
}
