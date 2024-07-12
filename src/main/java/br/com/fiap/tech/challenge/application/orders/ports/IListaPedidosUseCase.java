package br.com.fiap.tech.challenge.application.orders.ports;

import br.com.fiap.tech.challenge.adapter.entrypoint.api.model.PedidoDTO;

import java.util.List;

public interface IListaPedidosUseCase {

    List<PedidoDTO> listaPedidos();

}
