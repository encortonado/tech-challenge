package br.com.fiap.tech.challenge.application.products.services;

import br.com.fiap.tech.challenge.adapter.entrypoint.persistance.ProdutoRepository;
import br.com.fiap.tech.challenge.application.products.entities.ProdutoEntity;
import br.com.fiap.tech.challenge.application.products.port.IProdutoService;
import br.com.fiap.tech.challenge.domain.value_objects.enums.ECategoria;
import br.com.fiap.tech.challenge.infrastucture.exceptions.CustomErrorTypeException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements IProdutoService {

    private final ProdutoRepository produtoRepository;


    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoEntity alteraProduto(ProdutoEntity data) {

        buscaProduto(data.getCodigo());

        return produtoRepository.save(data);
    }

    @Override
    public ProdutoEntity buscaProduto(Long data) {

        return produtoRepository.findById(data).orElseThrow(
                () -> new CustomErrorTypeException("Produto nao encontrado.")
        );
    }

    @Override
    public ProdutoEntity deletaProduto(Long data) {
        ProdutoEntity product = buscaProduto(data);
        produtoRepository.delete(product);

        return product;
    }

    @Override
    public List<ProdutoEntity> buscaProdutoPorCategoria(ECategoria categoria) {

        return produtoRepository.findByCategoriaCodigo(categoria);
    }

    @Override
    public ProdutoEntity registraProduto(ProdutoEntity data) {

        return produtoRepository.save(data);
    }
}
