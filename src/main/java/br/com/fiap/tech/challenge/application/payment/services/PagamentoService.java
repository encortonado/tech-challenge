package br.com.fiap.tech.challenge.application.payment.services;

import br.com.fiap.tech.challenge.adapter.entrypoint.persistance.PagamentoRepository;
import br.com.fiap.tech.challenge.adapter.entrypoint.persistance.PedidoRepository;
import br.com.fiap.tech.challenge.application.orders.entities.PedidoEntity;
import br.com.fiap.tech.challenge.application.payment.entities.FaturaEntity;
import br.com.fiap.tech.challenge.application.payment.entities.RetornoPagamentoFaturaOutputDTO;
import br.com.fiap.tech.challenge.application.payment.ports.IPagamentoUseCase;
import br.com.fiap.tech.challenge.domain.value_objects.enums.EStatusPagamento;
import br.com.fiap.tech.challenge.infrastucture.mapper.PagamentoMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Service
public class PagamentoService implements IPagamentoUseCase {


    private final PagamentoRepository pagamentoRepository;
    private final PedidoRepository pedidoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository, PedidoRepository pedidoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.pedidoRepository = pedidoRepository;
    }


    @Override
    public RetornoPagamentoFaturaOutputDTO confirmaPagamentoFatura(UUID fatura_id) {

        FaturaEntity fatura = pagamentoRepository.findByCodigo(fatura_id);
        fatura.setStatus(EStatusPagamento.PAGO);


        return PagamentoMapper.toDTO(pagamentoRepository.save(fatura));

    }

    @Override
    public RetornoPagamentoFaturaOutputDTO rejeitaPagamentoFatura(UUID fatura_id) {
        FaturaEntity fatura = pagamentoRepository.findByCodigo(fatura_id);
        fatura.setStatus(EStatusPagamento.REJEITADO);


        return PagamentoMapper.toDTO(pagamentoRepository.save(fatura));
    }

    @Override
    public RetornoPagamentoFaturaOutputDTO obtemSituacaoPagamentoFatura(String fatura_id) {

        return PagamentoMapper.toDTO(pagamentoRepository.findByCodigo(UUID.fromString(fatura_id)));
    }

    @Override
    public FaturaEntity criaFaturaPagamento(String codigo_pedido) {

        FaturaEntity fatura = new FaturaEntity();

        fatura.setCodigo(UUID.randomUUID());

        LocalDateTime now = LocalDateTime.now();
        Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        Date dataFatura = Date.from(instant);

        fatura.setDataCriacao(dataFatura);
        fatura.setDataAtualizacao(dataFatura);

        PedidoEntity pedido = pedidoRepository.findById(Long.valueOf(codigo_pedido)).orElseThrow();

        fatura.setPedido(pedido);
        fatura.setStatus(EStatusPagamento.AGUARDANDO_PAGAMENTO);


        return pagamentoRepository.save(fatura);
    }
}
