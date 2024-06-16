package br.edu.fema.domain.cadastro.repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.edu.fema.domain.cadastro.model.Cadastro;

@Repository
public class CadastroRepository {

    private static final Map<String, Cadastro> CADASTROS = new LinkedHashMap<>();

    public List<Cadastro> findAll() {
        return List.copyOf(CADASTROS.values());
    }

    public Optional<Cadastro> findByCpf(String cpf) {
        return Optional.ofNullable(CADASTROS.get(cpf));
    }

    public Cadastro insert(Cadastro cadastro) {
        CADASTROS.putIfAbsent(cadastro.getCpf(), cadastro);
        return cadastro;
    }

    public Cadastro update(Cadastro cadastro) {
        CADASTROS.put(cadastro.getCpf(), cadastro);
        return cadastro;
    }

    public Optional<Cadastro> deleteByCpf(String cpf) {
        return Optional.ofNullable(CADASTROS.remove(cpf));
    }
}
