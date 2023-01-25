package com.algaworks.repository.contabil.execucao;

import com.algaworks.model.Execucao;
import com.algaworks.repository.filter.ExecucaoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExecucaoRepositoryQuery {

	public Page<Execucao> filtrar(ExecucaoFilter execucaoFilter, Pageable pageable);
}
