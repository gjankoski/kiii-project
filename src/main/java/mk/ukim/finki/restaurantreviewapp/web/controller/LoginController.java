package mk.ukim.finki.restaurantreviewapp.web.controller;

import mk.ukim.finki.restaurantreviewapp.model.User;
import mk.ukim.finki.restaurantreviewapp.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.restaurantreviewapp.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login-page";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        User user = null;
        try {
            user = this.authService.login(request.getParameter("username"), request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            return "redirect:/loggedIn";
        }
        catch (Exception e) {
            return "redirect:/login?error=" + e.getMessage();
        }
    }
}
