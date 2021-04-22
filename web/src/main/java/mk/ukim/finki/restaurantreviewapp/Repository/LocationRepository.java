package mk.ukim.finki.restaurantreviewapp.Repository;

import mk.ukim.finki.restaurantreviewapp.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
