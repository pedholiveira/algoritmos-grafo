package br.com.infnet.gec.util;

import br.com.infnet.gec.model.Grafo;

public class Main {

	public static void main(String[] args) throws Exception {
		String vertices = "(A,B)(A,C)(A,D)(B,E)(E,F)(C,F)";
		Grafo grafo = GrafoBuilder.criarGrafo("A", vertices);
	}

}
