package br.com.infnet.gec.exception;

/**
 * Exception criada para tratar erros de v�rtices inseridos com o formato
 * incorreto.
 * 
 * @author Pedro Henrique
 */
public class FormatoVerticesException extends Exception {
	private static final long serialVersionUID = 7184787360747262075L;

	public FormatoVerticesException() {
		super("Formato dos v�rtices incorreto.");
	}
	
	public FormatoVerticesException(String mensagem) {
		super(mensagem);
	}
}
