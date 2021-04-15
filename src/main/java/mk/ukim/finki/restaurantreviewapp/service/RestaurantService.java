package mk.ukim.finki.restaurantreviewapp.service;

import mk.ukim.finki.restaurantreviewapp.model.Category;
import mk.ukim.finki.restaurantreviewapp.model.Location;
import mk.ukim.finki.restaurantreviewapp.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> listAll();

    Restaurant findById(Long id);

    Restaurant create(String name, String description, boolean delivery, int price, Long locationId, Long categoryId);

    Restaurant update(Long id, String name, String description, boolean delivery, int price, Long locationId, Long categoryId);

    Restaurant delete(Long id);

    List<Restaurant> listTopRatedRestaurants();

    List<Restaurant> listCheapestRestaurants();

    List<Restaurant> listExpensiveRestaurants();
}
