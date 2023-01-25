package com.algaworks.repository.contabil.balanco;

import com.algaworks.model.Balanco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalancoRepository extends JpaRepository<Balanco, Long>, BalancoRepositoryQuery {


}
