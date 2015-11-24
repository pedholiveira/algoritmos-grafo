package br.com.infnet.gec.service;

import java.util.List;

import br.com.infnet.gec.dto.ResultadoBuscaProfundidadeDTO;
import br.com.infnet.gec.model.Grafo;

/**
 * Classe de servi�o para o algoritmo de busca em profundidade.
 * 
 * @author Pedro Henrique
 */
public interface IBuscaProfundidadeService {
	
	/**
	 * Realiza a execu��o do algoritmo.
	 * 
	 * @param grafo
	 * @return
	 */
	public List<ResultadoBuscaProfundidadeDTO> executarAlgoritmo(Grafo grafo);
}
