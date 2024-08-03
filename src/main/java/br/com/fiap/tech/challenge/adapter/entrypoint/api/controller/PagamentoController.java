package br.com.fiap.tech.challenge.adapter.entrypoint.api.controller;

import br.com.fiap.tech.challenge.application.payment.entities.RetornoPagamentoFaturaOutputDTO;
import br.com.fiap.tech.challenge.application.payment.services.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }


    @GetMapping("status/{fatura_id}")
    ResponseEntity<RetornoPagamentoFaturaOutputDTO> situacaoPagamento(
            @PathVariable(value = "fatura_id") String faturaId) {


        return ResponseEntity.ok().body(pagamentoService.obtemSituacaoPagamentoFatura(faturaId));
    }

    @PostMapping("/webhook/approve/{fatura_id}")
    ResponseEntity<RetornoPagamentoFaturaOutputDTO> aprovacaoPagamento(
            @PathVariable(value = "fatura_id") String faturaId) {


        return ResponseEntity.ok().body(pagamentoService.confirmaPagamentoFatura(UUID.fromString(faturaId)));
    }

    @PostMapping("/webhook/deny/{fatura_id}")
    ResponseEntity<RetornoPagamentoFaturaOutputDTO> negaPagamento(
            @PathVariable(value = "fatura_id") String faturaId) {

        return ResponseEntity.ok().body(pagamentoService.rejeitaPagamentoFatura(UUID.fromString(faturaId)));
    }



}
