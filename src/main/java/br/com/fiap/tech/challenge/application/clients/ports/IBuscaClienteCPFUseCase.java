package br.com.fiap.tech.challenge.application.clients.ports;

import br.com.fiap.tech.challenge.application.clients.entities.ClienteEntity;

public interface IBuscaClienteCPFUseCase {

    ClienteEntity buscaClientePorCPF(String cpf);

}
