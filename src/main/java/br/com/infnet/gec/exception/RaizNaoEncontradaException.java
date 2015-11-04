package br.com.infnet.gec.exception;

/**
 * Exception criada para tratar erro ocorridos quando o vertice raiz não é
 * encontrado no grafo.
 * 
 * @author Pedro Henrique
 */
public class RaizNaoEncontradaException extends Exception {
	private static final long serialVersionUID = 8946836231572908203L;

	public RaizNaoEncontradaException() {
		super("Vértice raiz não encontrado no grafo.");
	}
	
	public RaizNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
}
