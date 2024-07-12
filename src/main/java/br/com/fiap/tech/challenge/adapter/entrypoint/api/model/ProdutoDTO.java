package br.com.fiap.tech.challenge.adapter.entrypoint.api.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class ProdutoDTO {

    private Long codigo;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    @Min(value = 0, message = "Um produto não pode conter um valor negativo")
    private float valor;

    @NotNull(message = "Categoria é obrigatória")
    private int categoriaCodigo;

}
