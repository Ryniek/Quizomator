package pl.rynski.quizytesty.thymeleaf;

public class QuizResultDto {
    private String questions;
    private String correctAnswers;
    private String categories;

    public QuizResultDto() {
    }

    public QuizResultDto(String questions, String correctAnswers) {
        this.questions = questions;
        this.correctAnswers = correctAnswers;
    }

    public String getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(String correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "QuizResultDto{" +
                "questions='" + questions + '\'' +
                ", correctAnswers='" + correctAnswers + '\'' +
                ", categories='" + categories + '\'' +
                '}';
    }
}
