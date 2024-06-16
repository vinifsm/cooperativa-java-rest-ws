package br.edu.fema.domain.propriedade.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString(of = {"id", "nome", "endereco", "bairro", "cidade", "uf", "area"})
@EqualsAndHashCode(of = {"nome"})
public class Propriedade {

    private String id;

    @NotBlank(message = "Nome deve ser informado")
    private String nome;

    @NotBlank(message = "Endereço deve ser informado")
    private String endereco;

    @NotBlank(message = "Bairro deve ser informado")
    private String bairro;

    @NotBlank(message = "Cidade deve ser informada")
    private String cidade;

    @NotBlank(message = "UF deve ser informada")
    private String uf;

    @NotNull(message = "Área/Tamanho deve ser informado")
    private Double area;

    public Propriedade(String nome, String endereco, String bairro, String cidade, String uf, Double area) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.area = area;
    }
}
