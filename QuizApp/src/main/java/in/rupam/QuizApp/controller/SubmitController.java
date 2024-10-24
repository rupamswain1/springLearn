package in.rupam.QuizApp.controller;

import in.rupam.QuizApp.model.SubmitQuiz;
import in.rupam.QuizApp.service.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("submit")
public class SubmitController {

    @Autowired
    SubmitService submitService;
    @PostMapping()
    public ResponseEntity<Integer> submitQuiz(@RequestBody SubmitQuiz submit){
        return submitService.calculateScore(submit);
    }
}
