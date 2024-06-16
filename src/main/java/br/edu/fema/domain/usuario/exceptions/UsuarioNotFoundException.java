package br.edu.fema.domain.usuario.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends RuntimeException {

    private final String cpf;

    public UsuarioNotFoundException(String cpf) {
        super();
        this.cpf = cpf;
    }

    @Override
    public String getMessage() {
        return String.format("Usuário não localizado para CPF = %s", cpf);
    }
}
