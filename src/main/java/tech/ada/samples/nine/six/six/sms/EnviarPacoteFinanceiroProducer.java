package tech.ada.samples.nine.six.six.sms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tech.ada.samples.nine.six.six.payloads.ContratoRequest;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnviarPacoteFinanceiroProducer {
    @Value("${business.out.fatura}")
    private String kafkaTopicName;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendPacoteFinanceiro(ContratoRequest contratoRequest){
        log.info("Mensagem enviada pelo kafka {}", contratoRequest);
        try {
            kafkaTemplate.send(kafkaTopicName, objectMapper.writeValueAsString(contratoRequest));
        } catch (JsonProcessingException e) {
            log.error("Erro ao converter objeto em json file");
            throw new RuntimeException(e);
        }
    }


}
