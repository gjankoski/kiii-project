package mk.ukim.finki.restaurantreviewapp.web.controller;


import mk.ukim.finki.restaurantreviewapp.model.Restaurant;
import mk.ukim.finki.restaurantreviewapp.service.CategoryService;
import mk.ukim.finki.restaurantreviewapp.service.RestaurantService;
import org.h2.engine.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final CategoryService categoryService;

    public RestaurantController(RestaurantService restaurantService, CategoryService categoryService) {
        this.restaurantService = restaurantService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getRestaurants(Model model)
    {
        List<Restaurant> restaurants = this.restaurantService.listAll();
        model.addAttribute("restaurants", restaurants);
        return "homepage.html";
    }
    @GetMapping("/add")
    public String showAdd()
    {
        return "add-new-restaurant.html";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model)
    {
        Restaurant restaurant = this.restaurantService.findById(id);
        model.addAttribute("restaurant", restaurant);
        return "add-new-restaurant.html";
    }

    @DeleteMapping("delete/{id}")
    public String deleteRestaurant(@PathVariable Long id)
    {
        this.restaurantService.delete(id);
        return "redirect:/homepage.html";
    }
    @PostMapping("/add")
    public String addRestaurant(@RequestParam String name,
                                @RequestParam String description,
                                @RequestParam Long categoryId,
                                @RequestParam Long locationId,
                                @RequestParam boolean delivery,
                                @RequestParam int price
                                )
    {
        this.restaurantService.create(name, description, delivery, price, locationId, categoryId);
        return "redirect:/loggedIn";
    }
    @PostMapping("/edit/{id}")
    public String editRestaurant(@PathVariable Long id,
                                 @RequestParam String name,
                                @RequestParam String description,
                                @RequestParam Long categoryId,
                                @RequestParam Long locationId,
                                @RequestParam boolean delivery,
                                @RequestParam int price
    )
    {
        this.restaurantService.update(id, name, description, delivery, price, locationId, categoryId);
        return "redirect:/homepage.html";
    }
//    @GetMapping("/topRated")
//    public String topRatedRestaurants(Model model)
//    {
//        List<Restaurant> restaurants = this.restaurantService.listTopRatedRestaurants();
//        model.addAttribute(restaurants);
//        return "redirect:/home";
//    }
    @PostMapping("/search")
    public String searchRestaurant(@RequestParam(required = true) String name, Model model)
    {
        List<Restaurant> restaurants = this.restaurantService.searchByName(name);
        model.addAttribute("restaurants", restaurants);
        return "redirect:/loggedIn";
    }

    @GetMapping("/showRestaurant/{id}")
    public String showRestaurant(@PathVariable Long id, Model model) {
        Restaurant restaurant = this.restaurantService.findById(id);
        model.addAttribute("restaurant", restaurant);
        return "restaurant-page";
    }
}
