package br.com.arvoreAVL;

import reciclagem.ListaTeste;
import reciclagem.PilhaTeste;

public class Principal {

	private static String[] leituras;

	public static void main(String[] args) {

		setLeituras(Leia.profs("./arq/professores.csv"));

		// testando vetor
		// for (int i = 0; i < leitura.length; i++) {

		// System.out.println(leitura[i]);
		// }

		// testando lista
		// ListaTeste.listas(leitura);

		// testando saida
		// Saida.metodoPorScan(leitura);

		// PilhaTeste.PT(leitura);

	}

	public static String[] getLeituras() {
		return leituras;
	}

	public static void setLeituras(String[] leituras) {
		Principal.leituras = leituras;
	}
}
