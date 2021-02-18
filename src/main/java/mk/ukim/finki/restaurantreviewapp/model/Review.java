package mk.ukim.finki.restaurantreviewapp.model;

import lombok.Data;

@Data
public class Review {
    private float rating;
    private String comment;

    public Review(float rating) {
        this.rating = rating;
    }

    public Review(float rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }
}
