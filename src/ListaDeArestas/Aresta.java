package ListaDeArestas;

public class Aresta {  //  ARESTAS
		String vOrigem; 
		String vDestino;
		int valor;
		
		Aresta proximo; // ponteiro para indicar a próximo aresta da Lista
		
	//CONSTRUTORES DAS ARESTAS	
	public Aresta(String vOrigem, String vDestino) {
		this.vOrigem = vOrigem;
		this.vDestino = vDestino;
		this.proximo = null; 
	}
		
	public Aresta(String vOrigem, String vDestino, int valor) {
		this.vOrigem = vOrigem;
		this.vDestino = vDestino;
		this.valor = valor;
		this.proximo = null; 
	}
		
}
