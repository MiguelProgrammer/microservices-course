package br.com.estudandoemcasa.payroll.exception;

public class PayMentException extends RuntimeException { 
	private static final long serialVersionUID = 1L; 
    
	public PayMentException(String mensagem) { 
		super(mensagem);
	}

	
}
