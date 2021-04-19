package mk.ukim.finki.restaurantreviewapp.service;

import mk.ukim.finki.restaurantreviewapp.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> listAll();

    Category create(String name);

    Category findById(Long id);
}
