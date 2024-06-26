package br.com.fiap.tech.challenge.application.products.port;

import br.com.fiap.tech.challenge.application.products.entities.ProdutoEntity;

public interface IBuscaProdutoUseCase {

    ProdutoEntity buscaProduto(Long data) throws Throwable;

}
