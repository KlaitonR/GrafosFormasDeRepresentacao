package MatrizAdjacencia;

import javax.swing.JOptionPane;

public class MatrizAdjacencia {
	
	public void representacaoMatrizAdjacencia(int v, int e, int op) {
		
		int t = v++; //ajustar os valore, t = tamnho v
		int te = e++; //ajustar os valore, te = tamnho e
		
		int matriz [][] = new int [v][v];
		int conjuntoV [] = new int [v];
		int origem [] = new int[e];
		int destino[] = new int [e];
		int valor[] = new int[e];
		int nAresta[] = new int[e];
		boolean verf = false;
		String representacao = "";
		
		for(int i=1;i<=t;i++) {
			conjuntoV[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o " + i + "º vertice:"));
		}
		
		if(op==1) {
			
			for(int i=1;i<=te;i++) {
				origem[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do par " + i + ":"));
				destino[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do par " + i + ":"));
				
				for(int j=1;j<=te;j++) {
					if((origem[i]==destino[j] && destino[i]==origem[j])|| (origem[i]==origem[j] && destino[i]==destino[j] && i!=j)) { //verifica se está arresta já foi inserida, ex: (1,2) ou (2,1)
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
			if(op==2) {
				
				for(int i=1;i<=te;i++) {
					origem[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do par " + i + ":"));
					destino[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do par " + i + ":"));
					
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
						origem[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do par " + i + ":"));
						destino[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do par " + i + ":"));
						valor[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor da aresta (" + origem[i] + ","+destino[i]+"):"));
					}
				}else {
					if(op==4) {
						for(int i=1;i<=te;i++) {
							origem[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do par " + i + ":"));
							destino[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do par " + i + ":"));
							nAresta[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de arestas para este par (" + origem[i] + ","+destino[i]+"):"));
						}
					}
				}
			}
		}
		
		int vlInfinito = 0;
		
		
		if(op==3) {
			// Obter a media dos valores das arestas, e multiplicalas por 10000, dendo um valor de custo muito maior, sendo esta aresta descartada 
			int somatorio = 0;
			int media = 0;
			
			for(int k=1;k<=te;k++) {
				somatorio += valor[k];
			}
			
			media = somatorio/e;
			vlInfinito = media * 10000;
		}
		
		//PREENCHER MATRIZ
		for(int i=1;i<=t;i++) {
			representacao += "\n";
			for(int j=1;j<=t;j++) {
				
				if(op==1) {
					verf = false;
					
					for(int k=1;k<=te;k++) {
						if((origem[k]==i && destino[k]==j)||(origem[k]==j && destino[k]==i)) 
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
						verf = false;
						
						for(int k=1;k<=te;k++) {
							if((origem[k]==i && destino[k]==j)) //verf == false
								verf = true;
						}
						
						if(verf==true) {
							matriz[i][j] = 1;
						}else {
							matriz[i][j] = 0;
						}
						
						representacao += matriz[i][j] + " ";
					}else {
						if(op==3) {
							
							verf = false;
							int vl= vlInfinito;
							
							for(int k=1;k<=te;k++) {
								if((origem[k]==i && destino[k]==j)) { //verf == false
									verf = true;
									vl = valor[k];
								}
							}
							
							if(verf==true) {
								matriz[i][j] = vl;
							}else {
								matriz[i][j] = vlInfinito;
							}
							
							representacao += matriz[i][j] + " ";
							
						}else {
							if(op==4) {
								verf = false;
								int vl=0;
								
								for(int k=1;k<=te;k++) {
									if((origem[k]==i && destino[k]==j)) { //verf == false
										verf = true;
										vl = nAresta[k];
									}
								}
								
								if(verf==true) {
									matriz[i][j] = vl;
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