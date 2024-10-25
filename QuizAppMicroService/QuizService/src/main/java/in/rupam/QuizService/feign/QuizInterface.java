package in.rupam.QuizService.feign;

import in.rupam.QuizService.model.QuestionAnswers;
import in.rupam.QuizService.model.QuestionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@FeignClient("QUESTIONSERVICE")
public interface QuizInterface {
    @GetMapping("questions/generate")
    public ResponseEntity<List<Integer>> generateQuestion(@RequestParam String category, @RequestParam int numberOfQuestions);

    @PostMapping("questions/getByIds")
    public ResponseEntity<List<QuestionResponse>> getQuestionsById(@RequestBody List<Integer> ids);

    @PostMapping("questions/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<QuestionAnswers> answers);
}
