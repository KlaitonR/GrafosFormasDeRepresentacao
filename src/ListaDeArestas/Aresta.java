package ListaDeArestas;

	public class Aresta {  //  ARESTAS
		int vOrigem; 
		int vDestino;
		int valor;
		
		Aresta proximo; // ponteiro para indicar a pr�ximo aresta da Lista
		
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
