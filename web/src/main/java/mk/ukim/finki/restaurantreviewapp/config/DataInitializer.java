package mk.ukim.finki.restaurantreviewapp.config;

import mk.ukim.finki.restaurantreviewapp.model.Role;
import mk.ukim.finki.restaurantreviewapp.model.User;
import mk.ukim.finki.restaurantreviewapp.service.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final LocationService locationService;
    private final CategoryService categoryService;
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;

    public DataInitializer(LocationService locationService, CategoryService categoryService, RestaurantService restaurantService, ReviewService reviewService) {
        this.locationService = locationService;
        this.categoryService = categoryService;
        this.restaurantService = restaurantService;
        this.reviewService = reviewService;
    }

    @PostConstruct
    public void initData()
    {

        for (int i=0; i<5; i++)
        {
            this.categoryService.create("Category" + i);
        }
        for (int i=0; i<5; i++)
        {
            this.locationService.create("address" + i, "city" + i, "country" + i);
        }
        for (int i=0; i<5; i++)
        {
            this.restaurantService.create("restaurant" + i, "restaurant decription" + i, true, 5000+i,
                    "goce delcev" +i, "ohrid", "makedonija", 2L);
        }

        this.restaurantService.create("restaurant", "restaurant decription", true, 5000,
                "goce ccv", "qwe", "asd", 2L);

        this.reviewService.createReview(1L,  10.0, "blabla");
        this.reviewService.createReview(2L,  15.0, "blabla");
        this.reviewService.createReview(3L,  16.0, "blabla");
        this.reviewService.createReview(2L,  100.0, "blabla");
        this.reviewService.createReview(3L,  200.0, "blabla");
        this.reviewService.createReview(1L,  300.0, "blabla");
        this.reviewService.createReview(3L,  400.0, "blabla");
    }
}
