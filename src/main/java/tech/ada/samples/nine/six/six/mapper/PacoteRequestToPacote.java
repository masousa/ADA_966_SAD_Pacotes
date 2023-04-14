package tech.ada.samples.nine.six.six.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tech.ada.samples.nine.six.six.entity.Pacote;
import tech.ada.samples.nine.six.six.entity.PacotePk;
import tech.ada.samples.nine.six.six.entity.StatusContrato;
import tech.ada.samples.nine.six.six.payloads.ContratoRequest;
import tech.ada.samples.nine.six.six.payloads.PacoteRequest;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PacoteRequestToPacote {
    public static Pacote map(PacoteRequest pacoteRequest, ContratoRequest contratoRequest){
        Pacote pacote = new Pacote();
        pacote.setIdPacote(pacoteRequest.getIdPacote());
        pacote.setIdUsuario(contratoRequest.getUsuarioId());
        pacote.setIdContrato(contratoRequest.getIdContrato());
        pacote.setPacotePk(new PacotePk(pacote.getIdPacote(), contratoRequest.getUsuarioId()));
        pacote.setStatusContrato(StatusContrato.INICIADO);
        return pacote;
    }
}
