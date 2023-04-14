package tech.ada.samples.nine.six.six.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import tech.ada.samples.nine.six.six.entity.Pacote;
import tech.ada.samples.nine.six.six.mapper.PacoteRequestToPacote;
import tech.ada.samples.nine.six.six.payloads.ContratoRequest;
import tech.ada.samples.nine.six.six.repository.PacoteRepository;
import tech.ada.samples.nine.six.six.sms.EnviarPacoteFinanceiroProducer;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CadastraPacoteService {
    private final PacoteRepository pacoteRepository;

    private final EnviarPacoteFinanceiroProducer enviarPacoteFinanceiroProducer;


    public void execute(ContratoRequest contratoRequest) throws InterruptedException {

        List<Pacote> pacoteList = contratoRequest.getPacotes().stream()
                .map(pacoteRequest -> PacoteRequestToPacote.map(pacoteRequest, contratoRequest)).collect(Collectors.toList());

        pacoteRepository.saveAll(pacoteList);
        enviarPacoteFinanceiroProducer.sendPacoteFinanceiro(contratoRequest);
    }
}
