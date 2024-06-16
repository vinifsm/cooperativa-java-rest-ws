package br.edu.fema.domain.propriedade.service;

import br.edu.fema.domain.propriedade.exceptions.PropriedadeDuplicatedException;
import br.edu.fema.domain.propriedade.exceptions.PropriedadeNotFoundException;
import br.edu.fema.domain.propriedade.model.Propriedade;
import br.edu.fema.domain.propriedade.repository.PropriedadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropriedadeService {

    @Autowired
    private PropriedadeRepository repository;

    public List<Propriedade> findAll() {
        return repository.findAll();
    }

    public Propriedade findByNome(String nome) {
        return repository.findByNome(nome).orElseThrow(() -> new PropriedadeNotFoundException(nome));
    }

    public Propriedade insert(Propriedade propriedade) {
        final Optional<Propriedade> propriedadeRecuperada = repository.findByNome(propriedade.getNome());

        if (propriedadeRecuperada.isPresent()) {
            throw new PropriedadeDuplicatedException(propriedade.getNome());
        }

        return repository.insert(propriedade);
    }

    public Propriedade update(Propriedade propriedade) {
        final Propriedade propriedadeRecuperada = repository.findByNome(propriedade.getNome()).orElseThrow(() -> new PropriedadeNotFoundException(propriedade.getNome()));

        propriedade.setId(propriedadeRecuperada.getId());

        return repository.update(propriedade);
    }

    public Propriedade deleteByNome(String nome) {
        return repository.deleteByNome(nome).orElseThrow(() -> new PropriedadeNotFoundException(nome));
    }
}
