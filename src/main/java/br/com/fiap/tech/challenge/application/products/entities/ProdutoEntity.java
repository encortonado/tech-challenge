package br.com.fiap.tech.challenge.application.products.entities;

import br.com.fiap.tech.challenge.domain.value_objects.enums.ECategoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "produtos")
@Data
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    @Min(value = 0, message = "Um produto não pode conter um valor negativo")
    private float valor;

    @NotNull()
    @Enumerated(EnumType.ORDINAL)
    private ECategoria categoriaCodigo;

}
