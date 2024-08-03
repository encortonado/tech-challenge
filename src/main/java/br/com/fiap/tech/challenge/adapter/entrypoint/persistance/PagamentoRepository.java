package br.com.fiap.tech.challenge.adapter.entrypoint.persistance;

import br.com.fiap.tech.challenge.application.payment.entities.FaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PagamentoRepository extends JpaRepository<FaturaEntity, Long> {

    FaturaEntity findByCodigo(UUID codigo);

}
