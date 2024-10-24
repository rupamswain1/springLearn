package in.rupam.QuestionService.controller;


import in.rupam.QuestionService.model.Question;
import in.rupam.QuestionService.model.QuestionAnswers;
import in.rupam.QuestionService.model.QuestionResponse;
import in.rupam.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> generateQuestion(@RequestParam String category, @RequestParam int numberOfQuestions){
        return questionService.generateQuestions(category, numberOfQuestions);
    }

    @PostMapping("getByIds")
    public ResponseEntity<List<QuestionResponse>> getQuestionsById(@RequestBody List<Integer> ids){
        return questionService.getAllQuestionsById(ids);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<QuestionAnswers> answers){
        return questionService.calculateScore(answers);
    }
}
