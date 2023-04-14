package tech.ada.samples.nine.six.six.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tech.ada.samples.nine.six.six.entity.Pacote;
import tech.ada.samples.nine.six.six.entity.PacotePk;
import tech.ada.samples.nine.six.six.payloads.PacoteUsuarioRequest;
import tech.ada.samples.nine.six.six.repository.PacoteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AtualizarStatusContratoPacoteService {

    private final PacoteRepository pacoteRepository;

    public void execute(List<PacoteUsuarioRequest> pacoteUsuarioRequestList){
        List<Pacote> pacotesParaSalvar = new ArrayList<>();
        pacoteUsuarioRequestList.forEach(pacoteUsuarioRequest -> {
            PacotePk pacotePk = new PacotePk(pacoteUsuarioRequest.getIdPacote(),pacoteUsuarioRequest.getIdUsuario());
            Optional<Pacote> optionalPacote = pacoteRepository.findById(pacotePk);
            if(optionalPacote.isPresent()){
                Pacote pacote = optionalPacote.get();
                pacote.setStatusContrato(pacoteUsuarioRequest.getStatus());
                pacotesParaSalvar.add(pacote);
            }
        });

        if(!CollectionUtils.isEmpty(pacotesParaSalvar)){
            pacoteRepository.saveAll(pacotesParaSalvar);
        }

    }
}
