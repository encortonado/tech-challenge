package br.com.fiap.tech.challenge.application.products.entities;

import br.com.fiap.tech.challenge.application.orders.entities.PedidoEntity;
import br.com.fiap.tech.challenge.application.orders.entities.PedidoProdutoEntity;
import br.com.fiap.tech.challenge.domain.value_objects.enums.ECategoria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @JsonIgnore
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<PedidoProdutoEntity> pedidos = new ArrayList<>();


}
