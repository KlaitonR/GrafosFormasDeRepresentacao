package ListaAdjacencia;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ListaAdjacencia {
	
	ArrayList<Vertice> conjuntoV = new ArrayList<>();

	public void grafoNaoOrientado(int v, int e){
		
		 
		 String representação = "";
		 Grafo g = insereConjuntoV(v);
		 insereConjuntoE(g.getConjuntoV(),e, g);
		 
		//int i=1;
		//Grafo g = new Grafo();
		
		//do {
			
			//Vertice v1 = new Vertice();
			//Vertice v2 = new Vertice();
			//v1.setValor(Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro valor do conjunto "+ i +".")));
			//v2.setValor(Integer.parseInt(JOptionPane.showInputDialog("Insira o segundo valor do conjunto "+ i +".")));
			
			//Adicinar vertices no Conjunto V
			//g.getConjuntoV().add(v1);
			//g.getConjuntoV().add(v2);
			//conjuntoV.add(v2);
			//conjuntoV.add(v1);
			
			//Adicionar os vertices adjacentes
			//v1.getListaDeAdjacencia().add(v2);
			//v2.getListaDeAdjacencia().add(v1);
			
			//Aresta a = new Aresta(v1,v2);
			
			//Adicionar as Arestas no conjunto E
			//g.getConjuntoE().add(a);
			
			//verificar se o vertice já foi inserido, e adicionar o outro vertice do seu conjunto como seu adjacente
			//for(Vertice v: conjuntoV) {
				//Pegar o vertice que esta sendo adicionado, e colocar em seu conjunto de adjacencias o vertice que faz conjunto com o que esta sendo inserido
				//if(v.getValor()== v1.getValor()) {
				//	v.getListaDeAdjacencia().add(v2);
				//}else{
				//	v1.getListaDeAdjacencia().add(v2);
					
				//}
			
				//if(v.getValor()== v2.getValor()) {
					//v.getListaDeAdjacencia().add(v1);
			//	}else {
			//		v2.getListaDeAdjacencia().add(v1);
			//	}
		//	}
			//conjuntoV.add(v1);
			//conjuntoV.add(v2);
		//	i++;
			
		//}while(i<=e);
		
		//Roda toda a lista de vertices do grafo adicionando a String representação
		//o valor do vertices e sua respectiva lista de adjacencia com o toString de cada Vertice
		for(Vertice vertice: conjuntoV) {
			representação+= vertice.getValor() +" - " + vertice.toString() + ")"+"\n ";
		}
		
		JOptionPane.showMessageDialog(null, representação);
		
	}
	
	public Grafo insereConjuntoV(int ver) {
		
		int i=1;
		
		Grafo g = new Grafo();
		
		do {
			Vertice v = new Vertice();
			v.setValor(Integer.parseInt(JOptionPane.showInputDialog("Insira o label do "+ i +"º vertice.")));
			g.getConjuntoV().add(v);
			conjuntoV.add(v);
			i++;
		}while(i<=ver);
		
		return g;
	}
	
	public Grafo insereConjuntoE(ArrayList<Vertice> vertices,int e,Grafo g) {
		
		ArrayList<Vertice> ver = new ArrayList<>();
		ver = vertices;
		
		int i=1;
		do {
			
			Vertice v1 = new Vertice();
			Vertice v2 = new Vertice();
			v1.setValor(Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro valor do conjunto "+ i +".")));
			v2.setValor(Integer.parseInt(JOptionPane.showInputDialog("Insira o segundo valor do conjunto "+ i +".")));
			
			for(Vertice v: ver) {
				
				if(v1.getValor()==v.getValor()) {
					
					int x = v1.getListaDeAdjacencia().size();
					do {
						Vertice vtemp = new Vertice();
						vtemp = v1.getListaDeAdjacencia().get(x);
						if(vtemp!=v) {
							v1.getListaDeAdjacencia().add(v2);
						}
						x--;
					}while(x!=0|x>0);
					
					//for(int x = v1.getListaDeAdjacencia().size();x>0;x--){
						//if(v1.getListaDeAdjacencia().get(x)!=v) {
						//	v1.getListaDeAdjacencia().add(v2);
						//	}
					//}
				}
				
				if(v2.getValor()==v.getValor()) {
					
					int x = v2.getListaDeAdjacencia().size();
					do {
						if(v2.getListaDeAdjacencia().get(x)!=v) {
							v2.getListaDeAdjacencia().add(v1);
						}
						x--;
					}while(x!=0|x>0);
					
					//for(int y = v2.getListaDeAdjacencia().size();y>0;y--){
						//if(v2.getListaDeAdjacencia().get(y)!=v) {
						//	v2.getListaDeAdjacencia().add(v1);
						//}
					//}
				}
				
			}
			
			//v1.getListaDeAdjacencia().add(v2);
			//v2.getListaDeAdjacencia().add(v1);

			Aresta a = new Aresta(v1,v2);
			g.getConjuntoE().add(a);
			
			i++;
			
		}while(i<=e);
		
		
		return g;
	}
	

}
