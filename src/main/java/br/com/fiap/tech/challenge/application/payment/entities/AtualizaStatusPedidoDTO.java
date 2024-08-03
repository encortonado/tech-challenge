package br.com.fiap.tech.challenge.application.payment.entities;

import br.com.fiap.tech.challenge.domain.value_objects.enums.EStatus;
import lombok.Data;

@Data
public class AtualizaStatusPedidoDTO {

    private Long id;
    private EStatus status;

}
