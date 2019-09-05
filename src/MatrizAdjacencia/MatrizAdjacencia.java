package MatrizAdjacencia;

import javax.swing.JOptionPane;

public class MatrizAdjacencia {
	
	public void representacaoMatrizAdjacencia(int v, int e, int op) {
		
		//int t = v++; //ajustar os valore, t = tamnho v
		//int te = e++; //ajustar os valore, te = tamnho e
		
		int matriz [][] = new int [v][v];
		String conjuntoV [] = new String [v];
		String origem [] = new String[e];
		String destino[] = new String [e];
		int valor[] = new int[e];
		int nAresta[] = new int[e];
		boolean verf = false;
		int cont = 1 ; //contador para label
		String representacao = "";
		
		for(int i=0;i<v;i++) {
			conjuntoV[i] = JOptionPane.showInputDialog("Insira o " + cont + "º vertice:");
			cont++;
		}
		
		if(op==1) {
			
			cont=1;
			for(int i=0;i<e;i++) {
				origem[i] = JOptionPane.showInputDialog("Insira o primeiro label do par " + cont + ":");
				destino[i] = JOptionPane.showInputDialog("Insira o primeiro label do par " + cont + ":");
				cont++;
				
				for(int j=0;j<e;j++) {
					if((origem[i].equals(destino[j]) && destino[i].equals(origem[j]) && i!=j) || (origem[i].equals(origem[j]) && destino[i].equals(destino[j]) && i!=j)) { //verifica se está arresta já foi inserida, ex: (1,2) ou (2,1)
						verf = true;
					}
				}
				
				if(verf==true) {
					i--; //Volta uma posição no vetor 
					cont--;
					JOptionPane.showMessageDialog(null, "Está aresta já foi inserida!");
					verf = false; //reinicia a variavel
				}
				
			}
			
		}else {
			if(op==2) {
				
				cont=1;
				for(int i=0;i<e;i++) {
					origem[i] = JOptionPane.showInputDialog("Insira o primeiro label do par " + cont + ":");
					destino[i] = JOptionPane.showInputDialog("Insira o primeiro label do par " + cont + ":");
					cont++;
					
					for(int j=0;j<e;j++) {
						if((origem[i].equals(origem[j]) && destino[i].equals(destino[j]) && i!=j)) { //verifica se está arresta já foi inserida, ex: (1,2) ou (2,1)
							verf = true;
						}
					}
					
					if(verf==true) {
						i--; //Volta uma posição no vetor 
						cont--;
						JOptionPane.showMessageDialog(null, "Está aresta já foi inserida!");
						verf = false; //reinicia a variavel
					}
					
				}
			}else {
				if(op==3) {
					
					cont=1;
					for(int i=0;i<e;i++) {
						origem[i] = JOptionPane.showInputDialog("Insira o primeiro label do par " + cont + ":");
						destino[i] = JOptionPane.showInputDialog("Insira o primeiro label do par " + cont + ":");
						
						try {
							valor[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor da aresta (" + origem[i] + "," + destino[i]+"):"));
			
							cont++;
						
							for(int j=0;j<e;j++) {
								if((origem[i].equals(destino[j]) && destino[i].equals(origem[j]) && valor[i]==valor[j] && i!=j)|| (origem[i].equals(origem[j]) && destino[i].equals(destino[j]) && valor[j]==valor[i] && i!=j)) { //verifica se está arresta já foi inserida, ex: (1,2) ou (2,1)
									verf = true;
								}
							}
						
							if(verf==true) {
								i--; //Volta uma posição no vetor 
								cont--;
								JOptionPane.showMessageDialog(null, "Está aresta já foi inserida!");
								verf = false; //reinicia a variavel
							}
						
						}catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Insira apenas números.");
							i--;
						}
					}
				}else {
					if(op==4) {
						
						cont = 1;
						for(int i=0;i<e;i++) {
							origem[i] = JOptionPane.showInputDialog("Insira o primeiro label do par " + cont + ":");
							destino[i] = JOptionPane.showInputDialog("Insira o primeiro label do par " + cont + ":");
							
							try {
								nAresta[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de arestas para este par (" + origem[i] + "," + destino[i]+"):"));
								cont++;
							
								for(int j=0;j<e;j++) {
									if((origem[i].equals(destino[j]) && destino[i].equals(origem[j]) && i!=j) || (origem[i].equals(origem[j]) && destino[i].equals(destino[j]) && i!=j)) { //verifica se está arresta já foi inserida, ex: (1,2) ou (2,1)
										verf = true;
									}
								}
							
								if(verf==true) {
									i--; //Volta uma posição no vetor 
									cont--;
									JOptionPane.showMessageDialog(null, "Está aresta já foi inserida!");
									verf = false; //reinicia a variavel
								}
							
							}catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Insira apenas números.");
								i--;
							}
						
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
			
			for(int k=0;k<e;k++) {
				somatorio += valor[k];
			}
			
			media = somatorio/e;
			vlInfinito = media * 10000;
		}
		
		//PREENCHER MATRIZ
		for(int i=0;i<v;i++) {
			representacao += "\n";
			for(int j=0;j<v;j++) {
				
				if(op==1) {
					verf = false;
					
					for(int k=0;k<e;k++) {
						if((origem[k].equals(conjuntoV[i]) && destino[k].equals(conjuntoV[j]))||(origem[k].equals(conjuntoV[j]) && destino[k].equals(conjuntoV[i]))) {
							verf = true;
						}
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
						
						for(int k=0;k<e;k++) {
							if((origem[k].equals(conjuntoV[i]) && destino[k].equals(conjuntoV[j]))) //verf == false
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
							
							for(int k=0;k<e;k++) {
								if((origem[k].equals(conjuntoV[i]) && destino[k].equals(conjuntoV[j]))) { //verf == false
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
								
								for(int k=0;k<e;k++) {
									if((origem[k].equals(conjuntoV[i]) && destino[k].equals(conjuntoV[j]))) { //verf == false
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
	
}