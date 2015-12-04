package br.com.infnet.gec.util;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import br.com.infnet.gec.exception.FormatoArestasException;
import br.com.infnet.gec.exception.FormatoVerticesException;
import br.com.infnet.gec.exception.RaizNaoEncontradaException;
import br.com.infnet.gec.model.Aresta;
import br.com.infnet.gec.model.Grafo;
import br.com.infnet.gec.model.Vertice;

/**
 * Classe utilitária responsável por manipulações no objeto {@link Grafo}.
 * 
 * @author Pedro Henrique
 */
public abstract class GrafoUtils {
	private static final String VERTICES_FORMAT_REGEX = "([a-zA-Z](\\, )?)+";
	private static final String ARESTAS_FORMAT_REGEX = "(\\[([a-zA-Z]\\,[a-zA-Z])\\])+";
	private static final String EXTRACT_ARESTAS_REGEX = "\\[([a-zA-Z]\\,[a-zA-Z])\\]";
	
	/**
	 * Cria um objeto do tipo {@link Grafo}.
	 * 
	 * @param verticeRaiz
	 * @param textoVertices
	 * @return
	 * @throws Exception 
	 */
	public static Grafo criarGrafo(String verticeRaiz, String textoVertices, String arestas) throws Exception {
		Grafo grafo = new Grafo();
		carregarVertices(grafo, textoVertices);
		carregarArestas(grafo, arestas);

		Vertice raiz = grafo.getVertices()
							.stream()
							.filter(v -> v.getNome().equals(verticeRaiz))
							.findAny()
							.orElseThrow(RaizNaoEncontradaException::new);
		
		grafo.setVerticeRaiz(raiz);
		
		return grafo;
	}
	
	/**
	 * Recebe um {@link List} de objetos do tipo {@link Vertice} e 
	 * retorna um novo {@link List} ordenado deles.
	 * 
	 * @param vertices
	 * @return
	 */
	public static List<Vertice> obterVerticesOrdenados(List<Vertice> vertices) {
		return vertices.stream()
						.sorted((v1, v2) -> v1.getNome().compareTo(v2.getNome()))
						.collect(Collectors.toList());
	}
	
	/**
	 * Recebe um {@link Set} de objetos do tipo {@link Vertice} e 
	 * retorna um {@link List} ordenado deles.
	 * 
	 * @param vertices
	 * @return
	 */
	public static List<Vertice> obterVerticesOrdenados(Set<Vertice> vertices) {
		return vertices.stream()
						.sorted((v1, v2) -> v1.getNome().compareTo(v2.getNome()))
						.collect(Collectors.toList());
	}
	
	/**
	 * Recebe um {@link Grafo} e retorna uma {@link List} 
	 * com os seus vertices ordenados.
	 * 
	 * @param grafo
	 * @return
	 */
	public static List<Vertice> obterVerticesOrdenados(Grafo grafo) {
		return obterVerticesOrdenados(grafo.getVertices());
	}
	
	/**
	 * Carrega um Set das arestas no Grafo.
	 * 
	 * @param grafo
	 * @param arestas
	 * @throws FormatoArestasException 
	 */
	private static void carregarArestas(Grafo grafo, String textArestas) throws FormatoArestasException {
		if(!Pattern.matches(ARESTAS_FORMAT_REGEX, textArestas))
			throw new FormatoArestasException(); 
		
		Matcher matcher = Pattern.compile(EXTRACT_ARESTAS_REGEX).matcher(textArestas);

		Set<Aresta> arestas = new HashSet<Aresta>();
		Map<String, Vertice> vertices = grafo.getVertices()
												.stream()
												.collect(Collectors.toMap(Vertice::getNome, Function.identity()));
		
		while(matcher.find()) {
			String[] nomesArestas = matcher.group(1).split(",");
			String nomeU = nomesArestas[0];
			String nomeV = nomesArestas[1];
			
			Vertice u = vertices.get(nomeU);
			Vertice v = vertices.get(nomeV);
			u.getMembros().add(v);
			
			vertices.putIfAbsent(u.getNome(), u);
			vertices.putIfAbsent(v.getNome(), v);
			
			arestas.add(new Aresta(u, v));
		}
		
		grafo.setArestas(arestas);
	}

	/**
	 * Carrega um Set de vértices no objeto do grafo.
	 * 
	 * @param grafo
	 * @param textoVertices
	 * @throws FormatoVerticesException 
	 */
	private static void carregarVertices(Grafo grafo, String textoVertices) throws FormatoVerticesException {
		if(!Pattern.matches(VERTICES_FORMAT_REGEX, textoVertices))
			throw new FormatoVerticesException();
		
		Set<Vertice> verticesSet = new HashSet<Vertice>();
		String[] vertices = textoVertices.split(", ");
		
		for (String vertice : vertices) {
			verticesSet.add(new Vertice(vertice));
		}
		
		grafo.setVertices(verticesSet);
	}
}
