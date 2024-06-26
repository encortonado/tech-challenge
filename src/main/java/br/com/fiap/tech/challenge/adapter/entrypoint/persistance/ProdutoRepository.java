package br.com.fiap.tech.challenge.adapter.entrypoint.persistance;

import br.com.fiap.tech.challenge.application.products.entities.ProdutoEntity;
import br.com.fiap.tech.challenge.domain.value_objects.enums.ECategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    List<ProdutoEntity> findByCategoriaCodigo(ECategoria categoria);
}
