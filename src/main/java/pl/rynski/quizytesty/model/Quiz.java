package pl.rynski.quizytesty.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private LocalDateTime quizDate;
    private Integer correctAnswers;
    private Integer wrongAnswers;
    private String categories;

    public Quiz() {
        quizDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return quizDate.format(formatter);
    }

    public LocalDateTime getQuizDate() {
        return quizDate;
    }

    public void setQuizDate(LocalDateTime quizDate) {
        this.quizDate = quizDate;
    }

    public Integer getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(Integer correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public Integer getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(Integer wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", quizDate=" + quizDate +
                ", correctAnswers=" + correctAnswers +
                ", wrongAnswers=" + wrongAnswers +
                ", categories='" + categories + '\'' +
                '}';
    }
}
