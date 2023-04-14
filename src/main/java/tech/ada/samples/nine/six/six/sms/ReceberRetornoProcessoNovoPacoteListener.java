package tech.ada.samples.nine.six.six.sms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import tech.ada.samples.nine.six.six.payloads.PacoteUsuarioRequest;
import tech.ada.samples.nine.six.six.service.AtualizarStatusContratoPacoteService;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReceberRetornoProcessoNovoPacoteListener {
    private final ObjectMapper objectMapper;
    private final AtualizarStatusContratoPacoteService atualizarStatusContratoPacoteService;
    @RabbitListener(queues = {"${business.in.retorno-fatura}"})
    public void receiveMessage(String message) throws JsonProcessingException {
        log.info("Recebendo retorno do pagamento {}", message);
        List<PacoteUsuarioRequest> pacoteUsuarioRequest = Arrays.asList(objectMapper.readValue(message, PacoteUsuarioRequest[].class));

    }
}
