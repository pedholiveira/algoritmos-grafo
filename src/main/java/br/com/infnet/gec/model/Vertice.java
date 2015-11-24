package br.com.infnet.gec.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um vertice de um grafo.
 * 
 * @author Pedro Henrique
 */
public class Vertice {
	private String nome;
	private List<Vertice> membros = new ArrayList<Vertice>();
	private boolean visitado;
	private int numSaltos;
	
	public Vertice() {
	}
	
	public Vertice(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Vertice> getMembros() {
		return membros;
	}
	
	public int getNumSaltos() {
		return numSaltos;
	}
	
	public void setNumSaltos(int numSaltos) {
		this.numSaltos = numSaltos;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}