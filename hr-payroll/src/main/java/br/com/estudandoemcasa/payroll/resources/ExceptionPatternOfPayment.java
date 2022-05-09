package br.com.estudandoemcasa.payroll.resources;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.estudandoemcasa.payroll.exception.PayMentException;
import br.com.estudandoemcasa.payroll.resources.exceptions.StandardError;

@ControllerAdvice
public class ExceptionPatternOfPayment {  
    
	@ExceptionHandler(PayMentException.class)
	public ResponseEntity<StandardError> ExcecaoPadraoDeRecurso(PayMentException we, HttpServletRequest requisicao) { 
		StandardError err = new StandardError();
		
		err.setTimeStamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Busca inválida!");
		err.setMessage("Colaborador não existe!");
		err.setPath(requisicao.getRequestURI());   
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	
}
