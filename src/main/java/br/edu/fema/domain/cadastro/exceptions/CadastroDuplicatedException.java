package br.edu.fema.domain.cadastro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CadastroDuplicatedException extends RuntimeException {

    private final String email;

    public CadastroDuplicatedException(String email) {
        super();
        this.email = email;
    }

    @Override
    public String getMessage() {
        return String.format("Cadastro duplicado para e-mail = %s", email);
    }
}
