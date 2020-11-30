package com.hermanitto.socialbooks.services.excpetions;

public class AutorExistenteException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6293178844431240333L;

	public AutorExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public AutorExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
