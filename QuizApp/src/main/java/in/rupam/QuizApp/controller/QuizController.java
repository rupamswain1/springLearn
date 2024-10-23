package in.rupam.QuizApp.controller;

import in.rupam.QuizApp.model.Quiz;
import in.rupam.QuizApp.model.QuizCreateBody;
import in.rupam.QuizApp.model.QuizResponse;
import in.rupam.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
