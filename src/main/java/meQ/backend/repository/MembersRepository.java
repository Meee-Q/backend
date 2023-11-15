package meQ.backend.repository;

import meQ.backend.domain.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembersRepository extends JpaRepository<Members, Long> {

    public boolean existsByMembersId(String membersId);

    Optional<Members> findByMembersId(String membersId);
}
