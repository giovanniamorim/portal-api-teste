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
@RequestMapping("/api/juridico/processos")
@Slf4j
public class ProcessoResource {
    @Autowired
    ProcessoRepository processoRepository;

    @PostMapping
    @ResponseStatus(CREATED)
    public Processo addProcesso(@RequestBody @Valid Processo processo)  {
        return processoRepository.save(processo);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_JUR_PROCESSO') and #oauth2.hasScope('read')")
    public Page<Processo> listAllBalances(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
        return processoRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Processo findProcessoById(@PathVariable Long id) {
        return processoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND, "Processo não encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteProcesso(@PathVariable Long id) {
        processoRepository.findById(id).map(user -> {
            processoRepository.delete(user);
            return TYPE;
        }).orElseThrow(() -> new ResponseStatusException(
                NOT_FOUND, "Processo não encontrado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Processo> editProcesso(@PathVariable Long id, @Valid @RequestBody Processo newProcesso){
        return processoRepository.findById(id)
                .map(processo -> {
                    processo.setNumero(newProcesso.getNumero());
                    processo.setExequente(newProcesso.getExequente());
                    processo.setExecutado(newProcesso.getExecutado());
                    processo.setJuizo(newProcesso.getJuizo());
                    processo.setJuiz(newProcesso.getJuiz());
                    processo.setAssunto(newProcesso.getAssunto());
                    processo.setEventos(newProcesso.getEventos());
                    Processo processoUpdated = processoRepository.save(processo);
                    return ResponseEntity.ok().body(processoUpdated);
                }).orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND, "Processo não encontrado"));
    }


}