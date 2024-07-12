package br.com.fiap.tech.challenge.application.orders.ports;

import br.com.fiap.tech.challenge.application.orders.entities.AtualizaStatusPedidoDTO;
import br.com.fiap.tech.challenge.application.orders.entities.AtualizaStatusPedidoOutputDTO;

public interface IAtualizaStatusPedidoUseCase {

    AtualizaStatusPedidoOutputDTO atualizaStatusPedido(AtualizaStatusPedidoDTO data);


}
