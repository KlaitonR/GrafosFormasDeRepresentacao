package ListaDeArestas;

public class ListaDeArestas {

	private Elemento primeiro, atual, ultimo; //Elementos da lista
	
	public ListaDeArestas() {
		primeiro = atual = ultimo = null;  
	} 

		// Retorna um booleano indicando se a lista est� vazia 
	public boolean estaVazio() {
		return primeiro == null; 
	}
	
	public void insereArestaNaoOrientada(int vOrigem, int vDestino) {  //Inserir uma aresta em um GRAFO N�O ORIENTADO
			
			Elemento aresta = new Elemento(vOrigem, vDestino);
			
			if (estaVazio()) { //verifica se est� vazia
				primeiro = aresta; // Se estiver vazia, coloca a aresta instanciada como a primeira, ultima e atual da lista
				ultimo = aresta;
				atual = aresta; 
				}else { // Se n�o estiver vazia, indica que a proxima aresta da lista ser� a rec�m instanciada, e posteriormente a aloca como �ltima
					ultimo.proximo = aresta; 
					ultimo = aresta; 
				}
			}
		
	
		public void insereArestaOrientada(int vOrigem, int vDestino) { //Inserir uma aresta em um GRAFO ORIENTADO
			
			Elemento aresta = new Elemento(vOrigem, vDestino);
			
			if (estaVazio()) {
				primeiro = aresta;
				ultimo = aresta;
				atual = aresta; 
			}else {
				//if(buscaElemento(vDestino, vOrigem) == -1) {
					ultimo.proximo = aresta; 
					ultimo = aresta; 
				//}else {
				//	JOptionPane.showMessageDialog(null, aresta.vOrigem + " n�o pode ser adjacente � " + aresta.vDestino);
				//}	
			}
		}
		
		public void insereArestaValorada(int vOrigem, int vDestino, int valor) {  //Inserir uma aresta em um GRAFO VALORADO
			
			Elemento aresta = new Elemento(vOrigem, vDestino, valor);
			
			if (estaVazio()) {
				primeiro = aresta;
				ultimo = aresta;
				atual = aresta; 
				}else {
					ultimo.proximo = aresta; 
					ultimo = aresta; 
				}
			}
		
public void insereArestaMultiarestas(int vOrigem, int vDestino, int nArestas) {  //Inserir uma aresta em um GRAFO MULTI ARESTAS
			
			Elemento aresta = new Elemento(vOrigem, vDestino, nArestas);
			
			if (estaVazio()) {
				primeiro = aresta;
				ultimo = aresta;
				atual = aresta; 
				}else {
					ultimo.proximo = aresta; 
					ultimo = aresta; 
				}
			}
		
		public void moveParaPosicao(int pos) { //mover para a po��o indicado pelo par�metro "pos"
			
			atual = primeiro; // A aresta atual ser� a primeira da lista
			
			for(int i=0; i<pos; i++) { //percorre a lista at� a posi��o indicada
				atual= atual.proximo;
			}
		}
		
		public int buscaElemento(int vOrigem, int vDestino) { //buscar a aresta (conjunto) indicado
			
			int cont = 0; 
			atual = primeiro;
			//Enquanto o valor n�o for nulo (n�o chegar ao fim da lista, onde o ultima aresta.proximo aponta para null)
			//e o vertice origem e destino n�o forem achados, continuar� a percorer a lista
			while(atual!= null && atual.vOrigem != vOrigem && atual.vDestino != atual.vDestino) {  
				atual = atual.proximo; 
				cont ++; //contador
			}
			
			if (atual != null) //se a aresta for achada, retorna o valor do contador
				return cont; 
			
			return -1; // caso retorne -1, significa que a arresta n�o existe no conjunto E
		}
		
	
	public String RepresentacaoListaDeArestas() {
		
		String representacao = "E = { "; //Conjunto E
		primeiro = atual;
		
		while(atual!= null) { //percorrer a lista
			representacao+="("+atual.vOrigem + "," + atual.vDestino + ") "; //concatenar os valores
			atual = atual.proximo;  
		}
		
		return representacao + " }"; //retornar a representa��o
	}
	
public String RepresentacaoValoradaEmultigrafos() {
		
		String representacao = "E = { ";
		primeiro = atual;
		
		while(atual!= null) {
			representacao+="("+atual.vOrigem + "," + atual.vDestino + "," + atual.valor + ") ";
			atual = atual.proximo;  
		}
		
		return representacao + " }";
	}

}



