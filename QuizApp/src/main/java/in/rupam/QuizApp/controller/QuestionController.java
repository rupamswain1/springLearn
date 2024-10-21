package in.rupam.QuizApp.controller;

import in.rupam.QuizApp.model.Question;
import in.rupam.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
        return questionService.getByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addNewQuestion(@RequestBody Question question){
        Question addedQuestion = questionService.save(question);
        if(addedQuestion!=null){
            return new ResponseEntity("Success", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
    }
}
