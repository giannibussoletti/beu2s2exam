package gianni_bussoletti.beu2s2exam.services;

import gianni_bussoletti.beu2s2exam.repositories.ViaggioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ViaggioService {
    private ViaggioRepository viaggioRepository;
}
