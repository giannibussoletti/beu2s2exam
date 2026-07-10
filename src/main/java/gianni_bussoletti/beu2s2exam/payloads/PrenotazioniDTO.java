package gianni_bussoletti.beu2s2exam.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record PrenotazioniDTO(
        @NotBlank(message = "L'id del dipendente non può essere lasciato vuoto")
        UUID dipendente,
        @NotBlank(message = "L'id della prenotazione non può essere lasciato vuoto")
        UUID prenotazione,
        @NotBlank(message = "L'alloggio non può essere lasciato vuoto")
        @Size(min = 5, max = 40, message = "Il nome dell'alloggio deve essere compreso fra 5 e 40 caratteri")
        String alloggio,
        @NotBlank(message = "Il mezzo di viaggio non può essere lasciato vuoto")
        String mezzoViaggio,
        @NotBlank(message = "Il biglietto deve avere un numero identificato")
        @PositiveOrZero(message = "Il numero del biglietto non può essere un valore negativo")
        int numeroBiglietto
) {
}
