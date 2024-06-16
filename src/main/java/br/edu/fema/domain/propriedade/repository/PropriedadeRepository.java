package br.edu.fema.domain.propriedade.repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.edu.fema.domain.propriedade.model.Propriedade;

@Repository
public class PropriedadeRepository {

    private static final Map<String, Propriedade> PROPRIEDADES = new LinkedHashMap<>();

    public List<Propriedade> findAll() {
        return List.copyOf(PROPRIEDADES.values());
    }

    public Optional<Propriedade> findByNome(String nome) {
        return Optional.ofNullable(PROPRIEDADES.get(nome));
    }

    public Propriedade insert(Propriedade propriedade) {
        PROPRIEDADES.putIfAbsent(propriedade.getNome(), propriedade);
        return propriedade;
    }

    public Propriedade update(Propriedade propriedade) {
        PROPRIEDADES.put(propriedade.getNome(), propriedade);
        return propriedade;
    }

    public Optional<Propriedade> deleteByNome(String nome) {
        return Optional.ofNullable(PROPRIEDADES.remove(nome));
    }
}
