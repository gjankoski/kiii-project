package mk.ukim.finki.restaurantreviewapp.service.impl;

import mk.ukim.finki.restaurantreviewapp.Repository.LocationRepository;
import mk.ukim.finki.restaurantreviewapp.model.exceptions.InvalidLocationException;
import mk.ukim.finki.restaurantreviewapp.model.Location;
import mk.ukim.finki.restaurantreviewapp.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location findById(Long id) {
        return this.locationRepository.findById(id).orElseThrow(InvalidLocationException::new);
    }

    @Override
    public List<Location> listAll() {
        return this.locationRepository.findAll();
    }

    @Override
    public Location create(String address, String city, String country) {
        return this.locationRepository.save(new Location(address, city, country));
    }
}
