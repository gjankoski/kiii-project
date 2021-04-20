package mk.ukim.finki.restaurantreviewapp.service.impl;

import mk.ukim.finki.restaurantreviewapp.Repository.RestaurantRepository;
import mk.ukim.finki.restaurantreviewapp.Repository.ReviewRepository;
import mk.ukim.finki.restaurantreviewapp.model.Exceptions.InvalidRestaurantException;
import mk.ukim.finki.restaurantreviewapp.model.Exceptions.InvalidReviewException;
import mk.ukim.finki.restaurantreviewapp.model.Restaurant;
import mk.ukim.finki.restaurantreviewapp.model.Review;
import mk.ukim.finki.restaurantreviewapp.service.ReviewService;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Review> listAllByRestaurant(Long restaurantId) {
        Restaurant restaurant = this.restaurantRepository.findById(restaurantId).orElseThrow(InvalidRestaurantException::new);
        return restaurant.getReviews();
    }

    @Override
    public Review createReview(Long restaurantId, float rating, String comment) {
        Restaurant restaurant = this.restaurantRepository.findById(restaurantId).orElseThrow(InvalidRestaurantException::new);
        Review review = new Review(rating, comment);
        this.reviewRepository.save(review);
        restaurant.getReviews().add(review);
        this.restaurantRepository.save(restaurant);
        return review;


    }

    @Override
    public Review editReview(Long restaurantId, Long id, float rating, String comment) {
        Restaurant restaurant = this.restaurantRepository.findById(restaurantId).orElseThrow(InvalidRestaurantException::new);
        Review review = this.reviewRepository.findById(id).orElseThrow(InvalidReviewException::new);
        restaurant.getReviews().remove(review);
        review.setRating(rating);
        review.setComment(comment);
        this.reviewRepository.save(review);
        restaurant.getReviews().add(review);
        return review;
    }

    @Override
    public Review deleteReview(Long restaurantId, Long id) {
        Restaurant restaurant = this.restaurantRepository.findById(restaurantId).orElseThrow(InvalidRestaurantException::new);
        Review review = this.reviewRepository.findById(id).orElseThrow(InvalidReviewException::new);
        restaurant.getReviews().remove(review);
        this.reviewRepository.delete(review);
        return review;
    }

    @Override
    public Review findById(Long id) {
        return this.reviewRepository.findById(id).orElseThrow(InvalidReviewException::new);
    }
}
