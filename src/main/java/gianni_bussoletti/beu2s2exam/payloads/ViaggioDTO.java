package gianni_bussoletti.beu2s2exam.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ViaggioDTO(
        @NotBlank(message = "La destinazione non può essere vuota")
        String destinazione,
        @PastOrPresent(message = "Il giorno del viaggio deve essere seguente a quello di oggi")
        LocalDate dataRichiesta,
        @NotBlank(message = "Lo stato del viaggio non può essere vuoto")
        String statoViaggio) {
}
