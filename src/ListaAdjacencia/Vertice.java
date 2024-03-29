package ListaAdjacencia;

import java.util.ArrayList;

public class Vertice {

	private int valor;
	
	private ArrayList<Vertice> ListaDeAdjacencia = new ArrayList<>();
	
	public String toString () { //ToString para exibir a lista de adjac�ncia
		
		String res = "(";
		
		for(Vertice v: ListaDeAdjacencia) {
			res+= v.getValor() + ", ";
		}
		
		return res;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public ArrayList<Vertice> getListaDeAdjacencia() {
		return ListaDeAdjacencia;
	}

	public void setListaDeAdjacencia(ArrayList<Vertice> listaDeAdjacencia) {
		ListaDeAdjacencia = listaDeAdjacencia;
	}

}
