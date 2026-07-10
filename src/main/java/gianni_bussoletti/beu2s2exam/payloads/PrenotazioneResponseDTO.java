package gianni_bussoletti.beu2s2exam.payloads;

import java.time.LocalDateTime;
import java.util.UUID;

public record PrenotazioneResponseDTO(UUID id, String message, LocalDateTime createdAt) {
}
