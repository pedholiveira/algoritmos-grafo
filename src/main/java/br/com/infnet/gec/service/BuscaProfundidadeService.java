package br.com.infnet.gec.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import br.com.infnet.gec.dto.ResultadoBuscaProfundidadeDTO;
import br.com.infnet.gec.model.Grafo;
import br.com.infnet.gec.model.Vertice;

@RequestScoped
public class BuscaProfundidadeService implements IBuscaProfundidadeService {

	private static int indiceVisit; 
	private static List<ResultadoBuscaProfundidadeDTO> resultados;
	
	@PostConstruct
	public void inicializar() {
		indiceVisit = 0;
		resultados = new ArrayList<ResultadoBuscaProfundidadeDTO>();
	}
	
	@Override
	public List<ResultadoBuscaProfundidadeDTO> executarAlgoritmo(Grafo grafo) {
		Set<Vertice> vertices = grafo.getVertices();
		Vertice raiz = grafo.getVerticeRaiz();
		
		while(true) {
			explorarVertice(raiz);
			
			Vertice naoVisitado = vertices.stream()
											.sorted((v1, v2) -> v1.getNome().compareTo(v2.getNome()))
											.filter(v -> !v.isVisitado())
											.findFirst()
											.orElse(null);
			if(naoVisitado != null) {
				raiz = naoVisitado;
				continue;
			}

			break;
		}
		
		Collections.sort(resultados, (ResultadoBuscaProfundidadeDTO r1, ResultadoBuscaProfundidadeDTO r2) -> r1.getVertice().compareTo(r2.getVertice()));
		return resultados;
	}

	/**
	 * Realiza a exploração dos membros de um vertice para a execução do algoritmo.
	 * 
	 * @param vertice
	 */
	private void explorarVertice(Vertice vertice) {
		if(vertice.isVisitado()) {
			return;
		}
		vertice.setVisitado(true);
		
		ResultadoBuscaProfundidadeDTO resultado = new ResultadoBuscaProfundidadeDTO(vertice.getNome());
		
		List<Vertice> membros = vertice.getMembros();
		Collections.sort(membros, (Vertice v1, Vertice v2) -> v1.getNome().compareTo(v2.getNome()));
		
		resultado.setPreVisit(++indiceVisit);
		for (Vertice membro : membros) {
			explorarVertice(membro);
		}
		resultado.setPosVisit(++indiceVisit);
		
		resultados.add(resultado);
	}
	
}
