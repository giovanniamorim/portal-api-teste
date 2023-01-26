package com.algaworks.repository.contabil.assembleia;

import com.algaworks.model.Assembleia;
import com.algaworks.repository.filter.AssembleiaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AssembleiaRepositoryQuery {

	public Page<Assembleia> filtrar(AssembleiaFilter assembleiaFilter, Pageable pageable);
}
