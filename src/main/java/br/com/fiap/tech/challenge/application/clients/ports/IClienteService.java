package br.com.fiap.tech.challenge.application.clients.ports;

public interface IClienteService extends
        IRegistraClienteUseCase,
        IAtualizaClienteUseCase,
        IBuscaClienteCPFUseCase,
        IListaClientesUseCase,
        IDeletaClienteUseCase {
}
