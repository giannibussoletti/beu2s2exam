package gianni_bussoletti.beu2s2exam.services;

import gianni_bussoletti.beu2s2exam.entities.Dipendente;
import gianni_bussoletti.beu2s2exam.entities.Prenotazione;
import gianni_bussoletti.beu2s2exam.entities.Viaggio;
import gianni_bussoletti.beu2s2exam.enums.MezzoViaggio;
import gianni_bussoletti.beu2s2exam.exceptions.MezzoViaggioException;
import gianni_bussoletti.beu2s2exam.payloads.PrenotazioniDTO;
import gianni_bussoletti.beu2s2exam.repositories.PrenotazioneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PrenotazioneService {
    private PrenotazioneRepository prenotazioneRepository;
    private DipendenteService dipendenteService;
    private ViaggioService viaggioService;

    public Prenotazione saveNewPrenotazione(PrenotazioniDTO payload, UUID idDipendente, UUID idViaggio) {
        Dipendente findDipendente = this.dipendenteService.findById(idDipendente);
        Viaggio findViaggio = this.viaggioService.findById(idViaggio);
        MezzoViaggio mezzoViaggio = null;
        switch (payload.mezzoViaggio().toLowerCase()) {
            case "treno" -> mezzoViaggio = MezzoViaggio.TRENO;
            case "aereo" -> mezzoViaggio = MezzoViaggio.AEREO;
            case "bus" -> mezzoViaggio = MezzoViaggio.BUS;
            case "nave" -> mezzoViaggio = MezzoViaggio.NAVE;
            case "macchina" -> mezzoViaggio = MezzoViaggio.MACCHINA;
            default -> throw new MezzoViaggioException("La lista dei mezzi validi è \n" +
                    "treno\n" +
                    "aereo\n" +
                    "bus\n" +
                    "nave\n" +
                    "macchina");
        }
        Prenotazione newPrenotazione = new Prenotazione(findDipendente, findViaggio, payload.alloggio(), mezzoViaggio, payload.numeroBiglietto());
        this.prenotazioneRepository.save(newPrenotazione);
        return newPrenotazione;
    }

}
