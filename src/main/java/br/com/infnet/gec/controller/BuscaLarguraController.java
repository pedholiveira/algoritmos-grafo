package br.com.infnet.gec.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.FormParam;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.infnet.gec.dto.ResultadoBuscaLarguraDTO;
import br.com.infnet.gec.model.Grafo;
import br.com.infnet.gec.service.IBuscaLarguraService;
import br.com.infnet.gec.util.GrafoBuilder;

@Controller
@Path("/buscaLargura")
public class BuscaLarguraController {
	@Inject
	private Result result;
	@Inject
	private IBuscaLarguraService service;
	
	@Get("/form")
	public void form() {
		result.include("mensagem", "Olá, mundo!");
	}
	
	@Post("/executar")
	public void executar(@FormParam("verticeRaiz") String verticeRaiz, @FormParam("verticeRaiz") String vertices) {
		try {
			Grafo grafo = GrafoBuilder.criarGrafo(verticeRaiz, vertices);
			List<ResultadoBuscaLarguraDTO> resultados = service.executarAlgoritmo(grafo);
			
			result.include("resultados", resultados);
		} catch (Exception e) {
			result.include("erro", e.getMessage());
		}

		result.redirectTo(BuscaLarguraController.class).form();
	}
}
