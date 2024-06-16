package br.edu.fema.domain.usuario.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UsuarioDuplicatedException extends RuntimeException {

    private final String cpf;

    public UsuarioDuplicatedException(String cpf) {
        super();
        this.cpf = cpf;
    }

    @Override
    public String getMessage() {
        return String.format("Usuário duplicado para CPF = %s", cpf);
    }
}
