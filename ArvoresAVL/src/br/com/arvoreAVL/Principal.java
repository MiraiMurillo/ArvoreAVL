package br.com.arvoreAVL;

import reciclagem.FilaTeste;
import reciclagem.ListaTeste;
import reciclagem.PilhaTeste;

public class Principal {

	private static String[] leitura;
	private static ArvoreAvl arv = new ArvoreAvl();

	public static void main(String[] args) {

		setLeitura(Leia.profs("./arq/professores.csv"));

		// testando lista
		ListaTeste.listas(getLeitura());

		// testando saida
		// Saida.metodoPorScan(leitura);

		PilhaTeste.PT(getLeitura());

		// testando filas
		FilaTeste.filas(getLeitura());

		for (int i = 0; i < leitura.length - 1; i++) {
			arv.inserir(ComparadorDeStrings.comparadorDeStrings(leitura[i], leitura[i + 1]));
		}
		for (No i : arv.inorder()) {
			System.out.println(i);
		}
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
