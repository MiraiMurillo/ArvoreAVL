package br.com.arvoreAVL;

import reciclagem.ListaTeste;
import reciclagem.PilhaTeste;

public class Principal {

	public static void main(String[] args) {

		String[] leitura = Leia.profs("./arq/professores.csv");

		// testando vetor
		// for (int i = 0; i < leitura.length; i++) {

		// System.out.println(leitura[i]);
		// }

		// testando lista
		//ListaTeste.listas(leitura);

		// testando saida
		// Saida.metodoPorScan(leitura);

		//PilhaTeste.PT(leitura);

	}
}
