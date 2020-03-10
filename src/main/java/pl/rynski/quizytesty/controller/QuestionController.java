package pl.rynski.quizytesty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.rynski.quizytesty.quiz.Category;
import pl.rynski.quizytesty.quiz.CategoryService;
import pl.rynski.quizytesty.quiz.Question;
import pl.rynski.quizytesty.quiz.QuestionService;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class QuestionController {

    private CategoryService categoryService;
    private QuestionService questionService;

    @Autowired
    public QuestionController(CategoryService categoryService, QuestionService questionService) {
        this.categoryService = categoryService;
        this.questionService = questionService;
    }

    @GetMapping("/addPublicQuestion")
    public String getPublicQuestionPanel(Model model) {
        model.addAttribute("question", new Question());
        model.addAttribute("publicCategoryList", categoryService.getPublicCategories());
        return "addPublicQuestion";
    }

    @PostMapping("/addPublicQuestion")
    public String addQuestion(@ModelAttribute Question question, Principal principal) {
        questionService.addQuestion(question, principal.getName());
        return "redirect:/addPublicQuestion";
    }
}
