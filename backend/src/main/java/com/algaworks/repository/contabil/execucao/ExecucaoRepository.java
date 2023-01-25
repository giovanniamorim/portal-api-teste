package com.algaworks.repository.contabil.execucao;

import com.algaworks.model.Execucao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecucaoRepository extends JpaRepository<Execucao, Long>, ExecucaoRepositoryQuery {


}
