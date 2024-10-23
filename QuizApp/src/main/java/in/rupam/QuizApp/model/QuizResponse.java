package in.rupam.QuizApp.model;

import lombok.Data;

import java.util.List;

@Data
public class QuizResponse {
    private int quizId;
    private String category;
    private String title;
    private List<QuestionResponse> questions;
}
