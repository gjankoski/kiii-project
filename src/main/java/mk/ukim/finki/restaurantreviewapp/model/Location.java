package mk.ukim.finki.restaurantreviewapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String city;
    private String country;

    public Location() {
    }

    public Location(String address, String city, String country) {
        this.address = address;
        this.city = city;
        this.country = country;
    }
}
