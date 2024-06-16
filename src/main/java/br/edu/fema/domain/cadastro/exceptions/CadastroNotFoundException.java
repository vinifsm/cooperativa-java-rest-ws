package br.edu.fema.domain.cadastro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CadastroNotFoundException extends RuntimeException {

    private final String email;

    public CadastroNotFoundException(String email) {
        super();
        this.email = email;
    }

    @Override
    public String getMessage() {
        return String.format("Cadastro não localizado para e-mail = %s", email);
    }
}
