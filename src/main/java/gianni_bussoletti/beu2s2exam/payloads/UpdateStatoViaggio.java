package gianni_bussoletti.beu2s2exam.payloads;

import jakarta.validation.constraints.NotBlank;

public record UpdateStatoViaggio(
        @NotBlank(message = "Il campo non può essere lasciato vuoto")
        String statoViaggio) {
}
