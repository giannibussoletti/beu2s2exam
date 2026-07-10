package gianni_bussoletti.beu2s2exam.controllers;

import gianni_bussoletti.beu2s2exam.entities.Prenotazione;
import gianni_bussoletti.beu2s2exam.exceptions.ValidationException;
import gianni_bussoletti.beu2s2exam.payloads.PrenotazioneResponseDTO;
import gianni_bussoletti.beu2s2exam.payloads.PrenotazioniDTO;
import gianni_bussoletti.beu2s2exam.services.PrenotazioneService;
import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
@AllArgsConstructor
public class PrenotazioneControllers {
    private PrenotazioneService prenotazioneService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrenotazioneResponseDTO saveNewPrenotazione(@RequestBody @Validated PrenotazioniDTO payload, BindingResult validation) {
        if (validation.hasErrors()) {
            List<String> validationErrors = validation.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            throw new ValidationException(validationErrors);
        }
        Prenotazione newPrenotazione = this.prenotazioneService.saveNewPrenotazione(payload);
        return new PrenotazioneResponseDTO(newPrenotazione.getId(), "Prenotazione Aggiunta correttamente", LocalDateTime.now());
    }
}
