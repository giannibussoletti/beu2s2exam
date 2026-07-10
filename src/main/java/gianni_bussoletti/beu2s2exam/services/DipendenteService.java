package gianni_bussoletti.beu2s2exam.services;

import gianni_bussoletti.beu2s2exam.entities.Dipendente;
import gianni_bussoletti.beu2s2exam.exceptions.EmailExistsInDBException;
import gianni_bussoletti.beu2s2exam.exceptions.NotFoundException;
import gianni_bussoletti.beu2s2exam.exceptions.UsernameAlreadyExistsException;
import gianni_bussoletti.beu2s2exam.payloads.DipendenteDTO;
import gianni_bussoletti.beu2s2exam.repositories.DipendeteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class DipendenteService {

    private DipendeteRepository dipendeteRepository;

    //    SAVING POST REQUEST
    public Dipendente save(DipendenteDTO payload) {
        if (this.dipendeteRepository.existsByEmail(payload.email()))
            throw new EmailExistsInDBException("L'email è già presente nel Database");
        if (this.dipendeteRepository.existsByUsername(payload.username()))
            throw new UsernameAlreadyExistsException("Questo username esiste già nel Database");

        Dipendente newDipendente = new Dipendente(payload.username(), payload.nome(), payload.cognome(), payload.email());
        return this.dipendeteRepository.save(newDipendente);

    }

    //    GET RESPONSE ALL DIPENDENTI
    public Page<Dipendente> findAll(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return this.dipendeteRepository.findAll(pageable);
    }

    public Dipendente findById(UUID id) {
        return this.dipendeteRepository.findById(id).orElseThrow(() -> new NotFoundException("Dipendente non trovato"));

    }

}
