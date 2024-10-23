package in.rupam.QuizApp.service;

import in.rupam.QuizApp.model.*;
import in.rupam.QuizApp.repository.QuestionsRepo;
import in.rupam.QuizApp.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuestionsRepo questionsRepo;

    @Autowired
    QuizRepo quizRepo;
    public ResponseEntity<String> addQuiz(QuizCreateBody quizbody) {
        quizbody.setCategory(quizbody.getCategory().substring(0, 1).toUpperCase()+quizbody.getCategory().substring(1));
        List<Question> quizQuestions= questionsRepo.getRandomQuestion(quizbody.getCategory(),quizbody.getNoOfQuestions());
        Quiz quiz = new Quiz();
        quiz.setCategory(quizbody.getCategory());
        quiz.setTitle(quizbody.getTitle());
        quiz.setQuestions(quizQuestions);
        Quiz savedQuiz = quizRepo.save(quiz);
        if(savedQuiz!=null){
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuizResponse>> getAllQuiz() {
        List<Quiz> quizes = quizRepo.findAll();
        List <QuizResponse> quizResponses= new ArrayList();
        for(Quiz quiz : quizes){
            List<Question> questions = quiz.getQuestions();
            List<QuestionResponse> questionResponses = new ArrayList<>();
            QuizResponse quizRes = new QuizResponse();
            quizRes.setQuizId(quiz.getId());
            quizRes.setCategory(quiz.getCategory());
            quizRes.setTitle(quiz.getTitle());
            for(Question question: questions) {
                QuestionResponse qres = new QuestionResponse();
                qres.setQuestionId(question.getId());
                qres.setDescription(question.getDescription());
                qres.setOption1(question.getOption1());
                qres.setOption2(question.getOption2());
                qres.setOption3(question.getOption3());
                qres.setOption4(question.getOption4());
                questionResponses.add(qres);
            }
            quizRes.setQuestions(questionResponses);
            quizResponses.add(quizRes);
        }
        return new ResponseEntity<>(quizResponses, HttpStatus.OK);
    }

    public ResponseEntity<QuizResponse> getQuizById(int id) {
        Quiz quiz = quizRepo.findById(id).orElse(null);
        if(quiz!=null){
            QuizResponse quizRes = new QuizResponse();
            quizRes.setQuizId(quiz.getId());
            quizRes.setCategory(quiz.getCategory());
            quizRes.setTitle(quiz.getTitle());

            List<Question> questions = quiz.getQuestions();
            List<QuestionResponse> questionResponses = new ArrayList<>();
            for(Question question: questions) {
                QuestionResponse qres = new QuestionResponse();
                qres.setQuestionId(question.getId());
                qres.setDescription(question.getDescription());
                qres.setOption1(question.getOption1());
                qres.setOption2(question.getOption2());
                qres.setOption3(question.getOption3());
                qres.setOption4(question.getOption4());
                questionResponses.add(qres);
            }
            quizRes.setQuestions(questionResponses);
            return new ResponseEntity<>(quizRes, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
}
