package pl.rynski.quizytesty.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.rynski.quizytesty.model.Question;
import pl.rynski.quizytesty.model.Quiz;
import pl.rynski.quizytesty.service.CategoryService;
import pl.rynski.quizytesty.service.QuizService;
import pl.rynski.quizytesty.thymeleaf.QuizDto;
import pl.rynski.quizytesty.thymeleaf.QuizResultDto;

import java.security.Principal;
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
    public String chooseQuiz(@ModelAttribute QuizDto quizDto, Model model, Principal principal) {
        quizService.startQuiz(quizDto, principal.getName());
        model.addAttribute("quizDto", quizDto);
        return "quiz";
    }

    @GetMapping("/summarizeQuiz")
    public String summarizing(Model model, Principal principal) {
        Quiz result = quizService.showSummarize(principal.getName());
        model.addAttribute("result", result);
        return "summarizeQuiz";
    }

    @PostMapping("/summarizeQuiz")
    @ResponseBody
    public ResponseEntity summarizeQuiz(@RequestBody QuizResultDto quizResultDto, Principal principal) {
        System.out.println(quizResultDto);
        System.out.println("---------");
        System.out.println(quizService.summarizeQuiz(quizResultDto, principal.getName()));
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/quizHistory")
    public String getQuizHistory(Model model, Principal principal) {
        List<Quiz> quizHistory = quizService.getQuizHistory(principal.getName());
        model.addAttribute("quizHistory", quizHistory);
        return "quizHistory";
    }

}
