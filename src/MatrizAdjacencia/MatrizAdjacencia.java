package MatrizAdjacencia;

import javax.swing.JOptionPane;

public class MatrizAdjacencia {
	
	public void representacaoMatrizNaoOrdenada(int v, int e) {
		
		int t = v++; //ajustar os valore, t = tamnho v
		int te = e++; //ajustar os valore, te = tamnho e
		
		int matriz [][] = new int [v][v];
		int conjuntoV [] = new int [v];
		int x [] = new int[e];
		int y[] = new int [e];
		String representacao = "";
		
		for(int i=1;i<=t;i++) {
			conjuntoV[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o " + i + "º vertice:"));
		}
		
		for(int i=1;i<=te;i++) {
			x[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
			y[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
		}
		
		for(int i=1;i<=t;i++) {
			representacao += "\n";
			for(int j=1;j<=t;j++) {
				
				boolean verf = false;
				
				for(int k=1;k<=te;k++) {
					if((x[k]==i && y[k]==j)||(x[k]==j && y[k]==i)) //verf == false
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
	
	public void RepresentacaoMatrizOrdenada(int v, int e) {

		int t = v++; //ajustar os valore, t = tamnho v
		int te = e++; //ajustar os valore, te = tamnho e
		
		int matriz [][] = new int [v][v];
		int conjuntoV [] = new int [v];
		int x [] = new int[e];
		int y[] = new int [e];
		String representacao = "";
		
		for(int i=1;i<=t;i++) {
			conjuntoV[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o " + i + "º vertice:"));
		}
		
		for(int i=1;i<=te;i++) {
			x[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
			y[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
		}
		
		for(int i=1;i<=t;i++) {
			representacao += "\n";
			for(int j=1;j<=t;j++) {
				
				boolean verf = false;
				
				for(int k=1;k<=te;k++) {
					if((x[k]==i && y[k]==j)) //verf == false
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
	
	public void representacaoValorado(int v, int e) {
		int t = v++; //ajustar os valore, t = tamnho v
		int te = e++; //ajustar os valore, te = tamnho e
		
		int matriz [][] = new int [v][v];
		int conjuntoV [] = new int [v];
		int x [] = new int[e];
		int y[] = new int [e];
		int valor[] = new int[e];
		String representacao = "";
		
		for(int i=1;i<=t;i++) {
			conjuntoV[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o " + i + "º vertice:"));
		}
		
		for(int i=1;i<=te;i++) {
			x[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
			y[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
			valor[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor da aresta (" + x[i] + ","+y[i]+"):"));
		}
		
		
		// Obter a media dos valores das arestas, e multiplicalas por 10000, dendo um valor de custo muito maior, sendo esta aresta descartada 
		int somatorio = 0;
		int media = 0;
		
		for(int k=1;k<=te;k++) {
			somatorio += valor[k];
		}
		
		media = somatorio/e;
		int vlInfinito = media * 10000;
		
		for(int i=1;i<=t;i++) {
			representacao += "\n";
			for(int j=1;j<=t;j++) {
				
				boolean verf = false;
				int vl= vlInfinito;
				
				for(int k=1;k<=te;k++) {
					if((x[k]==i && y[k]==j)) { //verf == false
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
				
			}
		}
		
		JOptionPane.showMessageDialog(null, representacao);
		
	}
	
	public void representacaoMultigrafo(int v, int e) {
		int t = v++; //ajustar os valore, t = tamnho v
		int te = e++; //ajustar os valore, te = tamnho e
		
		int matriz [][] = new int [v][v];
		int conjuntoV [] = new int [v];
		int x [] = new int[e];
		int y[] = new int [e];
		int nAresta[] = new int[e];
		String representacao = "";
		
		for(int i=1;i<=t;i++) {
			conjuntoV[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o " + i + "º vertice:"));
		}
		
		for(int i=1;i<=te;i++) {
			x[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
			y[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro label do conjunto " + i + ":"));
			nAresta[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de arestas par este conjunto (" + x[i] + ","+y[i]+"):"));
		}
		
		for(int i=1;i<=t;i++) {
			representacao += "\n";
			for(int j=1;j<=t;j++) {
				
				boolean verf = false;
				int vl=0;
				
				for(int k=1;k<=te;k++) {
					if((x[k]==i && y[k]==j)) { //verf == false
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
		
		JOptionPane.showMessageDialog(null, representacao);
		
	}

}
