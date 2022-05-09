package br.com.estudandoemcasa.recurso;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudandoemcasa.entidades.Worker;
import br.com.estudandoemcasa.excecao.WorkerException;
import br.com.estudandoemcasa.repositorio.WorkerRepositorio;

@RestController
@RequestMapping(value = "/workers")
public class WorkerRecurso {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerRecurso.class);
	
	@Autowired
	private Environment environment;

	@Autowired
	private WorkerRepositorio workerRepositorio;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> workers = workerRepositorio.findAll();
		return ResponseEntity.ok(workers);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		
		
		logger.info("PORT = " + environment.getProperty("local.server.port"));
		
		Worker worker;
		try {
			worker = workerRepositorio.findById(id).get();
			System.out.println(worker);
		} catch (NoSuchElementException e) { 
			throw new WorkerException(e.getMessage());
		}
		
		return ResponseEntity.ok(worker);
	}
}
