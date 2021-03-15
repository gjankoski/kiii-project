package mk.ukim.finki.restaurantreviewapp.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Restaurant {

    private String name;
    private String description;
    private Location location;
    private Category category;
    private List<Review> reviews;

    public Restaurant(String name, String description, Location location, Category category) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.category = category;
        this.reviews = new ArrayList<>();
    }
}
