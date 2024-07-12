package br.com.fiap.tech.challenge.adapter.entrypoint.api.model;

import br.com.fiap.tech.challenge.domain.value_objects.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Long codigo;
    private String cpf;
    private EStatus status;
    private Date dataPedido;
    private List<ProdutoDTO> produtos;
}
