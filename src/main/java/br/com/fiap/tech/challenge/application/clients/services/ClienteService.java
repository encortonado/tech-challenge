package br.com.fiap.tech.challenge.application.clients.services;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.fiap.tech.challenge.adapter.entrypoint.persistance.ClienteRepository;
import br.com.fiap.tech.challenge.application.clients.entities.ClienteEntity;
import br.com.fiap.tech.challenge.application.clients.ports.IClienteService;
import br.com.fiap.tech.challenge.infrastucture.exceptions.CustomErrorTypeException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteEntity atualizaCliente(ClienteEntity data) {

        buscaClientePorCPF(data.getCpf());

        return clienteRepository.save(data);
    }

    @Override
    public ClienteEntity buscaClientePorCPF(String cpf) {
        validaCPF(cpf);
        return clienteRepository.findById(cpf).orElseThrow(
                () -> new CustomErrorTypeException("Cliente nao encontrado.")
        );
    }

    @Override
    public ClienteEntity deletaCliente(String cpf) {
        ClienteEntity cliente = buscaClientePorCPF(cpf);
        clienteRepository.delete(cliente);

        return cliente;
    }

    @Override
    public List<ClienteEntity> listaClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity registraCliente(ClienteEntity cliente) {
        validaCPF(cliente.getCpf());
        return clienteRepository.save(cliente);
    }


    public void validaCPF(String cpf) {

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.assertValid(cpf);
    }

}
