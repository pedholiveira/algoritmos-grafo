package br.com.infnet.gec.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.FormParam;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.infnet.gec.dto.ResultadoBuscaProfundidadeDTO;
import br.com.infnet.gec.model.Grafo;
import br.com.infnet.gec.service.IBuscaProfundidadeService;
import br.com.infnet.gec.util.GrafoBuilder;

@Controller
@Path("/buscaProfundidade")
public class BuscaProfundidadeController {
	@Inject
	private Result result;
	@Inject
	private IBuscaProfundidadeService service;
	
	@Get("")
	public void form() {
	}
	
	@Post("/executar")
	public void executar(@FormParam("verticeRaiz") String verticeRaiz, 
							@FormParam("vertices") String vertices, 
							@FormParam("arestas") String arestas) {
		try {
			Grafo grafo = GrafoBuilder.criarGrafo(verticeRaiz, vertices, arestas);
			List<ResultadoBuscaProfundidadeDTO> resultados = service.executarAlgoritmo(grafo);
			
			result.include("resultados", resultados);
		} catch (Exception e) {
			result.include("erro", e.getMessage());
		}
			
		result.redirectTo(BuscaProfundidadeController.class).form();
	}
}
