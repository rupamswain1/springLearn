package in.rupam.QuizApp.controller;

import in.rupam.QuizApp.model.Quiz;
import in.rupam.QuizApp.model.QuizCreateBody;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @GetMapping("getQuiz")
    public RequestEntity<List<Quiz>> getAllQuiz(){

    }

    @GetMapping("getQuiz/{id}")
    public RequestEntity<Quiz> getQuizById(){

    }

    @PostMapping("add")
    public RequestEntity<String> createQuiz(@RequestBody QuizCreateBody){

    }

}
