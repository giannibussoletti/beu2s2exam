package gianni_bussoletti.beu2s2exam.services;

import gianni_bussoletti.beu2s2exam.entities.Viaggio;
import gianni_bussoletti.beu2s2exam.enums.StatoViaggio;
import gianni_bussoletti.beu2s2exam.exceptions.NotFoundException;
import gianni_bussoletti.beu2s2exam.exceptions.StatoViaggioException;
import gianni_bussoletti.beu2s2exam.payloads.ViaggioDTO;
import gianni_bussoletti.beu2s2exam.repositories.ViaggioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    public Page<Viaggio> findAllViaggi(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return this.viaggioRepository.findAll(pageable);
    }

    public Viaggio findById(UUID id) {
        Viaggio found = this.viaggioRepository.findViaggioById(id);
        if (found != null) return found;
        else throw new NotFoundException("Viaggio non trovato");

    }

    public Viaggio findByIdAndUpdate(UUID viaggioId, String stato) {
        Viaggio found = this.findById(viaggioId);

        if (stato.equalsIgnoreCase("in programma")) {
            found.setStatoViaggio(StatoViaggio.IN_PROGRAMMA);
            this.viaggioRepository.save(found);
        } else if (stato.equalsIgnoreCase("completato")) {
            found.setStatoViaggio(StatoViaggio.COMPLETATO);
            this.viaggioRepository.save(found);
        } else {
            throw new StatoViaggioException("Lo stato del viaggio può essere solo 'in programma' o 'completato'");
        }
        return found;
    }
}
