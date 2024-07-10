package br.com.fiap.tech.challenge.adapter.entrypoint.api.controller;

import br.com.fiap.tech.challenge.application.clients.entities.ClienteEntity;
import br.com.fiap.tech.challenge.application.clients.services.ClienteService;
import br.com.fiap.tech.challenge.infrastucture.mapper.ProductMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteEntity> findByCpf(@PathVariable("id") String cpf) {

        return ResponseEntity.ok().body(clienteService.buscaClientePorCPF(cpf));
    }

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> findAll() {

        return ResponseEntity.ok().body(clienteService.listaClientes());
    }

    @PostMapping
    public ResponseEntity<ClienteEntity> save(@RequestBody ClienteEntity cliente) {

        ClienteEntity clienteEntity = clienteService.registraCliente(cliente);
        URI location = URI.create(String.format("/client/%s", clienteEntity.getCpf()));

        return ResponseEntity.created(location).body(clienteEntity);

    }

    @PutMapping
    public ResponseEntity<ClienteEntity> update(@RequestBody ClienteEntity cliente) {

        return ResponseEntity.ok().body(clienteService.atualizaCliente(cliente));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") String cpf) {
        clienteService.deletaCliente(cpf);
        return ResponseEntity.ok().body("Cliente descadastrado com sucesso");
    }

}
