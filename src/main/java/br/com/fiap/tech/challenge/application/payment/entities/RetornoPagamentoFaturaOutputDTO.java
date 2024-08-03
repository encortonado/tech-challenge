package br.com.fiap.tech.challenge.application.payment.entities;

import br.com.fiap.tech.challenge.domain.value_objects.enums.EStatusPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetornoPagamentoFaturaOutputDTO {

    private String faturaId;
    private Date dataCriacao;
    private Date dataAtualizacao;
    private EStatusPagamento situacao;
    private int pedidoCodigo;
    private String pedidoCpf;
}
