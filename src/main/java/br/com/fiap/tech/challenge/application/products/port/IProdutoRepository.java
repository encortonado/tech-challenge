package br.com.fiap.tech.challenge.application.products.port;

import br.com.fiap.tech.challenge.application.products.entities.ProdutoEntity;
import br.com.fiap.tech.challenge.domain.value_objects.enums.ECategoria;

import java.util.List;

public interface IProdutoRepository {
    ProdutoEntity buscaProdutoPorCodigo(Long codigo);
    List<ProdutoEntity> buscaProdutoPorCategoria(ECategoria categoriaCodigo);
    ProdutoEntity registraProduto(ProdutoEntity produto);
    ProdutoEntity alteraProduto(ProdutoEntity produto);
    ProdutoEntity deletaProduto(int codigo);
}
