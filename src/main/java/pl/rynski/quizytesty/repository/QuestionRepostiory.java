package pl.rynski.quizytesty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.rynski.quizytesty.quiz.Question;

import java.util.List;

@Repository
public interface QuestionRepostiory extends JpaRepository<Question, Long> {

    Question findByAuthor(String author);

    @Query("SELECT q FROM Question q WHERE q.isAccepted = false")
    List<Question> findAllUnaccepted();

    @Query("SELECT q FROM Question q WHERE q.isAccepted = true")
    List<Question> findAllAccepted();
}
