package mk.ukim.finki.restaurantreviewapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float rating;
    private String comment;

    public Review() {
    }

    public Review(float rating) {
        this.rating = rating;
    }

    public Review(float rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }
}
