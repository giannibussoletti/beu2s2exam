package gianni_bussoletti.beu2s2exam.payloads;

import java.time.LocalDateTime;

public record ErrorsDTO(String message, LocalDateTime localDateTime) {
}
