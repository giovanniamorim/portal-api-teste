package com.algaworks.repository.contabil.balancete;

import com.algaworks.model.Balancete;
import com.algaworks.repository.filter.BalanceteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BalanceteRepositoryImpl implements BalanceteRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;


	@Override
	public Page<Balancete> filtrar(BalanceteFilter BalanceteFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Balancete> criteria = builder.createQuery(Balancete.class);
		
		Root<Balancete> root = criteria.from(Balancete.class);
		
		//cria as restrições
		Predicate[] predicates = criarRestricoes(BalanceteFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Balancete> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(BalanceteFilter));
	}


	@SuppressWarnings("deprecation")
	private Predicate[] criarRestricoes(BalanceteFilter BalanceteFilter, CriteriaBuilder builder, Root<Balancete> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(BalanceteFilter.getAno())) {
			predicates.add(builder.equal(builder.lower(root.get("ano")), BalanceteFilter.getAno()));
		}
		
		if (!StringUtils.isEmpty(BalanceteFilter.getMes())) {
			predicates.add(builder.equal(builder.lower(root.get("mes")), BalanceteFilter.getMes()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(BalanceteFilter BalanceteFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Balancete> roor = criteria.from(Balancete.class);
		
		Predicate[] predicates = criarRestricoes(BalanceteFilter, builder, roor);
		criteria.where(predicates);
		
		criteria.select(builder.count(roor));
		
		return manager.createQuery(criteria).getSingleResult();
	}


}
