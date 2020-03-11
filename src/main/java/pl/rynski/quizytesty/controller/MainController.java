package pl.rynski.quizytesty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.rynski.quizytesty.account.AppUser;
import pl.rynski.quizytesty.account.AppUserDto;
import pl.rynski.quizytesty.service.UserService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MainController {

    private UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("appUserDto", new AppUserDto());
        return "registration";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute AppUserDto appUserDto,
                           BindingResult bindingResult,
                           HttpServletRequest request) throws MessagingException {
        if(bindingResult.hasErrors()) {
            return "registration";
        }
        userService.addNewUser(appUserDto, request);
        return "redirect:/login";
    }

    @GetMapping("/verify-token")
    public String verifyToken(@RequestParam String token) {
        userService.verifyToken(token);
        return "accountVerified";
    }
}
