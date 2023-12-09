package meQ.backend.repository;

import meQ.backend.domain.entity.Menus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenusRepository extends JpaRepository<Menus, Long> {
}
