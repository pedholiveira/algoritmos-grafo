package br.com.infnet.gec.service;

import java.util.List;

import br.com.infnet.gec.dto.ResultadoDijsktraDTO;
import br.com.infnet.gec.model.Grafo;

/**
 * Classe de serviço para o algoritmo de dijkstra.
 * 
 * @author Pedro Henrique
 */
public interface IAlgoritmoDijkstraService {
	
	/**
	 * Realiza a execução do algoritmo.
	 * 
	 * @param grafo
	 * @return
	 */
	public List<ResultadoDijsktraDTO> executarAlgoritmo(Grafo grafo);
}
