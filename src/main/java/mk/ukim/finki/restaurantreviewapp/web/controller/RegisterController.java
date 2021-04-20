package mk.ukim.finki.restaurantreviewapp.web.controller;

import mk.ukim.finki.restaurantreviewapp.model.Role;
import mk.ukim.finki.restaurantreviewapp.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.restaurantreviewapp.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.restaurantreviewapp.service.AuthService;
import mk.ukim.finki.restaurantreviewapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthService authService;
    private final UserService userService;

    public RegisterController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "register-page";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String name,
                           @RequestParam String lastName,
                           @RequestParam String city,
                           @RequestParam String country) {
        try{
            this.userService.register(username, password, repeatedPassword, name, lastName, city, country, Role.ROLE_USER);
            return "redirect:/login";
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }

}
