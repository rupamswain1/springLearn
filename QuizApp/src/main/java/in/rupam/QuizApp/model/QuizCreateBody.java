package in.rupam.QuizApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class QuizCreateBody {
    private String category;
    private String title;
    private int noOfQuestions;
}
