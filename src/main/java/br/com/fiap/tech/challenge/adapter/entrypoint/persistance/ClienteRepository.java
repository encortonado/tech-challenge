package br.com.fiap.tech.challenge.adapter.entrypoint.persistance;

import br.com.fiap.tech.challenge.application.clients.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {
}
