package br.com.fiap.tech.challenge.adapter.entrypoint.persistance;

import br.com.fiap.tech.challenge.application.orders.entities.PedidoEntity;
import br.com.fiap.tech.challenge.domain.value_objects.enums.EStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findByStatus(EStatus status);

}
