package gianni_bussoletti.beu2s2exam.services;

import gianni_bussoletti.beu2s2exam.repositories.PrenotazioneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PrenotazioneService {

    private PrenotazioneRepository prenotazioneRepository;
    private DipendenteService dipendenteService;
    private ViaggioService viaggioService;


}
