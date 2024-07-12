package br.com.fiap.tech.challenge.application.orders.ports;

import br.com.fiap.tech.challenge.adapter.entrypoint.api.model.PedidoInputDTO;
import br.com.fiap.tech.challenge.application.orders.entities.PedidoEntity;

public interface IRegistraPedidoUseCase {

    PedidoEntity registraPedido(PedidoInputDTO data);

}
