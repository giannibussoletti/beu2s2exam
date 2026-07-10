package gianni_bussoletti.beu2s2exam.entities;

import gianni_bussoletti.beu2s2exam.enums.MezzoViaggio;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Setter
@Getter
@ToString
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
    private Viaggio viaggio;

    @Column(nullable = false)
    private String alloggio;

    @Enumerated(EnumType.STRING)
    @Column(name = "mezzo_viaggio", nullable = false)
    private MezzoViaggio mezzoViaggio;

    @Column(name = "numero_biglietto", nullable = false)
    private int numeroBiglietto;

    public Prenotazione(Dipendente dipendente, Viaggio viaggio, String alloggio, MezzoViaggio mezzoViaggio, int numeroBiglietto) {
        this.dipendente = dipendente;
        this.viaggio = viaggio;
        this.alloggio = alloggio;
        this.mezzoViaggio = mezzoViaggio;
        this.numeroBiglietto = numeroBiglietto;
    }
}
