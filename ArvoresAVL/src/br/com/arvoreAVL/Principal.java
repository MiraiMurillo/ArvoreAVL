package br.com.arvoreAVL;

import reciclagem.FilaTeste;
import reciclagem.ListaTeste;
import reciclagem.PilhaTeste;

public class Principal {

	private static String[] leitura;
	private static ArvoreAvl arv = new ArvoreAvl();

	public static void main(String[] args) {

		setLeituras(Leia.profs("./arq/professores.csv"));

		// testando lista
		ListaTeste.listas(leitura);

		// testando saida
		// Saida.metodoPorScan(leitura);

		PilhaTeste.PT(leitura);

		// testando filas
		FilaTeste.filas(getLeituras());

		for (int i = 0; i < leitura.length - 1; i++) {
			setArv(arv.raiz, comparadorDeStrings(leitura[i], leitura[i + 1]));
		}

	}

	private static void setArv(No raiz, No comparadorDeStrings) {
		
	}

	public static No comparadorDeStrings(String s1, String s2) {

		System.out.println("\nComparando \"" + s1 + "\" a \"" + s2 + "\"...");

		int comparisonResult = s1.compareTo(s2);

		System.out.println("\nO resultado da ComparaÁ„o foi: " + comparisonResult);
		System.out.print("\nIsto significa que \"" + s1 + "\" ");

		if (comparisonResult < 0) {
			System.out.println("\nLexicograficamente vem antes de \"" + s2 + "\".");
		} else if (comparisonResult > 0) {
			System.out.println("\nLexicograficamente vem depois de \"" + s2 + "\".");
		} else {
			System.out.println("\n… igual \"" + s2 + "\".");
		}
		System.out.println();

		No oito = new No(comparisonResult);
		return oito;
	}

	public static String[] getLeituras() {
		return leitura;
	}

	public static void setLeituras(String[] leituras) {
		Principal.leitura = leituras;
	}

	public static String[] getLeitura() {
		return leitura;
	}

	public static void setLeitura(String[] leitura) {
		Principal.leitura = leitura;
	}

	public static ArvoreAvl getArv() {
		return arv;
	}

	public static void setArv(ArvoreAvl arv) {
		Principal.arv = arv;
	}
}
