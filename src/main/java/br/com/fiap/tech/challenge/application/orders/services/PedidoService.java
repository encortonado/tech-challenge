package br.com.fiap.tech.challenge.application.orders.services;

import br.com.fiap.tech.challenge.adapter.entrypoint.api.model.PedidoDTO;
import br.com.fiap.tech.challenge.adapter.entrypoint.api.model.PedidoInputDTO;
import br.com.fiap.tech.challenge.adapter.entrypoint.persistance.PedidoRepository;
import br.com.fiap.tech.challenge.application.clients.services.ClienteService;
import br.com.fiap.tech.challenge.application.payment.entities.AtualizaStatusPedidoDTO;
import br.com.fiap.tech.challenge.application.payment.entities.AtualizaStatusPedidoOutputDTO;
import br.com.fiap.tech.challenge.application.orders.entities.PedidoEntity;
import br.com.fiap.tech.challenge.application.orders.entities.PedidoProdutoEntity;
import br.com.fiap.tech.challenge.application.orders.ports.IPedidoUseCases;
import br.com.fiap.tech.challenge.application.payment.entities.FaturaEntity;
import br.com.fiap.tech.challenge.application.payment.services.PagamentoService;
import br.com.fiap.tech.challenge.application.products.entities.ProdutoEntity;
import br.com.fiap.tech.challenge.application.products.services.ProdutoService;
import br.com.fiap.tech.challenge.domain.value_objects.enums.EStatus;
import br.com.fiap.tech.challenge.infrastucture.exceptions.CustomErrorTypeException;
import br.com.fiap.tech.challenge.infrastucture.mapper.OrderMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class PedidoService implements IPedidoUseCases {

    private final PedidoRepository pedidoRepository;

    private final ProdutoService produtoService;

    private final ClienteService clienteService;
    private final PagamentoService pagamentoService;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoService produtoService, ClienteService clienteService, PagamentoService pagamentoService) {
        this.pedidoRepository = pedidoRepository;
        this.produtoService = produtoService;
        this.clienteService = clienteService;
        this.pagamentoService = pagamentoService;
    }

    @Override
    public AtualizaStatusPedidoOutputDTO atualizaStatusPedido(AtualizaStatusPedidoDTO data) {

        PedidoEntity pedido = pedidoRepository.findById(data.getId()).orElseThrow(
                () -> new CustomErrorTypeException("Pedido nao encontrado."));

        pedido.setStatus(data.getStatus());

        return new AtualizaStatusPedidoOutputDTO(
                pedido.getCodigo(),
                pedido.getStatus().getDescricao(),
                pedido.getStatus().ordinal());
    }

    @Override
    public List<PedidoDTO> listaPedidosPorStatus(EStatus status) {
        List<PedidoEntity> pedido = pedidoRepository.findByStatus(status);

        return pedido
                .stream()
                .map(OrderMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional()
    public List<PedidoDTO> listaPedidos() {
        List<PedidoEntity> pedido = pedidoRepository.findAll();

        return pedido
                .stream()
                .map(OrderMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public PedidoEntity registraPedido(PedidoInputDTO data) {

        PedidoEntity pedidoToSave = new PedidoEntity();

        pedidoToSave.setCpf(data.getCpf());
        pedidoToSave.setStatus(EStatus.AGUARDANDO_PAGAMENTO);

        LocalDateTime now = LocalDateTime.now();
        Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        Date dataPedido = Date.from(instant);
        pedidoToSave.setDataPedido(dataPedido);


        List<PedidoProdutoEntity> pedidoProdutos = data.getItemDePedido()
                .stream()
                .map(item -> {
                    ProdutoEntity produto = produtoService.buscaProduto(item.getCodigo());

                    PedidoProdutoEntity pedidoProduto = new PedidoProdutoEntity();
                    pedidoProduto.setProduto(produto);
                    pedidoProduto.setPedido(pedidoToSave);
                    pedidoProduto.setQuantidade(item.getQuantidade());

                    return pedidoProduto;
                })
                .toList();

        pedidoToSave.getPedidoProduto().addAll(pedidoProdutos);


        PedidoEntity pedidoSaved = pedidoRepository.save(pedidoToSave);

        FaturaEntity fatura = sendToPayment(
                pedidoSaved.getCodigo().toString());

        pedidoSaved.setFatura(fatura);

        pedidoSaved = pedidoRepository.save(pedidoSaved);

        return pedidoSaved;
    }

    private FaturaEntity sendToPayment(String codigoPedido) {
        return pagamentoService.criaFaturaPagamento(codigoPedido);
    }

}
