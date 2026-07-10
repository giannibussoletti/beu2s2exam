package gianni_bussoletti.beu2s2exam.repositories;

import gianni_bussoletti.beu2s2exam.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio, UUID> {

    Viaggio findViaggioById(UUID viaggioID);
}
