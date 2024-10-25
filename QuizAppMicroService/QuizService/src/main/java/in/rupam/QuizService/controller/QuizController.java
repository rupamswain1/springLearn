package in.rupam.QuizService.controller;

import in.rupam.QuizService.model.QuizCreateBody;
import in.rupam.QuizService.model.QuizResponse;
import in.rupam.QuizService.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("getQuiz")
    public ResponseEntity<List<QuizResponse>> getAllQuiz(){
        return quizService.getAllQuiz();
    }

    @GetMapping("getQuiz/{id}")
    public ResponseEntity<QuizResponse> getQuizById(@PathVariable int id){
        return quizService.getQuizById(id);
    }

    @PostMapping("add")
    public ResponseEntity<String> createQuiz(@RequestBody QuizCreateBody quizbody){
        return quizService.addQuiz(quizbody);
    }
}
