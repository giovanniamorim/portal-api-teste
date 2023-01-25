package com.algaworks.repository.contabil.balanco;

import com.algaworks.model.Balanco;
import com.algaworks.repository.filter.BalancoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BalancoRepositoryQuery {

	public Page<Balanco> filtrar(BalancoFilter balancoFilter, Pageable pageable);
}
