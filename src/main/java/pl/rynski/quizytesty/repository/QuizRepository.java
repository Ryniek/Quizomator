package pl.rynski.quizytesty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.rynski.quizytesty.model.Quiz;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    Quiz findFirstByAuthorOrderByIdDesc(String author);

    List<Quiz> findAllByAuthorOrderByQuizDate(String author);
}
