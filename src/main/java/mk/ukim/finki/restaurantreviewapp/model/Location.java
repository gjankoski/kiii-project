package mk.ukim.finki.restaurantreviewapp.model;

import lombok.Data;

@Data
public class Location {
    private String address;
    private String city;
    private String country;

    public Location(String address, String city, String country) {
        this.address = address;
        this.city = city;
        this.country = country;
    }
}
