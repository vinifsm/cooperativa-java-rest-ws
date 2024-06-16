package br.edu.fema.domain.cadastro.model;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(of = {"id", "nome", "cpf", "email", "celular", "cep", "estado", "cidade", "rua", "numero", "bairro"})
@EqualsAndHashCode(of = {"cpf", "email"})
public class Cadastro {

    private String id;

    @NotBlank(message = "Nome deve ser informado")
    private String nome;

    @NotBlank(message = "CPF deve ser informado")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
    private String cpf;

    @Email(message = "E-mail deve possuir formato correto")
    private String email;

    @NotBlank(message = "Celular deve ser informado")
    @Pattern(regexp = "\\d{11}", message = "Celular deve conter 11 dígitos numéricos")
    private String celular;

    @NotBlank(message = "CEP deve ser informado")
    @Pattern(regexp = "\\d{8}", message = "CEP deve conter 8 dígitos numéricos")
    private String cep;

    @NotBlank(message = "Estado deve ser informado")
    private String estado;

    @NotBlank(message = "Cidade deve ser informada")
    private String cidade;

    @NotBlank(message = "Rua deve ser informada")
    private String rua;

    @NotBlank(message = "Número deve ser informado")
    private String numero;

    @NotBlank(message = "Bairro deve ser informado")
    private String bairro;

    public Cadastro(String nome, String cpf, String email, String celular, String cep, String estado, String cidade, String rua, String numero, String bairro) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
    }
}
