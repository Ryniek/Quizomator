package pl.rynski.quizytesty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.quizytesty.quiz.Question;

@Repository
public interface QuestionRepostiory extends JpaRepository<Question, Long> {

    Question findByAuthor(String author);
}
