package pl.rynski.quizytesty.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/test")
public class TestApi {

    @GetMapping("/users")
    public String forUser() {
        return "home";
    }
}
