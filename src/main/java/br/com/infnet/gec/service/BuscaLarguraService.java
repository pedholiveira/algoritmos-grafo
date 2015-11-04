package br.com.infnet.gec.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
	
	private List<ResultadoBuscaLarguraDTO> calcularSaltos(Queue<Vertice> fila) {
		List<ResultadoBuscaLarguraDTO> resultados = new ArrayList<ResultadoBuscaLarguraDTO>();
		
		while(fila.size() > 0) {
			Vertice v = fila.remove();
			
			if(v.getMembros().isEmpty()) 
				continue;
			
			int numSaltos = v.getNumSaltos() + 1;
			for (Vertice membro : v.getMembros()) {
				resultados.add(new ResultadoBuscaLarguraDTO(membro.getNome(), numSaltos));
				fila.add(membro);
			}
		}
		
		return resultados;
	}
}
