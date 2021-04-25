/*package mk.ukim.finki.restaurantreviewapp.web.controller;


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
        return "review-page.html"
    }
    @GetMapping("reviews/{restaurantId}/edit/{id}")
    public String showEditReview(@PathVariable Long restaurantId, @PathVariable Long id, Model model)
    {
        Review review = this.reviewService.findById(id);
        model.addAttribute("review", review);
    }

    @PostMapping("reviews/{restaurantId}/add")
    public String addReview(@PathVariable restaurantId, @RequestParam Double rating, @RequestParam(required = false) String comment)
    {
        if(comment != null && !comment.isEmpty())
            this.reviewService.createReview(restaurantId,rating);
    }

}
*/