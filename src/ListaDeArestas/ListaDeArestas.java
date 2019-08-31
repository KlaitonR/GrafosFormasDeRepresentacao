package ListaDeArestas;

public class ListaDeArestas {

	private Aresta primeiro, atual, ultimo; //Elementos da lista
	private Vertice primeiroV, ultimoV;
	
	public ListaDeArestas() {
		primeiro = atual = ultimo = null; 
		primeiroV = ultimoV = null;
	} 

		// Retorna um booleano indicando se a lista est� vazia 
	public boolean estaVazio() {
		return primeiro == null; 
	}
	
	public boolean estaVazioV() {
		return primeiroV == null; 
	}
	
	public void insereVertice(int v) {  //Inserir uma aresta em um GRAFO N�O ORIENTADO
		
		Vertice vertice = new Vertice(v);
		
		if (estaVazioV()) { //verifica se est� vazia
			primeiroV = vertice; // Se estiver vazia, coloca a aresta instanciada como a primeira, ultima e atual da lista
			ultimoV = vertice;
			}else { // Se n�o estiver vazia, indica que a proxima aresta da lista ser� a rec�m instanciada, e posteriormente a aloca como �ltima
				ultimoV.proximo = vertice; 
				ultimoV = vertice; 
			}
	}
	
	public void insereArestaNaoOrientada(int vOrigem, int vDestino) {  //Inserir uma aresta em um GRAFO N�O ORIENTADO
			
		Aresta aresta = new Aresta(vOrigem, vDestino);
			
		if (estaVazio()) { 
			primeiro = aresta; 
			ultimo = aresta;
			atual = aresta; 
			}else {
				ultimo.proximo = aresta; 
				ultimo = aresta; 
			}
		}
		
	
	public void insereArestaOrientada(int vOrigem, int vDestino) { //Inserir uma aresta em um GRAFO ORIENTADO
			
		Aresta aresta = new Aresta(vOrigem, vDestino);
			
		if (estaVazio()) {
			primeiro = aresta;
			ultimo = aresta;
			atual = aresta; 
		}else {
				ultimo.proximo = aresta; 
				ultimo = aresta; 
		}
	}
		
	public void insereArestaValorada(int vOrigem, int vDestino, int valor) {  //Inserir uma aresta em um GRAFO VALORADO
			
		Aresta aresta = new Aresta(vOrigem, vDestino, valor);
			
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
			
		Aresta aresta = new Aresta(vOrigem, vDestino, nArestas);
			
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
		
	public boolean buscaElemento(int vOrigem, int vDestino) { //buscar a aresta (conjunto) indicado
			
		atual = primeiro;
		//Enquanto o valor n�o for nulo (n�o chegar ao fim da lista, onde o ultima aresta.proximo aponta para null)
		//e o vertice origem e destino n�o forem achados, continuar� a percorer a lista
		while(atual!= null && (atual.vOrigem != vOrigem || atual.vDestino != vDestino)) {  
			atual = atual.proximo; 
		}
			
		if (atual != null) { //se a aresta for achada, retorna o valor do contador
			return true; 
		}
		
		return false; // caso retorne -1, significa que a arresta n�o existe no conjunto E
		
	}
	
	public boolean buscaElementoValorado(int vOrigem, int vDestino, int valor) { //buscar a aresta (conjunto) indicado
		
		atual = primeiro;
		//Enquanto o valor n�o for nulo (n�o chegar ao fim da lista, onde o ultima aresta.proximo aponta para null)
		//e o vertice origem e destino n�o forem achados, continuar� a percorer a lista
		while(atual!= null && (atual.vOrigem != vOrigem || atual.vDestino != vDestino || atual.valor != valor)) {  
			atual = atual.proximo; 
		
		}
			
		if (atual != null) { //se a aresta for achada, retorna o valor do contador
			return true; 
		}
		
		return false; // caso retorne -1, significa que a arresta n�o existe no conjunto E
		
	}
		
	
	public String RepresentacaoListaDeArestas() {
		
		String representacao = "E = { "; //Conjunto E
		atual = primeiro;
		
		while(atual!= null) { //percorrer a lista
			representacao+="("+atual.vOrigem + "," + atual.vDestino + ") "; //concatenar os valores
			atual = atual.proximo;  
		}
		
		return representacao + " }"; //retornar a representa��o
	}
	
	public String RepresentacaoValoradaEmultigrafos() {
		
		String representacao = "E = { ";
		atual = primeiro;
		
		while(atual!= null) {
			representacao+="("+atual.vOrigem + "," + atual.vDestino + "," + atual.valor + ") ";
			atual = atual.proximo;  
		}
		
		return representacao + " }";
	}

}



