package br.edu.fema.domain.producao.repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.edu.fema.domain.producao.model.Producao;

@Repository
public class ProducaoRepository {

    private static final Map<String, Producao> PRODUCOES = new LinkedHashMap<>();

    public List<Producao> findAll() {
        return List.copyOf(PRODUCOES.values());
    }

    public Optional<Producao> findByNome(String nome) {
        return Optional.ofNullable(PRODUCOES.get(nome));
    }

    public Producao insert(Producao producao) {
        PRODUCOES.putIfAbsent(producao.getNome(), producao);
        return producao;
    }

    public Producao update(Producao producao) {
        PRODUCOES.put(producao.getNome(), producao);
        return producao;
    }

    public Optional<Producao> deleteByNome(String nome) {
        return Optional.ofNullable(PRODUCOES.remove(nome));
    }
}
