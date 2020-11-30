package com.hermanitto.socialbooks.services.excpetions;

public class AutorNaoEncontradoException extends RuntimeException {
	



	/**
	 * 
	 */
	private static final long serialVersionUID = -6414294376493770442L;

	public AutorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public AutorNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
