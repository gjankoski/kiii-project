package mk.ukim.finki.restaurantreviewapp.service;

import mk.ukim.finki.restaurantreviewapp.model.Category;
import mk.ukim.finki.restaurantreviewapp.model.Dtos.RestaurantDto;
import mk.ukim.finki.restaurantreviewapp.model.Location;
import mk.ukim.finki.restaurantreviewapp.model.Restaurant;
import mk.ukim.finki.restaurantreviewapp.model.Review;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> listAll();

    Restaurant findById(Long id);

    Restaurant create(String name, String description, boolean delivery, int price, String address, String city, String country, Long categoryId);

    Restaurant create(RestaurantDto restaurantDto);

    Restaurant update(Long id, String name, String description, boolean delivery, int price, String address, String city, String country, Long categoryId);

    Restaurant update(Long id, RestaurantDto restaurantDto);

    void delete(Long id);

    List<Restaurant> listTopRatedRestaurants();

    List<Restaurant> listCheapestRestaurants();

    List<Restaurant> listExpensiveRestaurants();

    List<Restaurant> searchByName(String name);

    List<Restaurant> findAllByReviews();

}
