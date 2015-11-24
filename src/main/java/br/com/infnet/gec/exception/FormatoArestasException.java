package br.com.infnet.gec.exception;

/**
 * Exception criada para tratar erros de arestas inseridas com o formato
 * incorreto.
 * 
 * @author Pedro Henrique
 */
public class FormatoArestasException extends Exception {
	private static final long serialVersionUID = 7184787360747262075L;

	public FormatoArestasException() {
		super("Formato das arestas incorreto.");
	}
	
	public FormatoArestasException(String mensagem) {
		super(mensagem);
	}
}
