package br.com.arvoreAVL;

import reciclagem.FilaTeste;
import reciclagem.ListaTeste;
import reciclagem.PilhaTeste;

public class Principal {

	private static String[] leitura;

	public static void main(String[] args) {

		setLeituras(Leia.profs("./arq/professores.csv"));

		// testando lista
		ListaTeste.listas(leitura);

		// testando saida
		// Saida.metodoPorScan(leitura);

		PilhaTeste.PT(leitura);

		// testando filas
		FilaTeste.filas(getLeituras());

	}

	public static String[] getLeituras() {
		return leitura;
	}

	public static void setLeituras(String[] leituras) {
		Principal.leitura = leituras;
	}
}
