package br.com.infnet.gec.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.infnet.gec.exception.GrafoFormatoException;
import br.com.infnet.gec.exception.RaizNaoEncontradaException;
import br.com.infnet.gec.model.Aresta;
import br.com.infnet.gec.model.Grafo;
import br.com.infnet.gec.model.Vertice;

/**
 * Classe responsável por criar um objeto do tipo {@link Grafo}.
 * 
 * @author Pedro Henrique
 */
public abstract class GrafoBuilder {
	private static final String GRAFO_FORMAT_REGEX = "(\\(([a-zA-Z]\\,[a-zA-Z])\\))+";
	private static final String ARESTA_FORMAT_REGEX = "([a-zA-Z]\\,[a-zA-Z])+";
	
	/**
	 * Cria um objeto do tipo {@link Grafo}.
	 * 
	 * @param verticeRaiz
	 * @param textoVertices
	 * @return
	 * @throws Exception 
	 */
	public static Grafo criarGrafo(String verticeRaiz, String textoVertices) throws Exception {
		Grafo grafo = new Grafo();
		
		if(Pattern.matches(GRAFO_FORMAT_REGEX, textoVertices)) {
			Set<Aresta> arestas = lerArestas(textoVertices);
			Set<Vertice> vertices = lerVertices(arestas);

			Vertice raiz = vertices.stream()
									.filter(v -> v.getNome().equals(verticeRaiz))
									.findAny()
									.orElseThrow(RaizNaoEncontradaException::new);

			grafo.setArestas(arestas);
			grafo.setVertices(vertices);
			grafo.setVerticeRaiz(raiz);
		} else {
			throw new GrafoFormatoException();
		}
		
		return grafo;
	}
	
	/**
	 * Retorna um Set com todas as arestas presentes no Grafo.
	 * 
	 * @param matcher
	 * @return
	 */
	private static Set<Aresta> lerArestas(String textoVertices) {
		Set<Aresta> arestas = new HashSet<Aresta>();
		Map<String, Vertice> vertices = new HashMap<String, Vertice>();

		Matcher matcher = Pattern.compile(ARESTA_FORMAT_REGEX).matcher(textoVertices);
		while(matcher.find()) {
			String[] nomesArestas = matcher.group(1).split(",");
			String nomeU = nomesArestas[0];
			String nomeV = nomesArestas[1];

			Vertice u = vertices.containsKey(nomeU) ? vertices.get(nomeU) : new Vertice(nomeU);
			Vertice v = vertices.containsKey(nomeV) ? vertices.get(nomeV) : new Vertice(nomeV);
			u.getMembros().add(v);

			vertices.putIfAbsent(u.getNome(), u);
			vertices.putIfAbsent(v.getNome(), v);
			
			arestas.add(new Aresta(u, v));
		}
		
		return arestas;
	}

	/**
	 * Retorna um Set com todos os vertices presentes no Grafo.
	 * 
	 * @param arestas
	 * @return
	 */
	private static Set<Vertice> lerVertices(Set<Aresta> arestas) {
		Set<Vertice> vertices = new HashSet<Vertice>();
		
		for (Aresta aresta : arestas) {
			vertices.add(aresta.getU());
			vertices.add(aresta.getV());
		}
		
		return vertices;
	}
}
