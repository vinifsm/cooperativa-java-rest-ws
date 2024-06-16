package br.edu.fema.domain.propriedade.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PropriedadeNotFoundException extends RuntimeException {

    private final String nome;

    public PropriedadeNotFoundException(String nome) {
        super();
        this.nome = nome;
    }

    @Override
    public String getMessage() {
        return String.format("Propriedade não localizada para nome = %s", nome);
    }
}
