package br.com.infnet.gec.dto;

/**
 * Classe utilizada para a exibição do resultado do algoritmo de busca em
 * profundidade.
 * 
 * @author Pedro Henrique
 */
public class ResultadoBuscaProfundidadeDTO {
	private String vertice;
	private int preVisit;
	private int posVisit;

	public ResultadoBuscaProfundidadeDTO() {
	}

	public ResultadoBuscaProfundidadeDTO(String vertice) {
		this.vertice = vertice;
	}

	public String getVertice() {
		return vertice;
	}

	public void setVertice(String vertice) {
		this.vertice = vertice;
	}

	public int getPreVisit() {
		return preVisit;
	}

	public void setPreVisit(int preVisit) {
		this.preVisit = preVisit;
	}

	public int getPosVisit() {
		return posVisit;
	}

	public void setPosVisit(int posVisit) {
		this.posVisit = posVisit;
	}
}