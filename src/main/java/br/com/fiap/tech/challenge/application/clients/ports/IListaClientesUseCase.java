package br.com.fiap.tech.challenge.application.clients.ports;

import br.com.fiap.tech.challenge.application.clients.entities.ClienteEntity;

import java.util.List;

public interface IListaClientesUseCase {

    List<ClienteEntity> listaClientes();

}
