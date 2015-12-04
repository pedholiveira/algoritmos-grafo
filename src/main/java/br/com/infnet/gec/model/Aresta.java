package br.com.infnet.gec.model;

/**
 * Representa uma aresta de um grafo.
 * 
 * @author Pedro Henrique
 */
public class Aresta {
	private Vertice u;
	private Vertice v;
	private int peso;

	public Aresta() {
	}
	
	public Aresta(Vertice u, Vertice v) {
		this.u = u;
		this.v = v;
	}

	public Aresta(Vertice u, Vertice v, int peso) {
		this.u = u;
		this.v = v;
		this.peso = peso;
	}

	public Vertice getU() {
		return u;
	}

	public void setU(Vertice u) {
		this.u = u;
	}

	public Vertice getV() {
		return v;
	}

	public void setV(Vertice v) {
		this.v = v;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return new StringBuilder("(").append(u).append(",").append(v).append(")").toString();
	}
}
