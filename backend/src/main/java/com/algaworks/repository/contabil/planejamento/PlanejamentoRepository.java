package com.algaworks.repository.contabil.planejamento;

import com.algaworks.model.Planejamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanejamentoRepository extends JpaRepository<Planejamento, Long>, PlanejamentoRepositoryQuery {


}
