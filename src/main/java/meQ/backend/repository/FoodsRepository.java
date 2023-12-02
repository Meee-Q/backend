package meQ.backend.repository;

import meQ.backend.domain.entity.Foods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodsRepository extends JpaRepository<Foods, Long> {
}
