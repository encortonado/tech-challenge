package br.com.fiap.tech.challenge.application.payment.ports;

import br.com.fiap.tech.challenge.application.payment.entities.AtualizaStatusPedidoDTO;
import br.com.fiap.tech.challenge.application.payment.entities.AtualizaStatusPedidoOutputDTO;

public interface IAtualizaStatusPedidoUseCase {

    AtualizaStatusPedidoOutputDTO atualizaStatusPedido(AtualizaStatusPedidoDTO data);


}
