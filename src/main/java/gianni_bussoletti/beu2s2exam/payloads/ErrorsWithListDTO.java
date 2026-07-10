package gianni_bussoletti.beu2s2exam.payloads;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorsWithListDTO(String message, LocalDateTime timestamp, List<String> errorsList) {
}
