package br.com.infnet.gec.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.enterprise.context.RequestScoped;

import br.com.infnet.gec.dto.ResultadoBuscaLarguraDTO;
import br.com.infnet.gec.model.Grafo;
import br.com.infnet.gec.model.Vertice;

@RequestScoped
public class BuscaLarguraService implements IBuscaLarguraService {

	@Override
	public List<ResultadoBuscaLarguraDTO> executarAlgoritmo(Grafo grafo) {
		Queue<Vertice> fila = new LinkedList<Vertice>();
		fila.add(grafo.getVerticeRaiz());

		return calcularSaltos(fila);
	}

	/**
	 * Faz a contagem do número de saltos que o nó raiz tem para todos os outros
	 * nós do grafo.
	 * 
	 * @param fila
	 * @return
	 */
	private List<ResultadoBuscaLarguraDTO> calcularSaltos(Queue<Vertice> fila) {
		Map<String, Integer> resultadosMap = new HashMap<String, Integer>();
		List<ResultadoBuscaLarguraDTO> resultados = new ArrayList<ResultadoBuscaLarguraDTO>();

		while (fila.size() > 0) {
			Vertice v = fila.remove();

			if (v.getMembros().isEmpty())
				continue;

			int numSaltos = v.getNumSaltos() + 1;
			for (Vertice membro : v.getMembros()) {
				String nome = membro.getNome();
				membro.setNumSaltos(numSaltos);

				if (resultadosMap.containsKey(nome) && resultadosMap.get(nome) > numSaltos) {
					resultadosMap.remove(nome);
				} 
				
				resultadosMap.put(nome, numSaltos);
				fila.add(membro);
			}
		}

		resultadosMap.forEach((nome, numSaltos) -> resultados.add(new ResultadoBuscaLarguraDTO(nome, numSaltos)));
		return resultados;
	}
}
