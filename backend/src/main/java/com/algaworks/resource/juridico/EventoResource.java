package com.algaworks.resource.juridico;


import com.algaworks.model.Evento;
import com.algaworks.model.Processo;
import com.algaworks.repository.juridico.processo.EventoRepository;
import com.algaworks.repository.juridico.processo.ProcessoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static java.lang.Void.TYPE;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/juridico/eventos")
@Slf4j
public class EventoResource {
    @Autowired
    EventoRepository eventoRepository;

    @PostMapping
    @ResponseStatus(CREATED)
    public Evento addEventoJuridico(@RequestBody @Valid Evento evento)  {
        return eventoRepository.save(evento);
    }


    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_JUR_EVENTO') and #oauth2.hasScope('read')")
    public Page<Evento> listAllBalances(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
        return eventoRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Evento findEventoJuridicoById(@PathVariable Long id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND, "Evento não encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteEventoJuridico(@PathVariable Long id) {
        eventoRepository.findById(id).map(user -> {
            eventoRepository.delete(user);
            return TYPE;
        }).orElseThrow(() -> new ResponseStatusException(
                NOT_FOUND, "Evento não encontrado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> editEventoJuridico(@PathVariable Long id, @Valid @RequestBody Evento newEvento){
        return eventoRepository.findById(id)
                .map(evento -> {
                    evento.setNome(newEvento.getNome());
                    evento.setData(newEvento.getData());
                    evento.setDescricao(newEvento.getDescricao());
                    evento.setProcesso(newEvento.getProcesso());
                    evento.setFileUrl((newEvento.getFileUrl()));
                    Evento eventoUpdated = eventoRepository.save(evento);
                    return ResponseEntity.ok().body(eventoUpdated);
                }).orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND, "Evento não encontrado"));
    }


}