package pl.rynski.quizytesty.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rynski.quizytesty.repository.CategoryRepository;
import pl.rynski.quizytesty.repository.QuestionRepostiory;

import java.util.List;

@Service
public class QuizService {

    private QuestionRepostiory questionRepostiory;
    private CategoryRepository categoryRepository;

    @Autowired
    public QuizService(QuestionRepostiory questionRepostiory, CategoryRepository categoryRepository) {
        this.questionRepostiory = questionRepostiory;
        this.categoryRepository = categoryRepository;
    }

    public List<Question> findAllAccepted() {
        return questionRepostiory.findAllAccepted();
    }
}
