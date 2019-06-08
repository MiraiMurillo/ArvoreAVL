package br.com.arvoreAVL;

import java.util.Scanner;

import reciclagem.FilaTeste;
import reciclagem.ListaTeste;
import reciclagem.PilhaTeste;

public class Principal {

	private static ArvoreAvl arv = new ArvoreAvl();
	private static Scanner entrada = new Scanner(System.in);
	static int cod = 0;

	public static void main(String[] args) {

		// testando lista
		ListaTeste.listas(Leia.profs("./arq/professores.csv"));

		// testando saida
		// Saida.metodoPorScan(leitura);

		PilhaTeste.PT(Leia.profs("./arq/professores.csv"));

		// testando filas
		FilaTeste.filas(Leia.profs("./arq/professores.csv"));

		for (; cod != 2;) {
			System.out.println("\nInforme o número a ser adicionado na árvore: ");
			cod = entrada.nextInt();
			arv.inserir(cod);
			arv.inorder();
			System.out.println("\nDeseja adicionar mais algum número?\n1 - Sim\n2 - Não ");
			cod = entrada.nextInt();
		}

		for (int i = 0; i < Leia.profs("./arq/professores.csv").length - 1; i++) {
			// arv.inserir(Leia.profs("./arq/professores.csv"));
		}
		for (No i : arv.inorder()) {
			System.out.println(i);
		}
	}

	public static ArvoreAvl getArv() {
		return arv;
	}

	public static void setArv(ArvoreAvl arv) {
		Principal.arv = arv;
	}
}
