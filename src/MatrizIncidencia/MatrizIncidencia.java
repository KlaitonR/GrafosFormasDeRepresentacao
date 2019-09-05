package MatrizIncidencia;

import javax.swing.JOptionPane;

public class MatrizIncidencia {

public void representacaoMatrizIncidencia(int v, int e, int op) {
		
		int matriz [][] = new int [v][e];
		String conjuntoV [] = new String [v];
		String origem [] = new String[e];
		String destino[] = new String [e];
		int nAresta[] = new int [e];
		int valor[] = new int [e];
		boolean verf = false;
		String representacao = "";
		int cont = 1;
		
		for(int i=0;i<v;i++) {
			conjuntoV[i] = JOptionPane.showInputDialog("Insira o " + cont + "º vertice:");
			cont++;
		}
		
		if(op==1) {
			
			cont = 1;
			for(int i=0;i<e;i++) {
				origem[i] = JOptionPane.showInputDialog("Insira o primeiro label do par " + cont + ":");
				destino[i] = JOptionPane.showInputDialog("Insira o primeiro label do par " + cont + ":");
				cont++;
				
				for(int j=0;j<e;j++) {
					if((origem[i].equals(destino[j]) && destino[i].equals(origem[j])) || (origem[i].equals(origem[j]) && destino[i].equals(destino[j]) && i!=j)) { //verifica se está arresta já foi inserida, ex: (1,2) ou (2,1)
						verf = true;
					}
				}
				
				if(verf==true) {
					cont--;
					i--; //Volta uma posição no vetor 
					JOptionPane.showMessageDialog(null, "Está aresta já foi inserida!");
					verf = false;
				}
				
			}
		}else {
			if(op==2) {
				
				cont = 1;
				for(int i=0;i<e;i++) {
					origem[i] = JOptionPane.showInputDialog("Insira o primeiro label do par " + cont + ":");
					destino[i] = JOptionPane.showInputDialog("Insira o primeiro label do par " + cont + ":");
					cont++;
					
					for(int j=0;j<e;j++) {
						if(origem[i].equals(origem[j]) && destino[i].equals(destino[j]) && i!=j) { //verifica se está arresta já foi inserida, ex: (1,2) ou (2,1)
							verf = true;
						}
					}
					
					if(verf==true) {
						cont--;
						i--; //Volta uma posição no vetor 
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
		
		//PREENCHER MATRIZ
		for(int i=0;i<v;i++) {
			representacao += "\n";
			for(int j=0;j<e;j++) {
				
				if(op==1) {
					
					verf = false;
					
					if((conjuntoV[i].equals(origem[j])) || (conjuntoV[i].equals(destino[j]))) {
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
								if((conjuntoV[i].equals(origem[j]))) { 
									vOrigem = true; //Se for, confirma com true 
								}else {
									if(conjuntoV[i].equals(destino[j])) { //Verifica se o vertice é destino
										vDestino = true; //Se for, confirma com true 
									}
								}
								
								if(vOrigem==true) { 
									matriz[i][j] = 1; //Adiciona 1 a matriz se o vetor for origem
								}else {
									if(vDestino == true) {
										matriz[i][j] = -1; //Adiciona -1 a matriz se o vertice for destino
									}else {
										matriz[i][j] = 0; 
									}
								}
								
							representacao += matriz[i][j] + " "; 
							
						}else {
							if(op==3){
								
								verf = false;

								if((conjuntoV[i].equals(origem[j])) || (conjuntoV[i].equals(destino[j]))) {
									verf = true;
								}

							if(verf==true) {
								matriz[i][j] = valor[j];
							}else {
								matriz[i][j] = 0;
							}

							representacao += matriz[i][j] + " ";
								
							}else {
								if(op==4) {
									
									verf = false;

									if((conjuntoV[i].equals(origem[j])) || (conjuntoV[i].equals(destino[j]))) {
										verf = true;
									}

								if(verf==true) {
									matriz[i][j] = nAresta[j];
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
