package mk.ukim.finki.restaurantreviewapp.service;

import mk.ukim.finki.restaurantreviewapp.model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> listAllByRestaurant(Long RestaurantId);

    Review createReview(Long restaurantId, float rating, String comment);

    Review editReview(Long id, float rating, String comment);

    Review deleteReview(Long id);
}
