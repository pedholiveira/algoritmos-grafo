package br.com.infnet.gec.exception;

/**
 * Exception criada para tratar exceções de regras de negócio.
 * 
 * @author Pedro Henrique
 */
public class RegraNegocioException extends Exception {

	private static final long serialVersionUID = 773287638647609911L;

	public RegraNegocioException(String message) {
		super(message);
	}
}
