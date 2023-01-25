package com.algaworks.repository.contabil.balancete;

import com.algaworks.model.Balancete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceteRepository extends JpaRepository<Balancete, Long>, BalanceteRepositoryQuery {


}
