package in.rupam.QuizApp.service;

import in.rupam.QuizApp.model.Question;
import in.rupam.QuizApp.repository.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionsRepo questionsRepo;
    public List<Question> getAllQuestiosn() {
        return questionsRepo.findAll();
    }

    public List<Question> getByCategory(String category) {
        return questionsRepo.findByCategory(category.substring(0, 1).toUpperCase()+category.substring(1));
    }

    public Question save(Question question) {
        return questionsRepo.save(question);
    }
}
