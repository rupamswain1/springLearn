package in.rupam.QuizService.repository;

import in.rupam.QuizService.model.QuizWithIds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<QuizWithIds, Integer> {

}
