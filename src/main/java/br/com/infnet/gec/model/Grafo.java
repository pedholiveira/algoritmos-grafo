package br.com.infnet.gec.model;

import java.util.Set;

/**
 * Representa um Grafo.
 * 
 * @author Pedro Henrique
 */
public class Grafo {
	private Vertice verticeRaiz;
	private Set<Aresta> arestas;
	private Set<Vertice> vertices;

	public Set<Aresta> getArestas() {
		return arestas;
	}

	public void setArestas(Set<Aresta> arestas) {
		this.arestas = arestas;
	}

	public Vertice getVerticeRaiz() {
		return verticeRaiz;
	}

	public void setVerticeRaiz(Vertice verticeRaiz) {
		this.verticeRaiz = verticeRaiz;
	}

	public Set<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(Set<Vertice> vertices) {
		this.vertices = vertices;
	}
}