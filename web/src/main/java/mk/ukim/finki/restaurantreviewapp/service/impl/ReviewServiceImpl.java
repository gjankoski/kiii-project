package mk.ukim.finki.restaurantreviewapp.service.impl;

import mk.ukim.finki.restaurantreviewapp.Repository.RestaurantRepository;
import mk.ukim.finki.restaurantreviewapp.Repository.ReviewRepository;
import mk.ukim.finki.restaurantreviewapp.model.Dtos.ReviewDto;
import mk.ukim.finki.restaurantreviewapp.model.exceptions.InvalidRestaurantException;
import mk.ukim.finki.restaurantreviewapp.model.exceptions.InvalidReviewException;
import mk.ukim.finki.restaurantreviewapp.model.Restaurant;
import mk.ukim.finki.restaurantreviewapp.model.Review;
import mk.ukim.finki.restaurantreviewapp.service.ReviewService;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public Review createReview(Long restaurantId, Double rating, String comment) {
        Restaurant restaurant = this.restaurantRepository.findById(restaurantId).orElseThrow(InvalidRestaurantException::new);
        Review review = new Review(rating);
        if (comment != null && !comment.isEmpty())
            review.setComment(comment);
        this.reviewRepository.save(review);
        restaurant.getReviews().add(review);
        this.restaurantRepository.save(restaurant);
        return review;

    }

    @Override
    public Review createReview(Long restaurantId, ReviewDto reviewDto) {
        Restaurant restaurant = this.restaurantRepository.findById(restaurantId).orElseThrow(InvalidRestaurantException::new);
        Review review = new Review(reviewDto.getRating());
        if (reviewDto.getComment() != null && !reviewDto.getComment().isEmpty())
            review.setComment(reviewDto.getComment());
        this.reviewRepository.save(review);
        restaurant.getReviews().add(review);
        this.restaurantRepository.save(restaurant);
        return review;
    }

    @Override
    public Review editReview(Long restaurantId, Long id, ReviewDto reviewDto) {
        Restaurant restaurant = this.restaurantRepository.findById(restaurantId).orElseThrow(InvalidRestaurantException::new);
        Review review = this.reviewRepository.findById(id).orElseThrow(InvalidReviewException::new);
        restaurant.getReviews().remove(review);
        review.setRating(reviewDto.getRating());
        if(reviewDto.getComment() != null && !reviewDto.getComment().isEmpty())
            review.setComment(reviewDto.getComment());
        this.reviewRepository.save(review);
        restaurant.getReviews().add(review);
        return review;
    }

    @Override
    public Review editReview(Long restaurantId, Long id, Double rating, String comment) {
        Restaurant restaurant = this.restaurantRepository.findById(restaurantId).orElseThrow(InvalidRestaurantException::new);
        Review review = this.reviewRepository.findById(id).orElseThrow(InvalidReviewException::new);
        restaurant.getReviews().remove(review);
        review.setRating(rating);
        if(comment != null && !comment.isEmpty())
            review.setComment(comment);
        this.reviewRepository.save(review);
        restaurant.getReviews().add(review);
        return review;
    }

    @Override
    public void deleteReview(Long restaurantId, Long id) {
        Restaurant restaurant = this.restaurantRepository.findById(restaurantId).orElseThrow(InvalidRestaurantException::new);
        Review review = this.reviewRepository.findById(id).orElseThrow(InvalidReviewException::new);
        restaurant.getReviews().remove(review);
        this.reviewRepository.deleteById(id);
    }

    @Override
    public Review findById(Long id) {
        return this.reviewRepository.findById(id).orElseThrow(InvalidReviewException::new);
    }
}
