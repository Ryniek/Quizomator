package pl.rynski.quizytesty.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rynski.quizytesty.repository.CategoryRepository;
import pl.rynski.quizytesty.repository.QuestionRepostiory;

@Service
public class QuestionService {

    private QuestionRepostiory questionRepostiory;
    private CategoryRepository categoryRepository;

    @Autowired
    public QuestionService(QuestionRepostiory questionRepostiory, CategoryRepository categoryRepository) {
        this.questionRepostiory = questionRepostiory;
        this.categoryRepository = categoryRepository;
    }

    public void addQuestion(Question question, String author) {
        question.setAuthor(author);
        questionRepostiory.save(question);
    }
}
