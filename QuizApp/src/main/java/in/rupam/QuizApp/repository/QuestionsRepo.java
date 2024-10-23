package in.rupam.QuizApp.repository;

import in.rupam.QuizApp.model.Question;
import in.rupam.QuizApp.model.QuizCreateBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepo extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * From question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :noOfQuestions OFFSET 0", nativeQuery = true)
    List<Question> getRandomQuestion(String category, Integer noOfQuestions);
}
