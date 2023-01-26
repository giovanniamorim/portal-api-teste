package com.algaworks.repository.juridico.processo;
import com.algaworks.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {
    Processo findByNumero(String numero);
}
