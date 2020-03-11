package pl.rynski.quizytesty.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rynski.quizytesty.repository.CategoryRepository;
import pl.rynski.quizytesty.repository.QuestionRepostiory;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private QuestionRepostiory questionRepostiory;
    private CategoryRepository categoryRepository;

    @Autowired
    public QuestionService(QuestionRepostiory questionRepostiory, CategoryRepository categoryRepository) {
        this.questionRepostiory = questionRepostiory;
        this.categoryRepository = categoryRepository;
    }

    public void addPublicQuestion(Question question, String author) {
        question.setAuthor(author);
        questionRepostiory.save(question);
    }

    public void addPrivateQuestion(Question question, String author) {
        question.setAuthor(author);
        question.setPrivate(true);
        question.setAccepted(true);
        questionRepostiory.save(question);
    }

    public List<Question> getUnacceptedQuestions() {
        return questionRepostiory.findAllUnaccepted();
    }

    public void acceptQuestion(Long id) {
        Optional<Question> question = questionRepostiory.findById(id);
        question.get().setAccepted(true);
        questionRepostiory.save(question.get());
    }

    public void rejectQuestion(Long id) {
        questionRepostiory.deleteById(id);
    }
}
