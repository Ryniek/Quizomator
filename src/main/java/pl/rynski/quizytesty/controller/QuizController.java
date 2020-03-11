package pl.rynski.quizytesty.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.rynski.quizytesty.quiz.Question;
import pl.rynski.quizytesty.repository.QuestionRepostiory;

import java.util.List;
import java.util.Optional;

@Controller
public class QuizController {

    private QuestionRepostiory questionRepostiory;

    @Autowired
    public QuizController(QuestionRepostiory questionRepostiory) {
        this.questionRepostiory = questionRepostiory;
    }

    @GetMapping("/getQuestionsForQuiz")
    @ResponseBody
    public String getQuestionsForQuiz() throws JsonProcessingException {
        List<Question> question = questionRepostiory.findAllAccepted();
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(question);
        return jsonString;
    }
}
