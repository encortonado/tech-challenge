package br.com.fiap.tech.challenge.application.payment.ports;

import br.com.fiap.tech.challenge.application.payment.entities.FaturaEntity;
import br.com.fiap.tech.challenge.application.payment.entities.RetornoPagamentoFaturaOutputDTO;

import java.util.UUID;

public interface IPagamentoUseCase {
    RetornoPagamentoFaturaOutputDTO confirmaPagamentoFatura(UUID fatura_id);
    RetornoPagamentoFaturaOutputDTO rejeitaPagamentoFatura(UUID fatura_id);
    RetornoPagamentoFaturaOutputDTO obtemSituacaoPagamentoFatura(String fatura_id);
    FaturaEntity criaFaturaPagamento(String codigo_pedido);
}
