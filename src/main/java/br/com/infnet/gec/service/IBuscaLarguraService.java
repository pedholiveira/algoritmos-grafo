package br.com.infnet.gec.service;

import java.util.List;

import br.com.infnet.gec.dto.ResultadoBuscaLarguraDTO;
import br.com.infnet.gec.model.Grafo;

/**
 * Classe de serviço para o algoritmo de busca em largura.
 * 
 * @author Pedro Henrique
 */
public interface IBuscaLarguraService {
	
	/**
	 * Realiza a execução do algoritmo.
	 * 
	 * @param grafo
	 * @return
	 */
	public List<ResultadoBuscaLarguraDTO> executarAlgoritmo(Grafo grafo);
}
