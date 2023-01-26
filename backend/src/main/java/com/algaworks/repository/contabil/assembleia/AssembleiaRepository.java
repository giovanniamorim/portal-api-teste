package com.algaworks.repository.contabil.assembleia;

import com.algaworks.model.Assembleia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssembleiaRepository extends JpaRepository<Assembleia, Long>, AssembleiaRepositoryQuery {


}
