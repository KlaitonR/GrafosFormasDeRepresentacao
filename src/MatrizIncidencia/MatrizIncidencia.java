package MatrizIncidencia;

import javax.swing.JOptionPane;

public class MatrizIncidencia {

public void representacaoMatrizIncidencia(int v, int e, int op) {
		
		int t = v++; //ajustar os valore, t = tamnho v
		int te = e++; //ajustar os valore, te = tamnho e
		
		int matriz [][] = new int [v][e];
		int conjuntoV [] = new int [v];
		int origem [] = new int[e];
		int destino[] = new int [e];
		int nAresta[] = new int [e];
		int valor[] = new int [e];
		boolean verf = false;
		String representacao = "";
		
		for(int i=1;i<=t;i++) {
			conjuntoV[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o " + i + "º vertice:"));
		}
		
		
		if(op==1) {
			
			for(int i=1;i<=te;i++) {
				origem[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
				destino[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
				
				for(int j=1;j<=te;j++) {
					if((origem[i]==destino[j] && destino[i]==origem[j]) || (origem[i]==origem[j] && destino[i]==destino[j] && i!=j)) { //verifica se está arresta já foi inserida, ex: (1,2) ou (2,1)
						verf = true;
					}
				}
				
				if(verf==true) {
					i--; //Volta uma posição no vetor 
					JOptionPane.showMessageDialog(null, "Está aresta já foi inserida!");
					verf = false;
				}
				
			}
		}else {
			if(op==2) {
				for(int i=1;i<=te;i++) {
					origem[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
					destino[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
					
					for(int j=1;j<=te;j++) {
						if((origem[i]==origem[j] && destino[i]==destino[j])) { //verifica se está arresta já foi inserida, ex: (1,2) ou (2,1)
							verf = true;
						}
					}
					
					if(verf==true) {
						i--; //Volta uma posição no vetor 
						JOptionPane.showMessageDialog(null, "Está aresta já foi inserida!");
						verf = false; //reinicia a variavel
					}
	
				}
			}else {
				if(op==3) {
					for(int i=1;i<=te;i++) {
						origem[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
						destino[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
						valor[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor da aresta do conjunto " + i + ":"));
					}
					
				}else {
					if(op==4) {
						for(int i=1;i<=te;i++) {
							origem[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
							destino[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
							nAresta[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o número de arestas do conjunto " + i + ":"));
						}
					}
				}
			}
		}
		
		/*int grauDoVertice [] = new int [t];
		
		for(int i=1;i<=t;i++) {
			
			for(int j=1;j<=te;j++) {
				if(conjuntoV[i]==origem[j] || conjuntoV[i]==destino[j]) {
					grauDoVertice[i]++;
				}
			}
			
		}
		
		int somaDosGraus = 0;
		
		for(int i=1;i<=t;i++) {
			somaDosGraus += grauDoVertice[i];
		}
		
		if(somaDosGraus != (e*2)) {
			JOptionPane.showMessageDialog(null, "Estes não são parametros de um grafo, tente outros valores.");
		}else { */
		
		//PREENCHER MATRIZ
		for(int i=1;i<=t;i++) {
			representacao += "\n";
			for(int j=1;j<=te;j++) {
				
				if(op==1) {
					
					verf = false;
					
					if((conjuntoV[i]==origem[j]) || (conjuntoV[i]==destino[j])) {
						verf = true;
					}
			
					if(verf==true) {
						matriz[i][j] = 1;
					}else {
						matriz[i][j] = 0;
					}
				
					representacao += matriz[i][j] + " ";
					
					}else {
						if(op==2) {
							
							//verificação de origem e destino
							boolean vOrigem = false;
							boolean vDestino = false;
							
								// Verifica se o verttice do vetor é origem
								if((conjuntoV[i]==origem[j])) { 
									vOrigem = true; //Se for, confirma com true 
								}else {
									if(conjuntoV[i]==destino[j]) { //Verifica se o vertice é destino
										vDestino = true; //Se for, confirma com true 
									}
								}
								
								if(vOrigem==true) { 
									matriz[i][j] = 1; 
								}else {
									if(vDestino == true) {
										matriz[i][j] = -1; //Adiciona 1 a matriz se o vetor for origem
									}else {
										matriz[i][j] = 0; //Adiciona -1 a matriz se o vertice for destino
									}
								}
								
							representacao += matriz[i][j] + " "; 
							
						}else {
							if(op==3){
								
								verf = false;
								
								if((conjuntoV[i]==origem[j]) || (conjuntoV[i]==destino[j])) {
									verf = true;
								}
							
							if(verf==true) {
								matriz[i][j] = nAresta[j];
							}else {
								matriz[i][j] = 0;
							}
							
							representacao += matriz[i][j] + " ";
								
							}else {
								if(op==4) {
									
									verf = false;
									
									if((conjuntoV[i]==origem[j]) || (conjuntoV[i]==destino[j])) {
										verf = true;
									}
								
								if(verf==true) {
									matriz[i][j] = valor[j];
								}else {
									matriz[i][j] = 0;
								}
								
								representacao += matriz[i][j] + " ";
								}
							}
						}
					}
			}
		}
		
		JOptionPane.showMessageDialog(null, representacao);
		
	}
		
	//}

}
