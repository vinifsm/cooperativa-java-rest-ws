package br.edu.fema.domain.usuario.model;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(of = {"id", "nome", "email"})
@EqualsAndHashCode(of = {"email"})
public class Usuario {

    private String id;

    @NotBlank(message = "Nome deve ser informado")
    private String nome;

    @Email(message = "E-mail deve possuir formato correto")
    private String email;

    @NotBlank(message = "Senha deve ser informada")
    @Size(min = 6, message = "A senha deve ter pelo menos {min} caracteres")
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}
