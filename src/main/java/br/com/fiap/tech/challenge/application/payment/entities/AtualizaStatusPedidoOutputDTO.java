package br.com.fiap.tech.challenge.application.payment.entities;

import lombok.Data;

@Data
public class AtualizaStatusPedidoOutputDTO {
    private final Long codigoPedido;
    private final String status;
    private final Integer codigoStatus;
}
