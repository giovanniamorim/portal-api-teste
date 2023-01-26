package com.algaworks.repository.juridico.processo;
import com.algaworks.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    Evento findByNome(String nome);

}
