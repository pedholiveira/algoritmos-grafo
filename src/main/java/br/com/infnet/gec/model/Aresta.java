package br.com.infnet.gec.model;

/**
 * Representa uma aresta de um grafo.
 * 
 * @author Pedro Henrique
 */
public class Aresta {
	private Vertice u;
	private Vertice v;

	public Aresta() {
	}
	
	public Aresta(Vertice u, Vertice v) {
		this.u = u;
		this.v = v;
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
	
	@Override
	public String toString() {
		return new StringBuilder("(").append(u).append(",").append(v).append(")").toString();
	}
}
