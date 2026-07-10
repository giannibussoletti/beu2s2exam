package gianni_bussoletti.beu2s2exam.services;

import gianni_bussoletti.beu2s2exam.entities.Viaggio;
import gianni_bussoletti.beu2s2exam.enums.StatoViaggio;
import gianni_bussoletti.beu2s2exam.exceptions.StatoViaggioException;
import gianni_bussoletti.beu2s2exam.payloads.ViaggioDTO;
import gianni_bussoletti.beu2s2exam.repositories.ViaggioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ViaggioService {
    private ViaggioRepository viaggioRepository;

    public Viaggio saveNewViaggio(ViaggioDTO payload) {
        StatoViaggio statoViaggio = null;
        if (payload.statoViaggio().equalsIgnoreCase("in programma")) {
            statoViaggio = StatoViaggio.IN_PROGRAMMA;
        } else if (payload.statoViaggio().equalsIgnoreCase("completato")) {
            statoViaggio = StatoViaggio.COMPLETATO;
        } else {
            throw new StatoViaggioException("Lo stato del viaggio può essere solo 'in programma' o 'completato'");
        }
        Viaggio newViaggio = new Viaggio(payload.destinazione(), payload.dataRichiesta(), statoViaggio);
        this.viaggioRepository.save(newViaggio);
        return newViaggio;


    }
}
