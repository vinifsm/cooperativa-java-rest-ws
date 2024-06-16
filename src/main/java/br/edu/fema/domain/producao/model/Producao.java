package br.edu.fema.domain.producao.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString(of = {"id", "nome", "descricao", "preco", "tipo"})
@EqualsAndHashCode(of = {"nome"})
public class Producao {

    private String id;

    @NotBlank(message = "Nome deve ser informado")
    private String nome;

    @NotBlank(message = "Descrição deve ser informada")
    private String descricao;

    @NotNull(message = "Preço deve ser informado")
    private Double preco;

    @NotBlank(message = "Tipo deve ser informado")
    @Pattern(regexp = "Grão|Líquido", message = "Tipo deve ser 'Grão' ou 'Líquido'")
    private String tipo;

    public Producao(String nome, String descricao, Double preco, String tipo) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tipo = tipo;
    }
}
