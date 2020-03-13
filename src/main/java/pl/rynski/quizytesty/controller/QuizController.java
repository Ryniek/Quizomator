package pl.rynski.quizytesty.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.rynski.quizytesty.model.Question;
import pl.rynski.quizytesty.service.CategoryService;
import pl.rynski.quizytesty.service.QuizService;
import pl.rynski.quizytesty.thymeleaf.QuizDto;

import java.util.List;

@Controller
public class QuizController {

    private QuizService quizService;
    private CategoryService categoryService;

    @Autowired
    public QuizController(QuizService quizService, CategoryService categoryService) {
        this.quizService = quizService;
        this.categoryService = categoryService;
    }

    @GetMapping("/getQuestionsForQuiz")
    @ResponseBody
    public String getQuestionsForQuiz(@RequestParam int numberOfQuestions, @RequestParam List<String> categories) throws JsonProcessingException {
        List<Question> questions = quizService.drawQuestions(numberOfQuestions, categories);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(questions);
        return jsonString;
    }

    @GetMapping("/quiz-panel")
    public String getQuizPanel(Model model) {
        model.addAttribute("quizDto", new QuizDto());
        model.addAttribute("publicCategoryList", categoryService.getPublicCategories());
        return "chooseQuiz";
    }

    @PostMapping("/chooseQuiz")
    public String chooseQuiz(@ModelAttribute QuizDto quizDto, Model model) {
        model.addAttribute("quizDto", quizDto);
        return "quiz";
    }
}
