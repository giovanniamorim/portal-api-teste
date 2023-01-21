package com.algaworks.repository.contabil;

import com.algaworks.model.contabil.Balancete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BalanceteRepository extends JpaRepository<Balancete, Long> {

    Optional<Balancete> findByDescricao(String descricao);
    boolean existsByDescricao(String descricao);

}
