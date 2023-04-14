package tech.ada.samples.nine.six.six.payloads;

import lombok.Data;
import tech.ada.samples.nine.six.six.entity.StatusContrato;

@Data
public class PacoteUsuarioRequest {

    private Long idUsuario;
    private Long idPacote;
    private double valor;
    private StatusContrato status;
}
