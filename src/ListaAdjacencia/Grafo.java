package ListaAdjacencia;

import java.util.ArrayList;

public class Grafo {

	private ArrayList<Vertice> conjuntoV = new ArrayList<>();
	private ArrayList<Aresta> conjuntoE = new ArrayList<>();
	
	public String toString() {
		
		String listaE = "{";
		
		for(Aresta a: conjuntoE) {
			listaE += a.toString() + " ";
		}
		return listaE + "}";
	}

	public ArrayList<Vertice> getConjuntoV() {
		return conjuntoV;
	}

	public void setConjuntoV(ArrayList<Vertice> conjuntoV) {
		this.conjuntoV = conjuntoV;
	}

	public ArrayList<Aresta> getConjuntoE() {
		return conjuntoE;
	}

	public void setConjuntoE(ArrayList<Aresta> conjuntoE) {
		this.conjuntoE = conjuntoE;
	}
	
}
