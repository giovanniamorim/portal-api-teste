package com.algaworks.repository.contabil.planoContas;

import com.algaworks.model.PlanoContas;
import com.algaworks.repository.filter.PlanoContasFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlanoContasRepositoryQuery {

	public Page<PlanoContas> filtrar(PlanoContasFilter planoContasFilter, Pageable pageable);
}
