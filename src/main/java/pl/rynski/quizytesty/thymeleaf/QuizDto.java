package pl.rynski.quizytesty.thymeleaf;

public class QuizDto {

    private int quantity;
    private String categoryList;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(String categoryList) {
        this.categoryList = categoryList;
    }

}
