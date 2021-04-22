package mk.ukim.finki.restaurantreviewapp.service;

import mk.ukim.finki.restaurantreviewapp.model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    Location findById(Long id);

    List<Location> listAll();

    Location create(String address, String city, String country);
}
