package tech.ada.samples.nine.six.six.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.samples.nine.six.six.entity.Pacote;
import tech.ada.samples.nine.six.six.entity.PacotePk;

public interface PacoteRepository extends JpaRepository<Pacote, PacotePk> {
}