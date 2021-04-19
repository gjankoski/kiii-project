package mk.ukim.finki.restaurantreviewapp.service;

import mk.ukim.finki.restaurantreviewapp.model.Location;

import java.util.List;

public interface LocationService {

    Location findById(Long id);

    List<Location> listAll();
}
