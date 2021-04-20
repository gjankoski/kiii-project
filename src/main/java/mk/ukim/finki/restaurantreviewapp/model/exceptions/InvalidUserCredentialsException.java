package mk.ukim.finki.restaurantreviewapp.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException {

    public InvalidUserCredentialsException() {
        super("Invalid user credentials");
    }
}
