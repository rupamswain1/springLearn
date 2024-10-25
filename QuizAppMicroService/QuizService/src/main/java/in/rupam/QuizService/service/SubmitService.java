package in.rupam.QuizService.service;

import in.rupam.QuizService.feign.QuizInterface;
import in.rupam.QuizService.model.*;
import in.rupam.QuizService.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubmitService {
    @Autowired
    QuizInterface questionsRepo;

    @Autowired
    QuizRepo quizRepo;
    public ResponseEntity<Integer> calculateScore(SubmitQuiz submit) {

        QuizWithIds quiz = quizRepo.findById(submit.getQuizId()).orElse(null);
        if(quiz!=null)
        {
            List<Integer> quizQuestions= quiz.getQuestions();
            List<QuestionAnswers> answers = submit.getAnswers();
            Map<Integer,String> quesIds = new HashMap<>();
            List<QuestionAnswers> validatedAns = new ArrayList<>();
            for(QuestionAnswers ans:answers){
                int id = ans.getQuestionId();
                String res = ans.getAnswer();
                if(quesIds.get(id) == null) {
                    int questionId = (int) quizQuestions.stream().filter(q -> q == id).findFirst().orElse(0);
                    if (questionId >0) {
                        quesIds.put(id, res);
                        validatedAns.add(new QuestionAnswers(id,res));
                    }
                }
            }
            int score = questionsRepo.getScore(validatedAns).getBody();
            return new ResponseEntity<>(score, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);}
}
