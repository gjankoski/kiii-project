package mk.ukim.finki.restaurantreviewapp.Repository;

import mk.ukim.finki.restaurantreviewapp.model.Restaurant;
import mk.ukim.finki.restaurantreviewapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findAllByNameLike(String name);

    List<Restaurant> findAllByReviewsIn(List<Review> reviews);

//    @Query("SELECT R FROM Restaurant R where R.category = 'category1'")
//    List<Restaurant> getAll();

    @Query("select R from Restaurant R where R.Id = 1")
    Restaurant getFirstRestaurant();

    @Query("select R from Restaurant R join Category C on R.category.id = C.id where C.id = 2")
    List<Restaurant> getCategoryRestaurant();

    @Query("select R from Restaurant R join Category C on R.category.id = C.id where C.id = 2")
    List<RestaurantExample> getMegaExampl();

}
