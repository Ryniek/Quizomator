package pl.rynski.quizytesty.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import pl.rynski.quizytesty.model.Question;
import pl.rynski.quizytesty.model.Quiz;
import pl.rynski.quizytesty.repository.QuestionRepostiory;
import pl.rynski.quizytesty.repository.QuizRepository;
import pl.rynski.quizytesty.thymeleaf.QuizDto;
import pl.rynski.quizytesty.thymeleaf.QuizResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Service
public class QuizService {

    private QuestionRepostiory questionRepostiory;
    private QuizRepository quizRepository;

    @Autowired
    public QuizService(QuestionRepostiory questionRepostiory, QuizRepository quizRepository) {
        this.questionRepostiory = questionRepostiory;
        this.quizRepository = quizRepository;
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

    public Quiz startQuiz(QuizDto quizDto, String author) {
        Quiz quiz = new Quiz();
        quiz.setAuthor(author);
        quiz.setCategories(quizDto.getCategoryList());
        quiz.setWrongAnswers(quizDto.getQuantity());
        quiz.setCorrectAnswers(0);
        return quizRepository.save(quiz);
    }

    public Quiz summarizeQuiz(QuizResultDto quizResultDto, String author) {
        Quiz quiz = quizRepository.findFirstByAuthorOrderByIdDesc(author);
        if(quizResultDto.getCorrectAnswers() == null)
            quizResultDto.setCorrectAnswers("0");
        quiz.setCorrectAnswers(Integer.parseInt(quizResultDto.getCorrectAnswers()));
        Integer wrongAnswers = Integer.parseInt(quizResultDto.getQuestions()) - Integer.parseInt(quizResultDto.getCorrectAnswers());
        quiz.setWrongAnswers(wrongAnswers);
        return quizRepository.save(quiz);
    }

    public Quiz showSummarize(String author) {
        return quizRepository.findFirstByAuthorOrderByIdDesc(author);
    }

    public List<Quiz> getQuizHistory(String author) {
        return quizRepository.findAllByAuthorOrderByQuizDate(author);
    }
}
