package br.edu.fema.domain.producao.service;

import br.edu.fema.domain.producao.exceptions.ProducaoDuplicatedException;
import br.edu.fema.domain.producao.exceptions.ProducaoNotFoundException;
import br.edu.fema.domain.producao.model.Producao;
import br.edu.fema.domain.producao.repository.ProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducaoService {

    @Autowired
    private ProducaoRepository repository;

    public List<Producao> findAll() {
        return repository.findAll();
    }

    public Producao findByNome(String nome) {
        return repository.findByNome(nome).orElseThrow(() -> new ProducaoNotFoundException(nome));
    }

    public Producao insert(Producao producao) {
        final Optional<Producao> producaoRecuperada = repository.findByNome(producao.getNome());

        if (producaoRecuperada.isPresent()) {
            throw new ProducaoDuplicatedException(producao.getNome());
        }

        return repository.insert(producao);
    }

    public Producao update(Producao producao) {
        final Producao producaoRecuperada = repository.findByNome(producao.getNome()).orElseThrow(() -> new ProducaoNotFoundException(producao.getNome()));

        producao.setId(producaoRecuperada.getId());

        return repository.update(producao);
    }

    public Producao deleteByNome(String nome) {
        return repository.deleteByNome(nome).orElseThrow(() -> new ProducaoNotFoundException(nome));
    }
}
