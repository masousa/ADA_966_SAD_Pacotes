package tech.ada.samples.nine.six.six.controllers;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.ada.samples.nine.six.six.payloads.PacoteContratoResponse;
import tech.ada.samples.nine.six.six.payloads.ContratoRequest;
import tech.ada.samples.nine.six.six.service.CadastraPacoteService;

@RestController
@RequestMapping("/pacote")
@RequiredArgsConstructor
@Slf4j
public class PacoteController {


    private final CadastraPacoteService cadastraPacoteService;
    @PostMapping(path = "", produces = "application/json")
    @ApiResponse(description = "Realiza o contrato de um novo pacote do usuário")
    @ResponseStatus(HttpStatus.CREATED)
    public PacoteContratoResponse contratarPacote(@RequestBody ContratoRequest contratoRequest) throws InterruptedException {
       cadastraPacoteService.execute(contratoRequest);
        log.info("Esperando ou não?");
        return null;
    }
}
