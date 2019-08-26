package ListaAdjacencia;

public class Aresta {
	
	private Vertice vOrigem;
	private Vertice vDestino;
	private int valor;

	public Aresta(Vertice vOrigem, Vertice vDestino) {
		this.vOrigem = vOrigem;
		this.vDestino = vDestino;
	}
	
	public String toString() {
		return "("+vOrigem+","+vDestino+")" ;
	}

	public Vertice getvOrigem() {
		return vOrigem;
	}

	public void setvOrigem(Vertice vOrigem) {
		this.vOrigem = vOrigem;
	}

	public Vertice getvDestino() {
		return vDestino;
	}

	public void setvDestino(Vertice vDestino) {
		this.vDestino = vDestino;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	

}
