package meQ.backend.repository;

import meQ.backend.domain.entity.MembersAllergies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersAllergiesRepository extends JpaRepository<MembersAllergies, Long> {
}
