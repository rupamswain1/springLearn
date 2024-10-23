package in.rupam.QuizApp.model;

import lombok.Data;

@Data
public class QuestionResponse {
    private int questionId;
    private String description;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
