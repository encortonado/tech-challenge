package br.com.fiap.tech.challenge.application.orders.ports;

import br.com.fiap.tech.challenge.adapter.entrypoint.api.model.PedidoDTO;
import br.com.fiap.tech.challenge.domain.value_objects.enums.EStatus;

import java.util.List;

public interface IListaPedidosPorStatusUseCase {

    List<PedidoDTO> listaPedidosPorStatus(EStatus status);

}
