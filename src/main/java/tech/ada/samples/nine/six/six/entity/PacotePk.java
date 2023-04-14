package tech.ada.samples.nine.six.six.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class PacotePk implements Serializable {
    private static final long serialVersionUID = 8691779408263498407L;
    @Column(name = "id_pacote")
    private Long idPacote;

    @Column(name="id_usuario")
    private Long idUsuario;

    public PacotePk(Long idPacote , Long idUsuario){
        this.idPacote = idPacote;
        this.idUsuario = idUsuario;
    }

}
