package meQ.backend.repository;

import meQ.backend.domain.entity.MembersFoods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersFoodRepository extends JpaRepository<MembersFoods, Long> {
}
