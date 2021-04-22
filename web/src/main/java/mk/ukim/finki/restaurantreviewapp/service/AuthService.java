package mk.ukim.finki.restaurantreviewapp.service;

import mk.ukim.finki.restaurantreviewapp.model.User;

public interface AuthService {
    User login(String username, String password);
}
