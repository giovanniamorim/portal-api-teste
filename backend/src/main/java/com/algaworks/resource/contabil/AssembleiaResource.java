package com.algaworks.resource.contabil;


import com.algaworks.model.Assembleia;
import com.algaworks.repository.contabil.assembleia.AssembleiaRepository;
import com.algaworks.repository.filter.AssembleiaFilter;
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
@RequestMapping("/api/assembleias")
@Slf4j
public class AssembleiaResource {
    @Autowired
    AssembleiaRepository assembleiaRepository;


    @PostMapping
    @ResponseStatus(CREATED)
    public Assembleia addInventari(@RequestBody @Valid Assembleia assembleia)  {
        return assembleiaRepository.save(assembleia);
    }

//    @GetMapping
//    public Page<Assembleia> listAllBalances(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
//        return assembleiaRepository.findAll(pageable);
//    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_ASSEMBLEIA') and #oauth2.hasScope('read')")
    public Page<Assembleia> pesquisar(
            AssembleiaFilter assembleiaFilter,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "5") int size,
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return assembleiaRepository.filtrar(assembleiaFilter, pageable);
    }

    @GetMapping("/{id}")
    public Assembleia findAssembleiaById(@PathVariable Long id) {
        return assembleiaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND, "Assembleia não encontrada"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteAssembleia(@PathVariable Long id) {
        assembleiaRepository.findById(id).map(assembleia -> {
            assembleiaRepository.delete(assembleia);
            return TYPE;
        }).orElseThrow(() -> new ResponseStatusException(
                NOT_FOUND, "Assembleia não encontrada"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assembleia> editAssembleia(@PathVariable Long id, @Valid @RequestBody Assembleia newAssembleia){
        return assembleiaRepository.findById(id)
                .map(assembleia -> {
                    assembleia.setData(newAssembleia.getData());
                    assembleia.setTipo((newAssembleia.getTipo()));
                    assembleia.setAssunto(newAssembleia.getAssunto());
                    assembleia.setComentario(newAssembleia.getComentario());
                    assembleia.setFileUrl((newAssembleia.getFileUrl()));
                    Assembleia assembleiaUpdated = assembleiaRepository.save(assembleia);
                    return ResponseEntity.ok().body(assembleiaUpdated);
                }).orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND, "Assembleia não encontrada"));
    }


}
