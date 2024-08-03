package br.com.fiap.tech.challenge.infrastucture.mapper;

import br.com.fiap.tech.challenge.adapter.entrypoint.api.model.PedidoDTO;
import br.com.fiap.tech.challenge.adapter.entrypoint.api.model.ProdutoDTO;
import br.com.fiap.tech.challenge.application.orders.entities.PedidoEntity;
import br.com.fiap.tech.challenge.application.payment.entities.FaturaEntity;
import br.com.fiap.tech.challenge.application.payment.entities.RetornoPagamentoFaturaOutputDTO;
import br.com.fiap.tech.challenge.application.products.entities.ProdutoEntity;
import br.com.fiap.tech.challenge.domain.value_objects.enums.ECategoria;
import br.com.fiap.tech.challenge.infrastucture.exceptions.CustomErrorTypeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PagamentoMapper {

    private static String categoriaError =
            "Valor de Categoria inserido está fora do alcance, os enums disponiveis sao: "
                    + Arrays.toString(ECategoria.values());


    public static RetornoPagamentoFaturaOutputDTO toDTO(FaturaEntity faturaEntity) {
        try {
            RetornoPagamentoFaturaOutputDTO dto = new RetornoPagamentoFaturaOutputDTO();
            dto.setDataAtualizacao(faturaEntity.getDataAtualizacao());
            dto.setSituacao(faturaEntity.getStatus());
            dto.setFaturaId(faturaEntity.getCodigo().toString());
            dto.setPedidoCpf(faturaEntity.getPedido().getCpf());
            dto.setDataCriacao(faturaEntity.getDataCriacao());
            dto.setPedidoCodigo(Math.toIntExact(faturaEntity.getPedido().getCodigo()));
            return dto;
        } catch (ArrayIndexOutOfBoundsException ex){
            throw new CustomErrorTypeException(categoriaError);
        }
    }

}
