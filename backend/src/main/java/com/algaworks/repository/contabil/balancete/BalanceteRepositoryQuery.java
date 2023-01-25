package com.algaworks.repository.contabil.balancete;

import com.algaworks.model.Balancete;
import com.algaworks.repository.filter.BalanceteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BalanceteRepositoryQuery {

	public Page<Balancete> filtrar(BalanceteFilter balanceteFilter, Pageable pageable);
}
