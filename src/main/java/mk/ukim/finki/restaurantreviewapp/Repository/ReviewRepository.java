package mk.ukim.finki.restaurantreviewapp.Repository;

import mk.ukim.finki.restaurantreviewapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
