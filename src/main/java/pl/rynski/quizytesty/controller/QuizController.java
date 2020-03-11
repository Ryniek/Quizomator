package pl.rynski.quizytesty.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.rynski.quizytesty.quiz.Category;
import pl.rynski.quizytesty.quiz.Question;
import pl.rynski.quizytesty.quiz.QuizService;
import pl.rynski.quizytesty.repository.QuestionRepostiory;
import pl.rynski.quizytesty.thymeleaf.CategoryDto;

import java.util.List;
import java.util.Optional;

@Controller
public class QuizController {

    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/getQuestionsForQuiz")
    @ResponseBody
    public String getQuestionsForQuiz() throws JsonProcessingException {
        List<Question> question = quizService.findAllAccepted();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(question);
        return jsonString;
    }

    @GetMapping("/quiz/{quantity}")
    public String getQuiz(@PathVariable int quantity, Model model) {

        model.addAttribute("categories", new CategoryDto());
        return "quiz";
    }
}
