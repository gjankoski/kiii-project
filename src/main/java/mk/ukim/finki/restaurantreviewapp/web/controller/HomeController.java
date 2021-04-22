package mk.ukim.finki.restaurantreviewapp.web.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = {"/", "/home"})
public class HomeController {

    @GetMapping
    public String getHomePage() {
        return "homepage";
    }

    @GetMapping("/loggedIn")
    public String getLoggedInPage(Model model, HttpServletRequest request) {
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "logged-in-user";
    }

    @GetMapping("profile")
    public String getProfilePage(){
        return "profile-page";
    }
}
