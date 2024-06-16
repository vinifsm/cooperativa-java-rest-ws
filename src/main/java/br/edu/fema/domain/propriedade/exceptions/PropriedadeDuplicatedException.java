package br.edu.fema.domain.propriedade.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PropriedadeDuplicatedException extends RuntimeException {

    private final String nome;

    public PropriedadeDuplicatedException(String nome) {
        super();
        this.nome = nome;
    }

    @Override
    public String getMessage() {
        return String.format("Propriedade duplicada para nome = %s", nome);
    }
}
