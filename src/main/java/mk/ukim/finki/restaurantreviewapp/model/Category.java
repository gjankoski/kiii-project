package mk.ukim.finki.restaurantreviewapp.model;

import lombok.Data;

@Data
public class Category {

    private Long id;
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
