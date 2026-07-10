package gianni_bussoletti.beu2s2exam.entities;

import gianni_bussoletti.beu2s2exam.enums.StatoViaggio;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "viaggi")
public class Viaggio {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String destinazione;

    @Column(name = "data_richiesta", nullable = false)
    private LocalDate dataRichiesta;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "stato_viaggio", nullable = false)
    private StatoViaggio statoViaggio;

    public Viaggio(String destinazione, LocalDate dataRichiesta, StatoViaggio statoViaggio) {
        this.destinazione = destinazione;
        this.dataRichiesta = dataRichiesta;
        this.statoViaggio = statoViaggio;
    }
}
