package ListaDeArestas;

public class ListaDeArestas {

	private Elemento primeiro, atual, ultimo; //Elementos da lista
	
	public ListaDeArestas() {
		primeiro = atual = ultimo = null;  
	} 

		// Retorna um booleano indicando se a lista está vazia 
	public boolean estaVazio() {
		return primeiro == null; 
	}
	
	public void insereArestaNaoOrientada(int vOrigem, int vDestino) {  //Inserir uma aresta em um GRAFO NÃO ORIENTADO
			
			Elemento aresta = new Elemento(vOrigem, vDestino);
			
			if (estaVazio()) { //verifica se está vazia
				primeiro = aresta; // Se estiver vazia, coloca a aresta instanciada como a primeira, ultima e atual da lista
				ultimo = aresta;
				atual = aresta; 
				}else { // Se não estiver vazia, indica que a proxima aresta da lista será a recém instanciada, e posteriormente a aloca como última
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
				//	JOptionPane.showMessageDialog(null, aresta.vOrigem + " não pode ser adjacente à " + aresta.vDestino);
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
		
		public void moveParaPosicao(int pos) { //mover para a poção indicado pelo parâmetro "pos"
			
			atual = primeiro; // A aresta atual será a primeira da lista
			
			for(int i=0; i<pos; i++) { //percorre a lista até a posição indicada
				atual= atual.proximo;
			}
		}
		
		public int buscaElemento(int vOrigem, int vDestino) { //buscar a aresta (conjunto) indicado
			
			int cont = 0; 
			atual = primeiro;
			//Enquanto o valor não for nulo (não chegar ao fim da lista, onde o ultima aresta.proximo aponta para null)
			//e o vertice origem e destino não forem achados, continuará a percorer a lista
			while(atual!= null && atual.vOrigem != vOrigem && atual.vDestino != atual.vDestino) {  
				atual = atual.proximo; 
				cont ++; //contador
			}
			
			if (atual != null) //se a aresta for achada, retorna o valor do contador
				return cont; 
			
			return -1; // caso retorne -1, significa que a arresta não existe no conjunto E
		}
		
	
	public String RepresentacaoListaDeArestas() {
		
		String representacao = "E = { "; //Conjunto E
		primeiro = atual;
		
		while(atual!= null) { //percorrer a lista
			representacao+="("+atual.vOrigem + "," + atual.vDestino + ") "; //concatenar os valores
			atual = atual.proximo;  
		}
		
		return representacao + " }"; //retornar a representação
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



