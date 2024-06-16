package br.edu.fema.domain.cadastro.service;

import br.edu.fema.domain.cadastro.exceptions.CadastroDuplicatedException;
import br.edu.fema.domain.cadastro.exceptions.CadastroNotFoundException;
import br.edu.fema.domain.cadastro.model.Cadastro;
import br.edu.fema.domain.cadastro.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository repository;

    public List<Cadastro> findAll() {
        return repository.findAll();
    }

    public Cadastro findByCpf(String cpf) {
        return repository.findByCpf(cpf).orElseThrow(() -> new CadastroNotFoundException(cpf));
    }

    public Cadastro insert(Cadastro cadastro) {
        final Optional<Cadastro> cadastroRecuperado = repository.findByCpf(cadastro.getCpf());

        if (cadastroRecuperado.isPresent()) {
            throw new CadastroDuplicatedException(cadastro.getCpf());
        }

        return repository.insert(cadastro);
    }

    public Cadastro update(Cadastro cadastro) {
        final Cadastro cadastroRecuperado = repository.findByCpf(cadastro.getCpf()).orElseThrow(() -> new CadastroNotFoundException(cadastro.getCpf()));

        cadastro.setId(cadastroRecuperado.getId());

        return repository.update(cadastro);
    }

    public Cadastro deleteByCpf(String cpf) {
        return repository.deleteByCpf(cpf).orElseThrow(() -> new CadastroNotFoundException(cpf));
    }
}
