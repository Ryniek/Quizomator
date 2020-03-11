package pl.rynski.quizytesty.thymeleaf;

import pl.rynski.quizytesty.quiz.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {

    private List<Category> categoryList = new ArrayList<>();

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
