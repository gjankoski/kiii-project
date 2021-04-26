package mk.ukim.finki.restaurantreviewapp.Repository;

import mk.ukim.finki.restaurantreviewapp.model.Restaurant;
import mk.ukim.finki.restaurantreviewapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findAllByNameLike(String name);
}
