package br.edu.fema.domain.producao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProducaoDuplicatedException extends RuntimeException {

    private final String nome;

    public ProducaoDuplicatedException(String nome) {
        super();
        this.nome = nome;
    }

    @Override
    public String getMessage() {
        return String.format("Produção duplicada para nome = %s", nome);
    }
}
