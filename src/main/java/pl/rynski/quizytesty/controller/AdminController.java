package pl.rynski.quizytesty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.rynski.quizytesty.quiz.QuestionService;

@Controller
public class AdminController {

    private QuestionService questionService;

    @Autowired
    public AdminController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/confirmQuestions")
    public String getAdminPanel(Model model) {
        model.addAttribute("unacceptedQuestions", questionService.getUnacceptedQuestions());
        return "confirmQuestions";
    }
}
