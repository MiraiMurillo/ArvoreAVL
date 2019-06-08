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
		// ListaTeste.listas("./arq/professores.csv");

		// testando saida
		// Saida.metodoPorScan(leitura);

		// PilhaTeste.pilhas("./arq/professores.csv");

		// testando filas
		// FilaTeste.filas("./arq/professores.csv");

		/*
		 * for (; cod != 2;) {
		 * System.out.println("\nInforme o número a ser adicionado na árvore: "); cod =
		 * entrada.nextInt(); arv.inserir(cod);
		 * System.out.println("\nDeseja adicionar mais algum número?\n1 - Sim\n2 - Não "
		 * ); cod = entrada.nextInt(); }
		 */

		/*
		 * for (int i = 0; i < Leia.profs("./arq/professores.csv").length - 1; i++) { //
		 * arv.inserir(Leia.profs("./arq/professores.csv")); }
		 *
		 */
		
		arv.inserir2(entrada.nextLine());
		arv.inserir2(entrada.nextLine());
		
		System.out.println(arv.inorder());
		
		
	}

	public static ArvoreAvl getArv() {
		return arv;
	}

	public static void setArv(ArvoreAvl arv) {
		Principal.arv = arv;
	}

	public static Scanner getEntrada() {
		return entrada;
	}

	public static void setEntrada(Scanner entrada) {
		Principal.entrada = entrada;
	}
}
