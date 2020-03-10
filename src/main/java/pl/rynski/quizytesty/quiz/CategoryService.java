package pl.rynski.quizytesty.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rynski.quizytesty.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getPublicCategories() {
        return categoryRepository.findAllByAuthor("GLOBAL");
    }

    public List<Category> getPrivateCategories(String author) {
        return categoryRepository.findAllByAuthor(author);
    }

    public void addCategory(Category category, String author) {
        category.setAuthor(author);
        categoryRepository.save(category);
    }
}
