package br.com.infnet.gec.util;

/**
 * Interface utilizada para manter mensagens amigáveis do sistema.
 * 
 * @author Pedro Henrique
 */
public interface Messages {
	public static final String FORMATO_ARESTAS_INCORRETO = "O formato das arestas informado está incorreto.";
	public static final String FORMATO_VERTICES_INCORRETO = "O formato dos vértices informado está incorreto.";

	public static final String NUM_ARESTAS_EXCEDIDO = "O número de arestas não pode ser maior do que 20.";
	public static final String NUM_VERTICES_EXCEDIDO = "O número de vértices não pode ser maior do que 10.";
	
	public static final String VERTICE_RAIZ_NAO_ENCONTRADO = "O vértice raiz informado não foi encontrado no grafo.";
	
	public static final String PESO_ARESTA_NEGATIVO = "O algoritmo de Dijkstra não suporta arestas com peso negativo.";
}
