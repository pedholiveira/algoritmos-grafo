package br.com.infnet.gec.dto;

/**
 * DTO utilizado para a exibição do resultado da execução do algoritmo de Dijkstra
 * 
 * @author Pedro Henrique
 */
public class ResultadoDijsktraDTO {
	private String vertice;
	private int distancia;

	public ResultadoDijsktraDTO() {
	}

	public ResultadoDijsktraDTO(String vertice, int distancia) {
		this.vertice = vertice;
		this.distancia = distancia;
	}

	public String getVertice() {
		return vertice;
	}

	public void setVertice(String vertice) {
		this.vertice = vertice;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
}