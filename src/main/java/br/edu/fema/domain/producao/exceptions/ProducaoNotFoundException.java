package br.edu.fema.domain.producao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProducaoNotFoundException extends RuntimeException {

    private final String nome;

    public ProducaoNotFoundException(String nome) {
        super();
        this.nome = nome;
    }

    @Override
    public String getMessage() {
        return String.format("Produção não localizada para nome = %s", nome);
    }
}
