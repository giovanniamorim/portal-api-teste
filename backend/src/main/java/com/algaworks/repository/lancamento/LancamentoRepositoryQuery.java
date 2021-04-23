package com.algaworks.repository.lancamento;

import java.util.List;

import com.algaworks.model.Lancamento;
import com.algaworks.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {

	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
}
