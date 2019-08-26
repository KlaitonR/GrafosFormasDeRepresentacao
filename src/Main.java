import javax.swing.JOptionPane;
import ListaAdjacencia.ListaAdjacencia;
import ListaDeArestas.ListaDeArestas;
import MatrizAdjacencia.MatrizAdjacencia;
import MatrizIncidencia.MatrizIncidencia;

public class Main {

	public static void main(String[] args) {
		
		//if() { //Validação se é grafo ou não
			
		//}
		
		int op = 0;
	
		do {
			switch (op) {
			case 1:
				
				int op1 = 0;
				do {
					
					ListaDeArestas lda= new ListaDeArestas();
					int i;
					int j = 1;
					
					switch (op1) { 
					case 1: // Para representação de listas de arestas com grafo não orientado
						i = tamanhoE();
						do {
							int vOrigem = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro valor da aresta "+ j +""));
							int vDestino = Integer.parseInt(JOptionPane.showInputDialog("Insira o segundo valor da aresta "+ j +""));
							lda.insereArestaNaoOrientada(vOrigem, vDestino);
							j++;
						}while(j<=i);
						
						JOptionPane.showMessageDialog(null,lda.RepresentacaoListaDeArestas());
						break;
						
					case 2:
						i = tamanhoE();
						
						do {
							int vOrigem = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro vertice da aresta "+ j +""));
							int vDestino = Integer.parseInt(JOptionPane.showInputDialog("Insira o segundo vertice da aresta "+ j +""));
							lda.insereArestaOrientada(vOrigem, vDestino);
							j++;
						}while(j<=i);
						
						JOptionPane.showMessageDialog(null,lda.RepresentacaoListaDeArestas());
						
						break;
						
					case 3:
						i = tamanhoE();
						do {
							int vOrigem = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro vertice da aresta "+ j +":"));
							int vDestino = Integer.parseInt(JOptionPane.showInputDialog("Insira o segundo vertice da aresta "+ j +":"));
							int valor = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor da aresta "+ j +""));
							lda.insereArestaValorada(vOrigem, vDestino,valor);
							j++;
						}while(j<=i);
						
						JOptionPane.showMessageDialog(null,lda.RepresentacaoValoradaEmultigrafos());
						
						break;
						
					case 4:
						i = tamanhoE();
						do {
							int vOrigem = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro vertice da aresta "+ j +":"));
							int vDestino = Integer.parseInt(JOptionPane.showInputDialog("Insira o segundo vertice da aresta "+ j +":"));
							int nAresta = 0;
							do {
								nAresta = Integer.parseInt(JOptionPane.showInputDialog("Insira o número de " +
										 "arestas para o conjunto ("+ vOrigem +","+vDestino+"):"));
								if(nAresta<=0) {
									JOptionPane.showMessageDialog(null, "Impossível inserir número de arestas negativas ou zero");
								}
								
							}while(nAresta<=0);
							
							lda.insereArestaValorada(vOrigem, vDestino,nAresta);
							j++;
						}while(j<=i);
						
						JOptionPane.showMessageDialog(null,lda.RepresentacaoValoradaEmultigrafos());
						
						break;
					}
					
					op1 = retornaMenu2();
					
				}while(op1!=5);
				
				break;
				
			case 2:
				int op2 = 0;
				
				do {
					
					ListaAdjacencia la = new ListaAdjacencia();
					
					switch (op2) {
					case 1:
						
						la.grafoNaoOrientado(tamanhoV(),tamanhoE());
						break;
						
					}
					
					op2 = retornaMenu2();
					
				}while(op2!=5);
			
				break;
				
			case 3:
				
				int op3 = 0;
				
				do {
					
					MatrizAdjacencia ma = new MatrizAdjacencia(); //nova matriz
					
					switch (op3) {
					case 1:
						ma.representacaoMatrizNaoOrdenada(tamanhoV(),tamanhoE()); //passa a ordem e o tamanho do grafo como parametro
						break;
						
					case 2:
						ma.RepresentacaoMatrizOrdenada(tamanhoV(), tamanhoE());
						break;
						
					case 3:
						ma.representacaoValorado(tamanhoV(), tamanhoE());
						break;
					
					case 4:
						ma.representacaoMultigrafo(tamanhoV(), tamanhoE());
					
					}
					op3 = retornaMenu2();
				}while(op3!=5);
				
				break;
				
			case 4:
				
				int op4 = 0;
				
				do {
					
					MatrizIncidencia mi = new MatrizIncidencia();
					
					switch (op4) {
					case 1:
						mi.representacaoMatrizNaoOrdenada(tamanhoV(), tamanhoE());
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
