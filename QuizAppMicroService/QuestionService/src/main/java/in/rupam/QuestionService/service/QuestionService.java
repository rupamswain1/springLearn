package in.rupam.QuestionService.service;

import in.rupam.QuestionService.model.Question;
import in.rupam.QuestionService.model.QuestionAnswers;
import in.rupam.QuestionService.model.QuestionResponse;
import in.rupam.QuestionService.repository.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionService {

    @Autowired
    QuestionsRepo questionsRepo;
    public List<Question> getAllQuestiosn() {
        return questionsRepo.findAll();
    }

    public List<Question> getByCategory(String category) {
        return questionsRepo.findByCategory(category.substring(0, 1).toUpperCase()+category.substring(1));
    }

    public Question save(Question question) {
        return questionsRepo.save(question);
    }

    public ResponseEntity<List<Integer>> generateQuestions(String category, int numberOfQuestions) {
        List<Question> quizQuestions= questionsRepo.getRandomQuestion(category,numberOfQuestions);
        List<Integer> questionIds = new ArrayList<>();
        for(Question question:quizQuestions){
            questionIds.add(question.getId());
        }
        return new ResponseEntity<>(questionIds, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionResponse>> getAllQuestionsById(List<Integer> ids) {
        List<Question> questions = questionsRepo.findAllById(ids);
        List <QuestionResponse> quesResponses= new ArrayList();
        for(Question question: questions) {
            QuestionResponse qres = new QuestionResponse();
            qres.setQuestionId(question.getId());
            qres.setDescription(question.getDescription());
            qres.setOption1(question.getOption1());
            qres.setOption2(question.getOption2());
            qres.setOption3(question.getOption3());
            qres.setOption4(question.getOption4());
            quesResponses.add(qres);
        }
        return new ResponseEntity<>(quesResponses,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateScore(List<QuestionAnswers> answers) {
        int score = 0;
            Map<Integer,String> quesIds = new HashMap<>();
            for(QuestionAnswers ans:answers){
                int id = ans.getQuestionId();
                String res = ans.getAnswer();
                if(quesIds.get(id) == null) {
                    quesIds.put(id, res);
                    Question question = (Question) questionsRepo.findById(id).orElse(null);
                    if (question != null && question.getCorrectAnswer().equals(res)) {
                        score++;
                    }
                }
            }
            return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
