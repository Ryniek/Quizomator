package pl.rynski.quizytesty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rynski.quizytesty.model.Category;
import pl.rynski.quizytesty.model.Question;
import pl.rynski.quizytesty.repository.CategoryRepository;
import pl.rynski.quizytesty.repository.QuestionRepostiory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    public List<Question> drawQuestions(int quantity, List<String> categories) {
        List<Question> questions = questionRepostiory.findQuestionsByCategory(categories);
        return getRandomElement(questions, quantity);
    }

    private List<Question> getRandomElement(List<Question> list, int totalItems)
    {
        Random rand = new Random();
        List<Question> newList = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {
            int randomIndex = rand.nextInt(list.size());

            newList.add(list.get(randomIndex));

            list.remove(randomIndex);
        }
        return newList;
    }
}
