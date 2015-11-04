package br.com.infnet.gec.exception;

/**
 * Exception criada para tratar erro ocorridos quando o vertice raiz n�o �
 * encontrado no grafo.
 * 
 * @author Pedro Henrique
 */
public class RaizNaoEncontradaException extends Exception {
	private static final long serialVersionUID = 8946836231572908203L;

	public RaizNaoEncontradaException() {
		super("V�rtice raiz n�o encontrado no grafo.");
	}
	
	public RaizNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
}
