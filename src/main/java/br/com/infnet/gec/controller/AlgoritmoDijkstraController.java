package br.com.infnet.gec.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.FormParam;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.infnet.gec.dto.ResultadoDijsktraDTO;
import br.com.infnet.gec.model.Grafo;
import br.com.infnet.gec.service.IAlgoritmoDijkstraService;
import br.com.infnet.gec.util.GrafoUtils;

@Controller
@Path("/dijkstra")
public class AlgoritmoDijkstraController {
	@Inject
	private Result result;
	@Inject
	private IAlgoritmoDijkstraService service;
	
	@Get("")
	public void form() {
	}
	
	@Post("/executar")
	public void executar(@FormParam("verticeRaiz") String verticeRaiz, 
							@FormParam("vertices") String vertices, 
							@FormParam("arestas") String arestas) {
		try {
			Grafo grafo = GrafoUtils.criarGrafo(verticeRaiz, vertices, arestas, true);
			List<ResultadoDijsktraDTO> resultados = service.executarAlgoritmo(grafo);
			
			result.include("resultados", resultados);
		} catch (Exception e) {
			result.include("erro", e.getMessage());
		}

		result.redirectTo(AlgoritmoDijkstraController.class).form();
	}
}
