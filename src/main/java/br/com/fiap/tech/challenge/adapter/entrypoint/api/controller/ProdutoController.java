package br.com.fiap.tech.challenge.adapter.entrypoint.api.controller;

import br.com.fiap.tech.challenge.adapter.entrypoint.api.model.ProdutoDTO;
import br.com.fiap.tech.challenge.application.products.entities.ProdutoEntity;
import br.com.fiap.tech.challenge.application.products.services.ProdutoService;
import br.com.fiap.tech.challenge.domain.value_objects.enums.ECategoria;
import br.com.fiap.tech.challenge.infrastucture.mapper.ProductMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/product")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> findProductByCodigo(
            @PathVariable(value = "id") Long codigo) {


        return ResponseEntity.ok().body(ProductMapper.toDTO(produtoService.buscaProduto(codigo)));
    }

    @GetMapping()
    public ResponseEntity<?> findAllByCategoriaId(@RequestParam("codigo_categoria") int categoriaId) {
        try {
            ECategoria categoria = ECategoria.values()[categoriaId];
            List<ProdutoDTO> produtoDTOS = new ArrayList<>();
            List<ProdutoEntity> produtos = produtoService.buscaProdutoPorCategoria(categoria);

            produtos.forEach(produtoEntity -> produtoDTOS.add(ProductMapper.toDTO(produtoEntity)));

            return ResponseEntity.ok(produtoDTOS);
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao buscar produtos");
        }


    }

    @PostMapping()
    public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO produto) {

        ProdutoEntity produtoEntity = produtoService.registraProduto(ProductMapper.toEntity(produto));
        URI location = URI.create(String.format("/product/%d", produtoEntity.getCodigo()));

        return ResponseEntity.created(location).body(ProductMapper.toDTO(produtoEntity));
    }

    @PutMapping
    public ResponseEntity<ProdutoDTO> update(@RequestBody ProdutoDTO produto) {

        ProdutoEntity produtoEntity = produtoService.alteraProduto(ProductMapper.toEntity(produto));

        return ResponseEntity.ok(ProductMapper.toDTO(produtoEntity));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        produtoService.deletaProduto(id);
        return ResponseEntity.ok().body("Produto Deletado com sucesso");
    }


}
