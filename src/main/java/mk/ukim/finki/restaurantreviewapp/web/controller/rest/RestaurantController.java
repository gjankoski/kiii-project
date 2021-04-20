package mk.ukim.finki.restaurantreviewapp.web.controller.rest;
import mk.ukim.finki.restaurantreviewapp.model.Dtos.RestaurantDto;
import mk.ukim.finki.restaurantreviewapp.model.Exceptions.InvalidCategoryException;
import mk.ukim.finki.restaurantreviewapp.model.Exceptions.InvalidLocationException;
import mk.ukim.finki.restaurantreviewapp.model.Exceptions.InvalidRestaurantException;
import mk.ukim.finki.restaurantreviewapp.model.Restaurant;
import mk.ukim.finki.restaurantreviewapp.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/restaurants")

public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> findAll()
    {
        return this.restaurantService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findById(@PathVariable Long id)
    {
        try
        {
            Restaurant restaurant = this.restaurantService.findById(id);
            return ResponseEntity.ok().body(restaurant);
        }
        catch (InvalidRestaurantException invalidRestaurantException)
        {
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping("/add")
    public ResponseEntity<Restaurant> save(@RequestBody RestaurantDto restaurantDto)
    {
        try {
            Restaurant restaurant = this.restaurantService.create(restaurantDto);
            return ResponseEntity.ok().body(restaurant);
        }
        catch (InvalidRestaurantException | InvalidCategoryException | InvalidLocationException exception)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Restaurant> edit(Long id, @RequestBody RestaurantDto restaurantDto)
    {
        try {
            Restaurant restaurant = this.restaurantService.update(id, restaurantDto);
            return ResponseEntity.ok().body(restaurant);
        }
        catch (InvalidRestaurantException | InvalidCategoryException | InvalidLocationException exception)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Restaurant> delete(Long id)
    {
        this.restaurantService.delete(id);
        try {
            this.restaurantService.findById(id);
            return ResponseEntity.ok().build();
        }
        catch (InvalidRestaurantException invalidRestaurantException)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
