package br.com.fiap.tech.challenge.application.orders.entities;

import br.com.fiap.tech.challenge.application.products.entities.ProdutoEntity;
import br.com.fiap.tech.challenge.domain.value_objects.enums.EStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

@Entity
@Table(name = "pedidos")
@Data
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String cpf;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private EStatus status;


    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoProdutoEntity> pedidoProduto = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPedido;
}
