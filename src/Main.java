import javax.swing.JOptionPane;
import ListaAdjacencia.ListaAdjacencia;
import ListaDeArestas.ListaDeArestas;
import MatrizAdjacencia.MatrizAdjacencia;
import MatrizIncidencia.MatrizIncidencia;

public class Main {

	public static void main(String[] args) {
		
		int op = 0;
	
		do {
			switch (op) {
			case 1: //LISTA DE ARESTAS
				
				int op1 = 0;
				do {
					
					ListaDeArestas lda= new ListaDeArestas();
					int v;
					int e;
					int j = 1;
					
					switch (op1) { 
					case 1: // Para representação de listas de arestas com grafo não orientado
						v = tamanhoV(); //tamanhoo conjunto V
						e = tamanhoE(); //tamanho conjunto E
						
						do { //Inserindo conjunto V
							
							int vertice= Integer.parseInt(JOptionPane.showInputDialog("Insira o label do "+ j +"º vertice:"));
							lda.insereVertice(vertice);
							j++;
					
						}while(j<=v);
						
						j=1;
						
						do { // Inserindo conjunto E
							
							int vOrigem = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro valor da aresta "+ j +""));
							int vDestino = Integer.parseInt(JOptionPane.showInputDialog("Insira o segundo valor da aresta "+ j +""));
							
							if(lda.buscaElemento(vOrigem, vDestino) == false && lda.buscaElemento(vDestino, vOrigem) == false) { //verifica se está aresta já existe na lista
								lda.insereArestaNaoOrientada(vOrigem, vDestino);
								j++;
							}else {
								JOptionPane.showMessageDialog(null, "Está aresta já foi inserida!");
							}

						}while(j<=e);
						
						JOptionPane.showMessageDialog(null,lda.RepresentacaoListaDeArestas());
						break;
						
					case 2:
						v = tamanhoV();
						e = tamanhoE();
						
						do {
							
							int vertice= Integer.parseInt(JOptionPane.showInputDialog("Insira o label do "+ j +"º vertice:"));
							lda.insereVertice(vertice);
							j++;
					
						}while(j<=v);
						
						j=1;
						
						do {
							int vOrigem = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro vertice da aresta "+ j +""));
							int vDestino = Integer.parseInt(JOptionPane.showInputDialog("Insira o segundo vertice da aresta "+ j +""));
							
							if(lda.buscaElemento(vOrigem, vDestino) == false) {
								lda.insereArestaOrientada(vOrigem, vDestino);
								j++;
							}else {
								JOptionPane.showMessageDialog(null, "Está aresta já foi inserida!");
							}
						}while(j<=e);
						
						JOptionPane.showMessageDialog(null,lda.RepresentacaoListaDeArestas());
						
						break;
						
					case 3:
						v = tamanhoV();
						e = tamanhoE();
						
						do {
							
							int vertice= Integer.parseInt(JOptionPane.showInputDialog("Insira o label do "+ j +"º vertice:"));
							
								lda.insereVertice(vertice);
								j++;
					
						}while(j<=v);
						
						j=1;
						
						do {
							int vOrigem = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro vertice da aresta "+ j +":"));
							int vDestino = Integer.parseInt(JOptionPane.showInputDialog("Insira o segundo vertice da aresta "+ j +":"));
							int valor = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor da aresta "+ j +""));
							
							if(lda.buscaElementoValorado(vOrigem, vDestino, valor) == false) {
								lda.insereArestaValorada(vOrigem, vDestino, valor);
								j++;
							}else {
								JOptionPane.showMessageDialog(null, "Está aresta já foi inserida!");
							}
							
						}while(j<=e);
						
						JOptionPane.showMessageDialog(null,lda.RepresentacaoValoradaEmultigrafos());
						
						break;
						
					case 4:
						v = tamanhoV();
						e = tamanhoE();
						
						do {
							
							int vertice= Integer.parseInt(JOptionPane.showInputDialog("Insira o label do "+ j +"º vertice:"));
							
								lda.insereVertice(vertice);
								j++;
					
						}while(j<=v);
						
						j=1;
						
						do {
							int vOrigem = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro vertice da aresta "+ j +":"));
							int vDestino = Integer.parseInt(JOptionPane.showInputDialog("Insira o segundo vertice da aresta "+ j +":"));
							int nAresta = 0;
							
							do {
								nAresta = Integer.parseInt(JOptionPane.showInputDialog("Insira o número de " +
										 "arestas para o par ("+ vOrigem +","+vDestino+"):"));
								if(nAresta<=0) {
									JOptionPane.showMessageDialog(null, "Impossível inserir número de arestas negativas ou zero");
								}
								
							}while(nAresta<=0);
							
							if(lda.buscaElementoValorado(vOrigem, vDestino, nAresta) == false) {
								lda.insereArestaValorada(vOrigem, vDestino,nAresta);
								j++;
							}else {
								JOptionPane.showMessageDialog(null, "Está aresta já foi inserida!");
							}
							
						}while(j<=e);
						
						JOptionPane.showMessageDialog(null,lda.RepresentacaoValoradaEmultigrafos());
						
						break;
					}
					
					op1 = retornaMenu2();
					
				}while(op1!=5);
				
				break;
				
			case 2: //LISTA ADJACÊNCIA
				int op2 = 0;
				
				do {
					
					ListaAdjacencia la = new ListaAdjacencia();
					
					switch (op2) {
					case 1:
						
						la.grafoNaoOrientado(tamanhoV(),tamanhoE());
						break;
						
					case 2:
						break;
						
					case 3:
						break;
						
					case 4:
						break;
					}
					
					op2 = retornaMenu2();
					
				}while(op2!=5);
			
				break;
				
			case 3: //MATRIZ ADJACÊNCIA
				
				int op3 = 0;
				
				do {
					
					MatrizAdjacencia ma = new MatrizAdjacencia(); //nova matriz
					
					switch (op3) {
					case 1:
						ma.representacaoMatrizAdjacencia(tamanhoV(),tamanhoE(), op3); //passa a ordem e o tamanho do grafo como parametro
						break;
						
					case 2:
						ma.representacaoMatrizAdjacencia(tamanhoV(), tamanhoE(), op3);
						break;
						
					case 3:
						ma.representacaoMatrizAdjacencia(tamanhoV(), tamanhoE(), op3);
						break;
					
					case 4:
						ma.representacaoMatrizAdjacencia(tamanhoV(), tamanhoE(), op3);
					
					}
					op3 = retornaMenu2();
				}while(op3!=5);
				
				break;
				
			case 4: //MATRIZ INCIDÊNCIA
				
				int op4 = 0;
				
				do {
					
					MatrizIncidencia mi = new MatrizIncidencia();
					
					switch (op4) {
					case 1:
						mi.representacaoMatrizIncidencia(tamanhoV(), tamanhoE(),op4);
						break;
					
					case 2:
						mi.representacaoMatrizIncidencia(tamanhoV(), tamanhoE(),op4);				
						break;
						
					case 3:
						mi.representacaoMatrizIncidencia(tamanhoV(), tamanhoE(),op4);
						break;
						
					case 4:
						mi.representacaoMatrizIncidencia(tamanhoV(), tamanhoE(),op4);
						break;
					
					}
					op4 = retornaMenu2();
				}while(op4!=5);
				
				break;
			}
			
			op = retornaMenu();
		
		}while (op != 5);

	}
	
static int retornaMenu() { //menu inicial
		
		String menu ="Qual o tipo de representação? \n"
					+"1 - Listas de arestas. \n"
					+ "2 - Listas de adjacência. \n"
					+ "3 -  Matriz de adjacência. \n"
					+ "4 - Matriz de incidência. \n" + 
					"\n"
					+ "5 - SAIR";
				
	return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

static int retornaMenu2() { //menu segundario
	
	String menu ="Qual o tipo de grafo? \n"
				+"1 - Não Orientado. \n"
				+ "2 - Orientado. \n"
				+ "3 - Valorado. \n"
				+ "4 - Multigrafo. \n" + 
				"\n"
				+ "5 - SAIR";
			
return Integer.parseInt(JOptionPane.showInputDialog(menu));
}

static int tamanhoV() { // Metodo para inserir a ordem do Grafo
	
	int v = Integer.parseInt(JOptionPane.showInputDialog("Insira a ordem do grafo (número de vértices): "));
	return v;
}

static int tamanhoE() { // metodo para inserir o tamanho do grafo
	int e = Integer.parseInt(JOptionPane.showInputDialog("Insira o tamanho do grafo (número de conjuntos/arestas): "));
	return e;
}

}
