package in.rupam.QuizApp.controller;

import in.rupam.QuizApp.model.Question;
import in.rupam.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("getAll")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestiosn();
    }
}
