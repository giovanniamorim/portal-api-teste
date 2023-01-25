package com.algaworks.repository.contabil.planejamento;

import com.algaworks.model.Planejamento;
import com.algaworks.repository.filter.PlanejamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlanejamentoRepositoryQuery {

	public Page<Planejamento> filtrar(PlanejamentoFilter planejamentoFilter, Pageable pageable);
}
