package mk.ukim.finki.restaurantreviewapp.web.controller;

import mk.ukim.finki.restaurantreviewapp.model.Restaurant;
import mk.ukim.finki.restaurantreviewapp.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = {"/", "/home"})
public class HomeController {

    private final RestaurantService restaurantService;

    public HomeController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public String getHomePage(Model model) {
        List<Restaurant> restaurants = this.restaurantService.listTopRatedRestaurants();
        model.addAttribute(restaurants);
        return "homepage";
    }

    @GetMapping("loggedIn")
    public String getLoggedInPage(Model model, HttpServletRequest request) {
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "logged-in-user";
    }

    @GetMapping("profile")
    public String getProfilePage(Model model, HttpServletRequest request){
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "profile-page";
    }

    @GetMapping("addnewrestaurant")
    public String getAddNewRestaurantPage(Model model, HttpServletRequest request) {
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "add-new-restaurant";
    }
}
