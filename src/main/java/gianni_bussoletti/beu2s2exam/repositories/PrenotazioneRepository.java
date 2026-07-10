package gianni_bussoletti.beu2s2exam.repositories;

import gianni_bussoletti.beu2s2exam.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {

    @Query("SELECT COUNT(p) > 0 FROM Prenotazione p WHERE p.dipendente.id = :dipendenteID AND p.viaggio.dataRichiesta = :dataRichiesta")
    boolean existsByDipendenteAndData(@Param("dipendenteID") UUID dipendenteID,
                                      @Param("dataRichiesta") LocalDate date);


}
