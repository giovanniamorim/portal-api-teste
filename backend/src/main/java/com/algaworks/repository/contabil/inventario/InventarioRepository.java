package com.algaworks.repository.contabil.inventario;

import com.algaworks.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long>, InventarioRepositoryQuery {


}
