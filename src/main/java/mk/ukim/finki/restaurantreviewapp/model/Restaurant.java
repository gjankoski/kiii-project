package mk.ukim.finki.restaurantreviewapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String description;
    @ManyToOne
    private Location location;
    private boolean delivery;
    private int price;
    @ManyToOne
    private Category category;
    @ManyToMany
    private List<Review> reviews;

    public Restaurant() {
    }

    public Restaurant(String name, String description, boolean delivery, int price, Location location, Category category) {
        this.name = name;
        this.description = description;
        this.delivery = delivery;
        this.price = price;
        this.location = location;
        this.category = category;
        this.reviews = new ArrayList<>();
    }
}
