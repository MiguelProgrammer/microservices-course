package br.com.estudandoemcasa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.estudandoemcasa.entidades.Worker;

public interface WorkerRepositorio extends JpaRepository<Worker, Long>{

}
