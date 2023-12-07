package meQ.backend.repository;

import meQ.backend.domain.entity.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantsRepository extends JpaRepository<Restaurants, Long> {
}
