package ListaDeAdjacencia;

	public class Aresta {  //  ARESTAS
		int vOrigem; 
		int vDestino;
		int valor;
		ListaDeAdjacencia listaAresta = new ListaDeAdjacencia();
		
		Aresta proximo; // ponteiro para indicar a próximo aresta da Lista
		
		//CONSTRUTORES DAS ARESTAS	
		public Aresta(int vOrigem, int vDestino) {
			this.vOrigem = vOrigem;
			this.vDestino = vDestino;
			this.proximo = null; 
		}
		
		public Aresta(int vOrigem, int vDestino, int valor) {
			this.vOrigem = vOrigem;
			this.vDestino = vDestino;
			this.valor = valor;
			this.proximo = null; 
		}
		
	}
