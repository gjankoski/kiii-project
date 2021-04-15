package mk.ukim.finki.restaurantreviewapp.service.impl;

import mk.ukim.finki.restaurantreviewapp.Repository.CategoryRepository;
import mk.ukim.finki.restaurantreviewapp.Repository.LocationRepository;
import mk.ukim.finki.restaurantreviewapp.Repository.RestaurantRepository;
import mk.ukim.finki.restaurantreviewapp.Repository.ReviewRepository;
import mk.ukim.finki.restaurantreviewapp.model.Category;
import mk.ukim.finki.restaurantreviewapp.model.Exceptions.InvalidCategoryException;
import mk.ukim.finki.restaurantreviewapp.model.Exceptions.InvalidLocationException;
import mk.ukim.finki.restaurantreviewapp.model.Exceptions.InvalidRestaurantException;
import mk.ukim.finki.restaurantreviewapp.model.Location;
import mk.ukim.finki.restaurantreviewapp.model.Restaurant;
import mk.ukim.finki.restaurantreviewapp.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final CategoryRepository categoryRepository;
    private final LocationRepository locationRepository;
    private final ReviewRepository reviewRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, CategoryRepository categoryRepository,
                                 LocationRepository locationRepository, ReviewRepository reviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.categoryRepository = categoryRepository;
        this.locationRepository = locationRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Restaurant> listAll() {
        return this.restaurantRepository.findAll();
    }

    @Override
    public Restaurant findById(Long id) {
        return this.restaurantRepository.findById(id).orElseThrow(InvalidRestaurantException::new);
    }

    @Override
    public Restaurant create(String name, String description, boolean delivery, int price, Long locationId, Long categoryId) {
        Location location = this.locationRepository.findById(locationId).orElseThrow(InvalidLocationException::new);
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(InvalidCategoryException::new);
        return null;
    }

    @Override
    public Restaurant update(Long id, String name, String description, boolean delivery, int price, Long locationId, Long categoryId) {
        return null;
    }

    @Override
    public Restaurant delete(Long id) {
        return null;
    }

    @Override
    public List<Restaurant> listTopRatedRestaurants() {
        return null;
    }

    @Override
    public List<Restaurant> listCheapestRestaurants() {
        return null;
    }

    @Override
    public List<Restaurant> listExpensiveRestaurants() {
        return null;
    }
}
