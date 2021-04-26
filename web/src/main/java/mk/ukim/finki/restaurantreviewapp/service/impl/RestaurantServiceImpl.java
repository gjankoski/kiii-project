package mk.ukim.finki.restaurantreviewapp.service.impl;

import mk.ukim.finki.restaurantreviewapp.Repository.CategoryRepository;
import mk.ukim.finki.restaurantreviewapp.Repository.LocationRepository;
import mk.ukim.finki.restaurantreviewapp.Repository.RestaurantRepository;
import mk.ukim.finki.restaurantreviewapp.Repository.ReviewRepository;
import mk.ukim.finki.restaurantreviewapp.model.Category;
import mk.ukim.finki.restaurantreviewapp.model.Dtos.RestaurantDto;
import mk.ukim.finki.restaurantreviewapp.model.Review;
import mk.ukim.finki.restaurantreviewapp.model.exceptions.InvalidCategoryException;
import mk.ukim.finki.restaurantreviewapp.model.exceptions.InvalidLocationException;
import mk.ukim.finki.restaurantreviewapp.model.exceptions.InvalidRestaurantException;
import mk.ukim.finki.restaurantreviewapp.model.Location;
import mk.ukim.finki.restaurantreviewapp.model.Restaurant;
import mk.ukim.finki.restaurantreviewapp.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

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
        Restaurant restaurant = new Restaurant(name,description,delivery, price, location, category);
        this.restaurantRepository.save(restaurant);
        return restaurant;
    }

    @Override
    public Restaurant create(RestaurantDto restaurantDto) {
        Location location = this.locationRepository.findById(restaurantDto.getLocationId()).orElseThrow(InvalidLocationException::new);
        Category category = this.categoryRepository.findById(restaurantDto.getCategoryId()).orElseThrow(InvalidCategoryException::new);
        Restaurant restaurant = new Restaurant(restaurantDto.getName(), restaurantDto.getDescription(),
                restaurantDto.isDelivery(), restaurantDto.getPrice(), location, category);
        this.restaurantRepository.save(restaurant);
        return restaurant;
    }

    @Override
    public Restaurant update(Long id, RestaurantDto restaurantDto) {
        Restaurant restaurant = this.restaurantRepository.findById(id).orElseThrow(InvalidRestaurantException::new);
        Location location = this.locationRepository.findById(restaurantDto.getLocationId()).orElseThrow(InvalidLocationException::new);
        Category category = this.categoryRepository.findById(restaurantDto.getCategoryId()).orElseThrow(InvalidCategoryException::new);
        restaurant.setName(restaurantDto.getName());
        restaurant.setDescription(restaurantDto.getDescription());
        restaurant.setDelivery(restaurantDto.isDelivery());
        restaurant.setPrice(restaurant.getPrice());
        restaurant.setLocation(location);
        restaurant.setCategory(category);
        this.restaurantRepository.save(restaurant);
        return restaurant;

    }

    @Override
    public Restaurant update(Long id, String name, String description, boolean delivery, int price, Long locationId, Long categoryId) {
        Restaurant restaurant = this.restaurantRepository.findById(id).orElseThrow(InvalidRestaurantException::new);
        Location location = this.locationRepository.findById(locationId).orElseThrow(InvalidLocationException::new);
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(InvalidCategoryException::new);
        restaurant.setName(name);
        restaurant.setDescription(description);
        restaurant.setDelivery(delivery);
        restaurant.setPrice(price);
        restaurant.setLocation(location);
        restaurant.setCategory(category);
        this.restaurantRepository.save(restaurant);
        return restaurant;

    }

    @Override
    public void delete(Long id) {
        this.restaurantRepository.deleteById(id);
    }

    @Override
    public List<Restaurant> listTopRatedRestaurants() {
        List<Restaurant> restaurants = this.restaurantRepository.findAll();
        for(Restaurant restaurant : restaurants)
        {
            List<Review> reviews = restaurant.getReviews();
            Double sum = 0.0;
            int count = 0;
            for(Review review : reviews)
            {
                count++;
                sum+=review.getRating();
            }
            restaurant.setRating(sum/count);
        }
        Comparator<Restaurant> comparator = Comparator.comparing(Restaurant::getRating);
        restaurants.sort(comparator.reversed());
        return restaurants.stream().limit(4).collect(Collectors.toList());
    }

    @Override
    public List<Restaurant> listCheapestRestaurants() {
        return null;
    }

    @Override
    public List<Restaurant> listExpensiveRestaurants() {
        return null;
    }

    @Override
    public List<Restaurant> searchByName(String name) {
        return this.restaurantRepository.findAllByNameLike("%" + name + "%");
    }
}
