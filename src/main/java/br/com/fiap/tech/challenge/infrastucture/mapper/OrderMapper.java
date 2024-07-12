package br.com.fiap.tech.challenge.infrastucture.mapper;

import br.com.fiap.tech.challenge.adapter.entrypoint.api.model.PedidoDTO;
import br.com.fiap.tech.challenge.adapter.entrypoint.api.model.ProdutoDTO;
import br.com.fiap.tech.challenge.application.orders.entities.PedidoEntity;
import br.com.fiap.tech.challenge.application.products.entities.ProdutoEntity;
import br.com.fiap.tech.challenge.domain.value_objects.enums.ECategoria;
import br.com.fiap.tech.challenge.infrastucture.exceptions.CustomErrorTypeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderMapper {

    private static String categoriaError =
            "Valor de Categoria inserido está fora do alcance, os enums disponiveis sao: "
                    + Arrays.toString(ECategoria.values());


    public static PedidoDTO toDTO(PedidoEntity pedidoEntity) {
        try {
            List<ProdutoDTO> produtoDTOS = new ArrayList<>();
            pedidoEntity.getPedidoProduto().forEach(item -> {
                ProdutoDTO produtoDTO = ProductMapper.toDTO(item.getProduto());
                produtoDTOS.add(produtoDTO);
            });

            PedidoDTO dto = new PedidoDTO();
            dto.setCodigo(pedidoEntity.getCodigo());
            dto.setCpf(pedidoEntity.getCpf());
            dto.setStatus(pedidoEntity.getStatus());
            dto.setProdutos(produtoDTOS);
            dto.setDataPedido(pedidoEntity.getDataPedido());
            return dto;
        } catch (ArrayIndexOutOfBoundsException ex){
            throw new CustomErrorTypeException(categoriaError);
        }
    }

}
