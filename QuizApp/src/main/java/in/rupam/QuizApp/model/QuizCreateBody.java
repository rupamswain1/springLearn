package in.rupam.QuizApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizCreateBody {
    private String category;
    private int noOfQuestions;
}
