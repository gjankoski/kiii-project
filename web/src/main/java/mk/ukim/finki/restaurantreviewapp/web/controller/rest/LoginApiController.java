package mk.ukim.finki.restaurantreviewapp.web.controller.rest;

import mk.ukim.finki.restaurantreviewapp.model.Dtos.UserDto;
import mk.ukim.finki.restaurantreviewapp.model.User;
import mk.ukim.finki.restaurantreviewapp.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/login")
public class LoginApiController {
    private final AuthService authService;

    public LoginApiController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<User> loginUser(@RequestBody UserDto userDto) {
        try {
            User user = this.authService.login(userDto.getUsername(), userDto.getPassword());
            return ResponseEntity.ok().body(user);
        }
        catch (Exception exception)
        {
            return ResponseEntity.badRequest().build();
        }

    }
}
