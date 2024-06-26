package br.com.fiap.tech.challenge.application.products.port;

import br.com.fiap.tech.challenge.application.products.entities.ProdutoEntity;
import br.com.fiap.tech.challenge.domain.value_objects.enums.ECategoria;

import java.util.List;

public interface IListaProdutoPorCategoriaUseCase {

    List<ProdutoEntity> buscaProdutoPorCategoria(ECategoria categoria);

}
