package tech.ada.samples.nine.six.six.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="pacote")
public class Pacote {

    @EmbeddedId
    private PacotePk pacotePk;
    @Column(name = "id_pacote", insertable = false, updatable = false)
    private Long idPacote;
    @Column(name="id_contrato")
    private Long idContrato;

    @Column(name="id_usuario" , insertable = false, updatable = false)
    private Long idUsuario;

    @Column(name = "status")
    private StatusContrato statusContrato;

}
