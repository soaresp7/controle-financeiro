package br.com.tatu.controlefinanceiro.controller;


import br.com.tatu.controlefinanceiro.Dto.TransacaoDto;
import br.com.tatu.controlefinanceiro.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/transacao")
@RequiredArgsConstructor
public class TransacaoController {

private final TransacaoService transacaoService;



@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public void save(@RequestBody TransacaoDto transacao){
    transacaoService.save(transacao);
}








}
