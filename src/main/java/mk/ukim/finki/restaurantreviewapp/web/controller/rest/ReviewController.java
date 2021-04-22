package mk.ukim.finki.restaurantreviewapp.web.controller.rest;


import mk.ukim.finki.restaurantreviewapp.model.Dtos.ReviewDto;
import mk.ukim.finki.restaurantreviewapp.model.Exceptions.InvalidRestaurantException;
import mk.ukim.finki.restaurantreviewapp.model.Exceptions.InvalidReviewException;
import mk.ukim.finki.restaurantreviewapp.model.Review;
import mk.ukim.finki.restaurantreviewapp.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/reviews")

public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<List<Review>> findAllByRestaurant(@PathVariable Long restaurantId)
    {
        try {
            List<Review> reviews = this.reviewService.listAllByRestaurant(restaurantId);
            return ResponseEntity.ok().body(reviews);
        }
        catch (InvalidRestaurantException invalidRestaurantException)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add/{restaurantId}")
    public ResponseEntity<Review> create(@PathVariable Long restaurantId, @RequestBody ReviewDto reviewDto)
    {
        try {
            Review review = this.reviewService.createReview(restaurantId,reviewDto);
            return ResponseEntity.ok().body(review);
        }
        catch (InvalidRestaurantException invalidRestaurantException)
        {
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("edit/{restaurantId}/{id}")
    public ResponseEntity<Review> edit(@PathVariable Long restaurantId, @PathVariable Long id,
                                       @RequestBody ReviewDto reviewDto)
    {
        try {
            Review review = this.reviewService.editReview(restaurantId, id, reviewDto);
            return ResponseEntity.ok().body(review);
        }
        catch (InvalidRestaurantException | InvalidReviewException exception)
        {
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/delete/{restaurantId}/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long restaurantId, @PathVariable Long id)
    {
        try {
            this.reviewService.deleteReview(restaurantId, id);
            return ResponseEntity.ok().build();
        }
        catch (InvalidRestaurantException | InvalidReviewException exception)
        {
            return ResponseEntity.badRequest().build();
        }

    }

}
