package gianni_bussoletti.beu2s2exam.entities;

import gianni_bussoletti.beu2s2exam.enums.MezzoViaggio;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "prenotazioni")
public class Prenotazione {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Dipendente dipendente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Prenotazione prenotazione;

    @Column(nullable = false)
    private String alloggio;

    @Enumerated(EnumType.STRING)
    @Column(name = "mezzo_viaggio", nullable = false)
    private MezzoViaggio mezzoViaggio;

    @Column(name = "numero_biglietto", nullable = false)
    private int numeroBiglietto;

    public Prenotazione(Dipendente dipendente, Prenotazione prenotazione, String alloggio, MezzoViaggio mezzoViaggio, int numeroBiglietto) {
        this.dipendente = dipendente;
        this.prenotazione = prenotazione;
        this.alloggio = alloggio;
        this.mezzoViaggio = mezzoViaggio;
        this.numeroBiglietto = numeroBiglietto;
    }
}
