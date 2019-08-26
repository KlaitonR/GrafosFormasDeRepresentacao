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
				
				for(int k=1;k<=t;k++) {
					
					if((conjuntoV[i]==origem[j]) || (conjuntoV[i]==destino[j])) {
						verf = true;
					}
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

}
