  package ListaAdjacencia;

import javax.swing.JOptionPane;

public class ListaAdjacencia {
	
	//ArrayList<Vertice> conjuntoV = new ArrayList<>();

	public void grafoNaoOrientado(int v, int e){
		
		 
		 //String representacao = "";
		 Grafo g = insereConjuntoV(v);
		 insereConjuntoE(e,g);
		 Representacao(g);
		 
		// conjuntoV = g.getConjuntoV();
		
		//Roda toda a lista de vertices do grafo adicionando a String representação
		//o valor do vertices e sua respectiva lista de adjacencia com o toString de cada Vertice
		//for(Vertice vertice: conjuntoV) {
		
	}
	
	public Grafo insereConjuntoV(int ver) {
		
		int i=1;
		
		Grafo g = new Grafo();
		
		do {
			Vertice v = new Vertice();
			v.setValor(Integer.parseInt(JOptionPane.showInputDialog("Insira o label do "+ i +"º vertice.")));
			g.getConjuntoV().add(v);
			i++;
		}while(i<=ver);
		
		return g;
	}
	
	public Grafo insereConjuntoE(int e,Grafo g) {
		
		//ArrayList<Vertice> ver = new ArrayList<>();
		//ver = vertices; //Pega a ArrayList de vertices do grafo que veio por parametro
		
		int i=1;
		do {
			
			Vertice v1 = new Vertice();
			Vertice v2 = new Vertice();
			
			v1.setValor(Integer.parseInt(JOptionPane.showInputDialog("Insira o vertice de origem do conjunto "+ i +".")));
			v2.setValor(Integer.parseInt(JOptionPane.showInputDialog("Insira o vertice de origem do conjunto "+ i +".")));
			
			v1.getListaDeAdjacencia().add(v2);
			v2.getListaDeAdjacencia().add(v1);
			
			Aresta a = new Aresta(v1, v2);
			g.getConjuntoE().add(a);
			
			//for(Vertice v: ver) { //Rodar lista de vertices
			for(int j = 1; j<=g.getConjuntoV().size();j++) {
				
				if(v1.getValor()==g.getConjuntoV().get(j).getValor()) {
					
					v1.getListaDeAdjacencia().add(v2);
					
				}else {
					
					if(v2.getValor()==g.getConjuntoV().get(j).getValor()) {
						
						v2.getListaDeAdjacencia().add(v1);
						
					}	
				}
			}
			//}
			
			i++;
			
		}while(i<=e);
		
		
		return g;
	}
	
	public void Representacao (Grafo g) {
		
		String representacao = "";
		
		 for(int i = 1; i<=g.getConjuntoV().size();i++) {
			 for(int j = 1; i<=g.getConjuntoV().size();j++) {
				 representacao += g.getConjuntoV().get(i).getValor() +" - " + g.getConjuntoV().get(i).getListaDeAdjacencia().get(j).getValor() + ")"+"\n ";
			 }
		 }
			//representação += vertice.getValor() +" - " + vertice.toString() + ")"+"\n ";
		//}
		
		JOptionPane.showMessageDialog(null, representacao);
	}
	

}
