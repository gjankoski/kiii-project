package mk.ukim.finki.restaurantreviewapp.service.impl;

import mk.ukim.finki.restaurantreviewapp.Repository.CategoryRepository;
import mk.ukim.finki.restaurantreviewapp.model.Category;
import mk.ukim.finki.restaurantreviewapp.model.Exceptions.InvalidCategoryException;
import mk.ukim.finki.restaurantreviewapp.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category create(String name) {
        Category category = new Category(name);
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(InvalidCategoryException::new);
    }
}
