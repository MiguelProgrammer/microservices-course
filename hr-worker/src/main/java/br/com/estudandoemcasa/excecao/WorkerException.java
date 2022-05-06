package br.com.estudandoemcasa.excecao;

public class WorkerException extends RuntimeException { 
	private static final long serialVersionUID = 1L; 
    
	public WorkerException(String mensagem) { 
		super(mensagem);
	}

	
}
