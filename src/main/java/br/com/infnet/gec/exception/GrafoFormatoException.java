package br.com.infnet.gec.exception;

/**
 * Exception criada para tratar erros de grafos inseridos com o formato
 * incorreto.
 * 
 * @author Pedro Henrique
 */
public class GrafoFormatoException extends Exception {
	private static final long serialVersionUID = 7184787360747262075L;

	public GrafoFormatoException() {
		super("Formato das arestas inválido.");
	}
	
	public GrafoFormatoException(String mensagem) {
		super(mensagem);
	}
}
