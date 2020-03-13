package pl.rynski.quizytesty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rynski.quizytesty.service.QuestionService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private QuestionService questionService;

    @Autowired
    public AdminController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/checkQuestions")
    public String getAdminPanel(Model model) {
        model.addAttribute("unacceptedQuestions", questionService.getUnacceptedQuestions());
        return "checkQuestions";
    }

    @GetMapping("/acceptQuestion/{id}")
    public String acceptQuestion(@PathVariable Long id) {
        questionService.acceptQuestion(id);
        return "redirect:/admin/checkQuestions";
    }

    @GetMapping("/rejectQuestion/{id}")
    public String rejectQuestion(@PathVariable Long id) {
        questionService.rejectQuestion(id);
        return "redirect:/admin/checkQuestions";
    }
}
