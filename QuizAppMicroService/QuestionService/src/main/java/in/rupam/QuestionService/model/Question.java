package in.rupam.QuestionService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String description;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;
    private String category;
    private String difficulty;
}
