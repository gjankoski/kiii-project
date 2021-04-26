package mk.ukim.finki.restaurantreviewapp.web.controller;


import mk.ukim.finki.restaurantreviewapp.model.Review;
import mk.ukim.finki.restaurantreviewapp.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews/{restaurantId}")
    public String getReviews(@PathVariable Long restaurantId)
    {
        this.reviewService.listAllByRestaurant(restaurantId);
        return "restaurant-page.html";
    }

    @GetMapping("/reviews/{restaurantId}/add")
    public String showAddReview(@PathVariable Long restaurantId)
    {
        return "review-page.html";
    }
    @GetMapping("reviews/{restaurantId}/edit/{id}")
    public String showEditReview(@PathVariable Long restaurantId, @PathVariable Long id, Model model)
    {
        Review review = this.reviewService.findById(id);
        model.addAttribute("review", review);
        return "review-page.html";
    }

    @PostMapping("reviews/{restaurantId}/add")
    public String addReview(@PathVariable Long restaurantId, @RequestParam Double rating, @RequestParam(required = false) String comment)
    {
        if(comment != null && !comment.isEmpty()) {
            this.reviewService.createReview(restaurantId,rating,comment);
            return "redirect:/restaurant-page.html";
        }
        this.reviewService.createReview(restaurantId, rating);
        return "redirect:/restaurant-page.html";
    }
    @PostMapping("/reviews/{restaurantId}/edit/{id}")
    public String editReview(@PathVariable Long restaurantId, @PathVariable Long id, @RequestParam Double rating, @RequestParam(required = false) String comment)
    {
        if(comment != null && !comment.isEmpty()) {
            this.reviewService.editReview(restaurantId, id, rating, comment);
            return "redirect:/restaurant-page.html";
        }
        this.reviewService.editReview(restaurantId, id, rating);
        return "redirect:/restaurant-page.html";
    }
    @DeleteMapping("/reviews/{restaurantId}/delete/{id}")
    public String deleteReview(@PathVariable Long restaurantId, @PathVariable Long id)
    {
        this.deleteReview(restaurantId, id);
        return "redirect:/restaurant-page.html";
    }
}