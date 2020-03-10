package pl.rynski.quizytesty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.rynski.quizytesty.quiz.Category;
import pl.rynski.quizytesty.quiz.CategoryService;
import pl.rynski.quizytesty.quiz.Question;
import pl.rynski.quizytesty.quiz.QuestionService;

import java.security.Principal;

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
    public String addPublicQuestion(@ModelAttribute Question question, Principal principal) {
        questionService.addPublicQuestion(question, principal.getName());
        return "redirect:/addPublicQuestion";
    }

    @GetMapping("/addPrivateQuestion")
    public String getPrivateQuestionPanel(Model model, Principal principal) {
        model.addAttribute("question", new Question());
        model.addAttribute("privateCategoryList", categoryService.getPrivateCategories(principal.getName()));
        return "addPrivateQuestion";
    }

    @PostMapping("/addPrivateQuestion")
    public String addPrivateQuestion(@ModelAttribute Question question, Principal principal) {
        questionService.addPrivateQuestion(question, principal.getName());
        return "redirect:/addPrivateQuestion";
    }

    @GetMapping("/addCategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addCategory";
    }

    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute Category category, Principal principal) {
        categoryService.addCategory(category, principal.getName());
        return "redirect:/addCategory";
    }
}
