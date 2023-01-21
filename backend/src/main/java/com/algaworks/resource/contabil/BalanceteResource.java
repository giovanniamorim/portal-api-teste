package com.algaworks.resource.contabil;

import com.algaworks.model.contabil.Balancete;
import com.algaworks.repository.contabil.BalanceteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static java.lang.Void.TYPE;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/balancetes")
@Slf4j
public class BalanceteResource {
    @Autowired
    BalanceteRepository balanceteRepository;


    @PostMapping
    @ResponseStatus(CREATED)
    public Balancete addBalancete(@RequestBody @Valid Balancete balancete)  {
        if( balanceteRepository.existsByDescricao(balancete.getDescricao())){
            throw new ResponseStatusException(BAD_REQUEST, "Já existe um Balancete cadastrado com este nome");
        }
        return balanceteRepository.save(balancete);
    }

    @GetMapping
    public Page<Balancete> listAllBalances(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
        return balanceteRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Balancete findBalanceteById(@PathVariable Long id) {
        return balanceteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND, "Balancete não encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteBalancete(@PathVariable Long id) {
        balanceteRepository.findById(id).map(user -> {
            balanceteRepository.delete(user);
            return TYPE;
        }).orElseThrow(() -> new ResponseStatusException(
                NOT_FOUND, "Balancete não encontrado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Balancete> editBalancete(@PathVariable Long id, @Valid @RequestBody Balancete newBalancete){
               return balanceteRepository.findById(id)
                .map(balancete -> {
                    balancete.setDescricao(newBalancete.getDescricao());
                    balancete.setFileUrl((newBalancete.getFileUrl()));
                    Balancete balanceteUpdated = balanceteRepository.save(balancete);
                    return ResponseEntity.ok().body(balanceteUpdated);
                }).orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND, "Balancete não encontrado"));
    }


}
