package br.com.fiap.tech.challenge.application.products.port;

import br.com.fiap.tech.challenge.application.products.entities.ProdutoEntity;

public interface IRegistraProdutoUseCase {

    ProdutoEntity registraProduto(ProdutoEntity data);
}
