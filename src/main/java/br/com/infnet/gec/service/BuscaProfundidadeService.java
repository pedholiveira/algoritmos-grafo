package br.com.infnet.gec.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.com.infnet.gec.dto.ResultadoBuscaProfundidadeDTO;
import br.com.infnet.gec.model.Grafo;

@RequestScoped
public class BuscaProfundidadeService implements IBuscaProfundidadeService {

	@Override
	public List<ResultadoBuscaProfundidadeDTO> executarAlgoritmo(Grafo grafo) {
		return null;
	}
}
