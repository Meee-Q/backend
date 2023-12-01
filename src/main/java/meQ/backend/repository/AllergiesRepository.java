package meQ.backend.repository;

import meQ.backend.domain.entity.Allergies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergiesRepository extends JpaRepository<Allergies, Long> {
}
