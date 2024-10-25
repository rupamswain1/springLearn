package in.rupam.QuizService.model;

import lombok.Data;

@Data
public class QuizCreateBody {
    private String category;
    private String title;
    private int noOfQuestions;
}
