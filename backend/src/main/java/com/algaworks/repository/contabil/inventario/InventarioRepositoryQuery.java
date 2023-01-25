package com.algaworks.repository.contabil.inventario;

import com.algaworks.model.Inventario;
import com.algaworks.repository.filter.InventarioFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InventarioRepositoryQuery {

	public Page<Inventario> filtrar(InventarioFilter inventarioFilter, Pageable pageable);
}
