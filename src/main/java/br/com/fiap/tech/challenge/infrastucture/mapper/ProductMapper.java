package br.com.fiap.tech.challenge.infrastucture.mapper;

import br.com.fiap.tech.challenge.adapter.entrypoint.api.model.ProdutoDTO;
import br.com.fiap.tech.challenge.application.products.entities.ProdutoEntity;
import br.com.fiap.tech.challenge.domain.value_objects.enums.ECategoria;
import br.com.fiap.tech.challenge.infrastucture.exceptions.CustomErrorTypeException;

import java.util.Arrays;

public class ProductMapper {

    private static String categoriaError =
            "Valor de Categoria inserido está fora do alcance, os enums disponiveis sao: "
                    + Arrays.toString(ECategoria.values());


    public static ProdutoDTO toDTO(ProdutoEntity produtoEntity) {
        try {
            ProdutoDTO dto = new ProdutoDTO();
            dto.setCodigo(produtoEntity.getCodigo());
            dto.setNome(produtoEntity.getNome());
            dto.setDescricao(produtoEntity.getDescricao());
            dto.setValor(produtoEntity.getValor());
            dto.setCategoriaCodigo(produtoEntity.getCategoriaCodigo().ordinal());
            return dto;
        } catch (ArrayIndexOutOfBoundsException ex){
            throw new CustomErrorTypeException(categoriaError);
        }
    }

    public static ProdutoEntity toEntity(ProdutoDTO produtoDTO) {
        try {
            ProdutoEntity entity = new ProdutoEntity();
            entity.setCodigo(produtoDTO.getCodigo());
            entity.setNome(produtoDTO.getNome());
            entity.setDescricao(produtoDTO.getDescricao());
            entity.setValor(produtoDTO.getValor());
            entity.setCategoriaCodigo(ECategoria.values()[produtoDTO.getCategoriaCodigo()]);
            return entity;
        } catch (ArrayIndexOutOfBoundsException ex){
            throw new CustomErrorTypeException(categoriaError);
        }

    }
}
