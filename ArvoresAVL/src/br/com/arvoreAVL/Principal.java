package br.com.arvoreAVL;

public class Principal {

	
	public static void main(String[] args) {

		
			String [] leitura = Leia.profs("./arq/professores.csv");
			
			
			//testando vetor
			for (int i = 0; i < leitura.length; i++) {
				
				System.out.println(leitura[i]);
			}
		
			//testando saida
			Saida.metodoPorScan(leitura);
		
		
		
		}
	}
