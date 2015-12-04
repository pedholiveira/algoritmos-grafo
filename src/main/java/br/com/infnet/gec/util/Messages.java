package br.com.infnet.gec.util;

/**
 * Interface utilizada para manter mensagens amig�veis do sistema.
 * 
 * @author Pedro Henrique
 */
public interface Messages {
	public static final String FORMATO_ARESTAS_INCORRETO = "O formato das arestas informado est� incorreto.";
	public static final String FORMATO_VERTICES_INCORRETO = "O formato dos v�rtices informado est� incorreto.";

	public static final String NUM_ARESTAS_EXCEDIDO = "O n�mero de arestas n�o pode ser maior do que 20.";
	public static final String NUM_VERTICES_EXCEDIDO = "O n�mero de v�rtices n�o pode ser maior do que 10.";
	
	public static final String VERTICE_RAIZ_NAO_ENCONTRADO = "O v�rtice raiz informado n�o foi encontrado no grafo.";
	
	public static final String PESO_ARESTA_NEGATIVO = "O algoritmo de Dijkstra n�o suporta arestas com peso negativo.";
}
