package in.rupam.QuizService.service;

import in.rupam.QuizService.feign.QuizInterface;
import in.rupam.QuizService.model.*;
import in.rupam.QuizService.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizInterface questionsRepo;

    @Autowired
    QuizRepo quizRepo;
    public ResponseEntity<String> addQuiz(QuizCreateBody quizbody) {
        quizbody.setCategory(quizbody.getCategory().substring(0, 1).toUpperCase()+quizbody.getCategory().substring(1));
        List<Integer> quizQuestions= questionsRepo.generateQuestion(quizbody.getCategory(),quizbody.getNoOfQuestions()).getBody();
        QuizWithIds quiz = new QuizWithIds();
        quiz.setCategory(quizbody.getCategory());
        quiz.setTitle(quizbody.getTitle());
        quiz.setQuestions(quizQuestions);
        QuizWithIds savedQuiz = quizRepo.save(quiz);
        if(savedQuiz!=null){
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuizResponse>> getAllQuiz() {
        List<QuizWithIds> quizes = quizRepo.findAll();
        List <QuizResponse> quizResponses= new ArrayList();
        for(QuizWithIds quiz : quizes){
            List<Integer> questions = quiz.getQuestions();
            List<QuestionResponse> questionResponse = questionsRepo.getQuestionsById(questions).getBody();
            QuizResponse quizRes = new QuizResponse();
            quizRes.setQuizId(quiz.getId());
            quizRes.setCategory(quiz.getCategory());
            quizRes.setTitle(quiz.getTitle());
            quizRes.setQuestions(questionResponse);
            quizResponses.add(quizRes);
        }
        return new ResponseEntity<>(quizResponses, HttpStatus.OK);
    }

    public ResponseEntity<QuizResponse> getQuizById(int id) {
        QuizWithIds quiz = quizRepo.findById(id).orElse(null);
        if(quiz!=null){
            QuizResponse quizRes = new QuizResponse();
            quizRes.setQuizId(quiz.getId());
            quizRes.setCategory(quiz.getCategory());
            quizRes.setTitle(quiz.getTitle());

            List<Integer> questions = quiz.getQuestions();
            List<QuestionResponse> questionResponses = questionsRepo.getQuestionsById(questions).getBody();
            quizRes.setQuestions(questionResponses);
            return new ResponseEntity<>(quizRes, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
}
