package in.rupam.QuizApp.service;

import in.rupam.QuizApp.model.*;
import in.rupam.QuizApp.repository.QuestionsRepo;
import in.rupam.QuizApp.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SubmitService {
    @Autowired
    QuestionsRepo questionsRepo;

    @Autowired
    QuizRepo quizRepo;
    public ResponseEntity<Integer> calculateScore(SubmitQuiz submit) {
        int score = 0;
        Quiz quiz = quizRepo.findById(submit.getQuizId()).orElse(null);
        if(quiz!=null)
        {
            List<Question> quizQuestions= quiz.getQuestions();
            List<QuestionAnswers> answers = submit.getAnswers();
            Map<Integer,String> quesIds = new HashMap<>();
            for(QuestionAnswers ans:answers){
                int id = ans.getQuestionId();
                String res = ans.getAnswer();
                if(quesIds.get(id) == null) {
                    quesIds.put(id, res);
                    Question question = (Question) quizQuestions.stream().filter(q -> q.getId() == id).findFirst().orElse(null);
                    if (question != null && question.getCorrectAnswer().equals(res)) {
                        score++;
                    }
                }
            }
            return new ResponseEntity<>(score, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(score, HttpStatus.BAD_REQUEST);}
}
