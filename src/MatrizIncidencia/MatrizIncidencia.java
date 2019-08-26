package MatrizIncidencia;

import javax.swing.JOptionPane;

public class MatrizIncidencia {

public void representacaoMatrizNaoOrdenada(int v, int e) {
		
		int t = v++; //ajustar os valore, t = tamnho v
		int te = e++; //ajustar os valore, te = tamnho e
		
		int matriz [][] = new int [v][e];
		int conjuntoV [] = new int [v];
		int origem [] = new int[e];
		int destino[] = new int [e];
		String representacao = "";
		
		for(int i=1;i<=t;i++) {
			conjuntoV[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o " + i + "º vertice:"));
		}
		
		for(int i=1;i<=te;i++) {
			origem[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
			destino[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
		}
		
		for(int i=1;i<=t;i++) {
			representacao += "\n";
			for(int j=1;j<=te;j++) {
				
				boolean verf = false;
					
					if((conjuntoV[i]==origem[j]) || (conjuntoV[i]==destino[j])) {
						verf = true;
					}
			
				if(verf==true) {
					matriz[i][j] = 1;
				}else {
					matriz[i][j] = 0;
				}
				
				representacao += matriz[i][j] + " ";
				
			}
		}
		
		JOptionPane.showMessageDialog(null, representacao);
		
	}

public void representacaoMatrizOrdenada(int v, int e) {
	
	int t = v++; //ajustar os valore, t = tamnho v
	int te = e++; //ajustar os valore, te = tamnho e
	
	int matriz [][] = new int [v][e];
	int conjuntoV [] = new int [v];
	int origem [] = new int[e];
	int destino[] = new int [e];
	String representacao = "";
	
	for(int i=1;i<=t;i++) {
		conjuntoV[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o " + i + "º vertice:"));
	}
	
	for(int i=1;i<=te;i++) {
		origem[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
		destino[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
	}
	
	for(int i=1;i<=t;i++) {
		representacao += "\n";
		for(int j=1;j<=te;j++) {
			
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
			
		}
	}
	
	JOptionPane.showMessageDialog(null, representacao);
	
}

public void representacaoMatrizMultigrafo(int v, int e) {
	
	int t = v++; //ajustar os valore, t = tamnho v
	int te = e++; //ajustar os valore, te = tamnho e
	
	int matriz [][] = new int [v][e];
	int conjuntoV [] = new int [v];
	int origem [] = new int[e];
	int destino[] = new int [e];
	int nAresta[] = new int [e];
	String representacao = "";
	
	for(int i=1;i<=t;i++) {
		conjuntoV[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o " + i + "º vertice:"));
	}
	
	for(int i=1;i<=te;i++) {
		origem[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
		destino[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
		nAresta[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o número de arestas do conjunto " + i + ":"));
	}
	
	for(int i=1;i<=t;i++) {
		representacao += "\n";
		for(int j=1;j<=te;j++) {
			
			boolean verf = false;
				
				if((conjuntoV[i]==origem[j]) || (conjuntoV[i]==destino[j])) {
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
	
	JOptionPane.showMessageDialog(null, representacao);
	
}

public void representacaoMatrizValorado(int v, int e) {
	
	int t = v++; //ajustar os valore, t = tamnho v
	int te = e++; //ajustar os valore, te = tamnho e
	
	int matriz [][] = new int [v][e];
	int conjuntoV [] = new int [v];
	int origem [] = new int[e];
	int destino[] = new int [e];
	int valor[] = new int [e];
	String representacao = "";
	
	for(int i=1;i<=t;i++) {
		conjuntoV[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o " + i + "º vertice:"));
	}
	
	for(int i=1;i<=te;i++) {
		origem[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
		destino[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
		valor[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o número de arestas do conjunto " + i + ":"));
	}
	
	for(int i=1;i<=t;i++) {
		representacao += "\n";
		for(int j=1;j<=te;j++) {
			
			boolean verf = false;
				
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
	
	JOptionPane.showMessageDialog(null, representacao);
	
}

}
