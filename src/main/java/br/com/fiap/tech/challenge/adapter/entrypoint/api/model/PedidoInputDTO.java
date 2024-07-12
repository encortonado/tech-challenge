package br.com.fiap.tech.challenge.adapter.entrypoint.api.model;

import br.com.fiap.tech.challenge.application.products.entities.ProdutoEntity;
import lombok.Data;

import java.util.List;

@Data
public class PedidoInputDTO {

    private String cpf;

    private List<ProdutoPedidoDTO> itemDePedido;
}
