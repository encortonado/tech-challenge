package br.com.fiap.tech.challenge.adapter.entrypoint.api.controller;

import br.com.fiap.tech.challenge.adapter.entrypoint.api.model.PedidoDTO;
import br.com.fiap.tech.challenge.adapter.entrypoint.api.model.PedidoInputDTO;
import br.com.fiap.tech.challenge.application.payment.entities.AtualizaStatusPedidoDTO;
import br.com.fiap.tech.challenge.application.payment.entities.AtualizaStatusPedidoOutputDTO;
import br.com.fiap.tech.challenge.application.orders.entities.PedidoEntity;
import br.com.fiap.tech.challenge.application.orders.services.PedidoService;
import br.com.fiap.tech.challenge.domain.value_objects.enums.EStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    ResponseEntity<List<PedidoDTO>> listPedidos() {

        return ResponseEntity.ok().body(pedidoService.listaPedidos());
    }

    @GetMapping(value = "/{status}")
    ResponseEntity<List<PedidoDTO>> listPedidosByStatus(@PathVariable("status") int status) {

        EStatus eStatus = EStatus.values()[status];

        return ResponseEntity.ok().body(pedidoService.listaPedidosPorStatus(eStatus));
    }

    @PostMapping
    ResponseEntity<PedidoEntity> createPedido(@RequestBody PedidoInputDTO pedidoEntity) {

        return ResponseEntity.ok().body(pedidoService.registraPedido(pedidoEntity));
    }

    @PatchMapping("/{id}")
    ResponseEntity<AtualizaStatusPedidoOutputDTO> updatePedido(@PathVariable("id") int id, @RequestBody int status) {

        AtualizaStatusPedidoDTO atualizaStatusPedidoDTO = new AtualizaStatusPedidoDTO();
        atualizaStatusPedidoDTO.setId((long) id);
        atualizaStatusPedidoDTO.setStatus(EStatus.values()[status]);

        return ResponseEntity.ok().body(pedidoService.atualizaStatusPedido(atualizaStatusPedidoDTO));
    }

}
