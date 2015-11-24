package br.com.infnet.gec.dto;

/**
 * Classe utilizada para a exibição do resultado do algoritmo de busca em
 * largura.
 * 
 * @author Pedro Henrique
 */
public class ResultadoBuscaProfundidadeDTO {
	private String vertice;
	private int numSaltos;

	public ResultadoBuscaProfundidadeDTO() {
	}
	
	public ResultadoBuscaProfundidadeDTO(String vertice, int numSaltos) {
		this.vertice = vertice;
		this.numSaltos = numSaltos;
	}

	public String getVertice() {
		return vertice;
	}

	public void setVertice(String vertice) {
		this.vertice = vertice;
	}

	public int getNumSaltos() {
		return numSaltos;
	}

	public void setNumSaltos(int numSaltos) {
		this.numSaltos = numSaltos;
	}
}