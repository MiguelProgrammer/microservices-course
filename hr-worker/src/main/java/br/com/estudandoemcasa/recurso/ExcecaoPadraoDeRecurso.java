package br.com.estudandoemcasa.recurso;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.estudandoemcasa.excecao.WorkerException;
import br.com.estudandoemcasa.recurso.excecao.StandardError;

@ControllerAdvice
public class ExcecaoPadraoDeRecurso {  
    
	@ExceptionHandler(WorkerException.class)
	public ResponseEntity<StandardError> ExcecaoPadraoDeRecurso(WorkerException we, HttpServletRequest requisicao) { 
		StandardError err = new StandardError();
		
		err.setTimeStamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Busca inválida!");
		err.setMessage("Colaborador não existe!");
		err.setPath(requisicao.getRequestURI());  
		
		System.err.print(err.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	
}
