package br.com.infnet.gec.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;

import br.com.infnet.gec.dto.ResultadoDijsktraDTO;
import br.com.infnet.gec.model.Grafo;
import br.com.infnet.gec.model.Vertice;
import br.com.infnet.gec.util.GrafoUtils;

@RequestScoped
public class AlgoritmoDijkstraService implements IAlgoritmoDijkstraService {

	@Override
	public List<ResultadoDijsktraDTO> executarAlgoritmo(Grafo grafo) {
		List<ResultadoDijsktraDTO> resultados = new ArrayList<ResultadoDijsktraDTO>();
		Map<Vertice, Integer> mapaInteracoes = inicializarMapaInteracoes(grafo);
		
		do {
			Vertice verticeVerificador = obterVerticeVerificador(mapaInteracoes);
			
			int distancia = mapaInteracoes.get(verticeVerificador);
			List<Vertice> membros = GrafoUtils.obterVerticesOrdenados(verticeVerificador.getMembros()); 

			for (Vertice membro : membros) {
				int distanciaMembro = distancia + 1;
				
				if(!mapaInteracoes.containsKey(membro)) {
					continue;
				}
				if(mapaInteracoes.get(membro) == null || mapaInteracoes.get(membro) > distanciaMembro) {
					mapaInteracoes.replace(membro, distanciaMembro);
				}
			}

			mapaInteracoes.remove(verticeVerificador);
			resultados.add(new ResultadoDijsktraDTO(verticeVerificador.getNome(), distancia));
		} while(!mapaInteracoes.isEmpty());
		
		return resultados;
	}
	
	/**
	 * Obtém o próximo vértice verificador da interação corrente. 
	 * 
	 * @param interacoesDijkstra
	 * @return
	 */
	private Vertice obterVerticeVerificador(Map<Vertice, Integer> interacoesDijkstra) {
		List<Vertice> chaves = GrafoUtils.obterVerticesOrdenados(interacoesDijkstra.keySet());
		
		Vertice verticeVerificador = chaves.get(0);
		for (Vertice chave : chaves) {
			if(interacoesDijkstra.get(chave) != null &&
					interacoesDijkstra.get(chave) < interacoesDijkstra.get(verticeVerificador)) {
				verticeVerificador = chave;
			}
		}
		
		return verticeVerificador;
	}

	/**
	 * Inicializa o mapa das interações do algoritmo de Dijkstra.
	 * 
	 * O mapa é inicializado com o vértice raiz tendo valor 0 e 
	 * todos os outros com valor nulo.
	 * 
	 * @param grafo
	 * @return
	 */
	private Map<Vertice, Integer> inicializarMapaInteracoes(Grafo grafo) {
		Map<Vertice, Integer> interacoesDijkstra = new HashMap<Vertice, Integer>();
		
		for (Vertice vertice : grafo.getVertices()) {
			if(vertice.equals(grafo.getVerticeRaiz())) {
				interacoesDijkstra.put(vertice, 0);
				continue;
			}
			interacoesDijkstra.put(vertice, null);
		}
		
		return interacoesDijkstra;
	}
}
