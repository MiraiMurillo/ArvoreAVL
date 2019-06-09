package br.com.arvoreAVL;

import java.util.Scanner;

import reciclagem.FilaTeste;
import reciclagem.ListaTeste;
import reciclagem.PilhaTeste;

public class Principal {

	private static ArvoreAvl arv = new ArvoreAvl();
	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		double finish = 0, start;

		int opcao = 0;

		String nome;

		Leia.profs("./arq/professores.csv");

		String[] ler = Leia.profs("./arq/professores.csv");

		System.out.println("Bem vindo ;D ");

		System.out.println("\nDeseja imprimir a Lista?\n1 - sim\n0 - não");
		opcao = entrada.nextInt();

		entrada.nextLine();

		if (opcao != 0) {

			ListaTeste.listas("./arq/professores.csv");
		}

		System.out.println("\nDeseja imprimir a Pilha?\n1 - sim\n0 - não");
		opcao = entrada.nextInt();

		entrada.nextLine();

		if (opcao != 0) {

			PilhaTeste.pilhas("./arq/professores.csv");
		}

		System.out.println("\nDeseja imprimir a Fila?\n1 - sim\n0 - não");
		opcao = entrada.nextInt();

		entrada.nextLine();

		if (opcao != 0) {

			FilaTeste.filas("./arq/professores.csv");
		}

		System.out.println("\nDeseja adicionar Nome Professores à Arvore?\n1 - sim\n0 - não");
		opcao = entrada.nextInt();

		entrada.nextLine();

		if (opcao != 0) {

			start = System.nanoTime(); // contador nano inicio

			for (int i = 0; i < Leia.profs("./arq/professores.csv").length - 1; i++) {
				arv.inserir(ler[i]);
				System.out.println(arv.inorder());

				finish = System.nanoTime(); // contador nano fim
			}

			System.out.println("\nNomes Professores adicionados a arvore: ");

			System.out.println("\nContagem em Nanosegundos: " + (finish - start));

		}

		System.out.println("\nDeseja adicionar algum nome?\n1 - sim\n0 - não");
		opcao = entrada.nextInt();

		entrada.nextLine();

		if (opcao != 0) {

			do {

				System.out.println("Digite o nome a ser inserido: ");
				nome = entrada.nextLine();

				arv.inserir(nome);

				System.out.println("\nDeseja adicionar outro nome?\n1 - sim\n0 - não");
				opcao = entrada.nextInt();

				entrada.nextLine();

			} while (opcao != 0);

		}

		System.out.println("\nDeseja remover algum nome?\n1 - sim\n0 - não");
		opcao = entrada.nextInt();

		entrada.nextLine();

		if (opcao != 0) {

			do {

				System.out.println("\nDigite o nome a ser removido: ");
				nome = entrada.nextLine();

				arv.Remover(nome);

				System.out.println("\nDeseja remover outro nome?\n1 - sim\n0 - não");
				opcao = entrada.nextInt();

				entrada.nextLine();

			} while (opcao != 0);

		}

		System.out.println("\nDeseja realizar uma busca?\n1 - sim\n0 - não");
		opcao = entrada.nextInt();

		entrada.nextLine();

		if (opcao != 0) {

			do {

				System.out.println("\nDigite o elemento a ser buscado: ");
				nome = entrada.nextLine();

				// arv.buscar(nome);

				System.out.println("\nDeseja buscar outro nome?\n1 - sim\n0 - não");
				opcao = entrada.nextInt();

				entrada.nextLine();

			} while (opcao != 0);

		}

		System.out.println("\nDeseja imprimir os elementos?\n1 - sim\n0 - não");
		opcao = entrada.nextInt();

		entrada.nextLine();

		if (opcao != 0) {
			System.out.println("\nORDEM: ");

			for (No i : arv.inorder()) {
				System.out.println(i);
			}

		} else {

			System.out.println("\nObrigado por utilizar o sistema ;D");
			System.exit(0);
		}

		System.out.println("\nDeseja Salvar o arquivo em .csv?\n1 - sim\n0 - não");
		opcao = entrada.nextInt();

		entrada.nextLine();

		if (opcao != 0) {

			// Saida.metodoPorScan(arv.inorder());

			System.out.println("\nObrigado por utilizar o sistema ;D");
		}

		else {

			System.out.println("\nObrigado por utilizar o sistema ;D");
		}
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
