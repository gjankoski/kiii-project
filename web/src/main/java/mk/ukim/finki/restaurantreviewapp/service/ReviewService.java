package mk.ukim.finki.restaurantreviewapp.service;

import mk.ukim.finki.restaurantreviewapp.model.Dtos.ReviewDto;
import mk.ukim.finki.restaurantreviewapp.model.Review;

import java.util.List;

public interface ReviewService {

    Review findById(Long id);

    List<Review> listAllByRestaurant(Long restaurantId);

    Review createReview(Long restaurantId, Double rating, String comment);

    Review createReview(Long restaurantId, Double rating);

    Review createReview(Long restaurantId, ReviewDto reviewDto);

    Review editReview(Long restaurantId, Long id, Double rating, String comment);

    Review editReview(Long restaurantId, Long id, Double rating);

    Review editReview(Long restaurantId, Long id, ReviewDto reviewDto);

    void deleteReview(Long restaurantId, Long id);
}
