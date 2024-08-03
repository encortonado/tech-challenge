package br.com.fiap.tech.challenge.application.orders.ports;

import br.com.fiap.tech.challenge.application.payment.ports.IAtualizaStatusPedidoUseCase;

public interface IPedidoUseCases extends IRegistraPedidoUseCase, IListaPedidosUseCase, IListaPedidosPorStatusUseCase, IAtualizaStatusPedidoUseCase {

}

