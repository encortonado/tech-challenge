package br.com.fiap.tech.challenge.application.products.port;

import br.com.fiap.tech.challenge.application.products.entities.ProdutoEntity;

public interface IDeletaProdutoUseCase {

    ProdutoEntity deletaProduto(Long data);

}
