package mk.ukim.finki.restaurantreviewapp.service;

import mk.ukim.finki.restaurantreviewapp.model.Review;

import java.util.List;

public interface ReviewService {

    Review findById(Long id);

    List<Review> listAllByRestaurant(Long restaurantId);

    Review createReview(Long restaurantId, float rating, String comment);

    Review editReview(Long restaurantId, Long id, float rating, String comment);

    Review deleteReview(Long restaurantId, Long id);
}
