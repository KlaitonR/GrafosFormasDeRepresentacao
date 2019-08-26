package ListaDeArestas;

	public class Elemento {  //  ARESTAS
		int vOrigem; 
		int vDestino;
		int valor;
		
		Elemento proximo; // ponteiro para indicar a próximo aresta da Lista
		
		//CONSTRUTORES DAS ARESTAS	
		public Elemento(int vOrigem, int vDestino) {
			this.vOrigem = vOrigem;
			this.vDestino = vDestino;
			this.proximo = null; 
		}
		
		public Elemento(int vOrigem, int vDestino, int valor) {
			this.vOrigem = vOrigem;
			this.vDestino = vDestino;
			this.valor = valor;
			this.proximo = null; 
		}
		
	}
