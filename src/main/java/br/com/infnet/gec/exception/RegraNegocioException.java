package br.com.infnet.gec.exception;

/**
 * Exception criada para tratar exce��es de regras de neg�cio.
 * 
 * @author Pedro Henrique
 */
public class RegraNegocioException extends Exception {

	private static final long serialVersionUID = 773287638647609911L;

	public RegraNegocioException(String message) {
		super(message);
	}
}
