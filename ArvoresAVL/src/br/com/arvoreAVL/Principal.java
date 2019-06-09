package br.com.arvoreAVL;

import java.util.Scanner;

import reciclagem.FilaTeste;
import reciclagem.ListaTeste;
import reciclagem.PilhaTeste;

public class Principal {

	private static ArvoreAvl arv = new ArvoreAvl();
	private static Scanner entrada = new Scanner(System.in);
	private static int opcao = 0;
	private static String[] ler = Leia.profs("./arq/professores.csv");

	public static void main(String[] args) {
		System.out.println("Bem vindo ;D ");

		do {
			String nome;

			// Leia.profs("./arq/professores.csv");

			System.out.println("\nDeseja imprimir a Lista?\n1 - sim\n0 - não");
			opcao = entrada.nextInt();

			entrada.nextLine();
			if (opcao != 0) {

				ListaTeste.listas("./arq/professores.csv");

				System.out.println("\nDeseja imprimir a saída da Lista?\n1 - sim\n0 - não");
				opcao = entrada.nextInt();

				entrada.nextLine();
				if (opcao != 0) {
					ListaTeste.retirardalistas();
				}
			}

			System.out.println("\nDeseja imprimir a Pilha?\n1 - sim\n0 - não");
			opcao = entrada.nextInt();

			entrada.nextLine();
			if (opcao != 0) {

				PilhaTeste.pilhas("./arq/professores.csv");
				System.out.println("\nDeseja imprimir a saída da Pilha?\n1 - Sim\n0 - Não");
				opcao = entrada.nextInt();

				entrada.nextLine();
				if (opcao != 0) {
					PilhaTeste.PT();
				}
			}

			System.out.println("\nDeseja imprimir a Fila?\n1 - sim\n0 - não");
			opcao = entrada.nextInt();

			entrada.nextLine();
			if (opcao != 0) {
				FilaTeste.filas("./arq/professores.csv");
				System.out.println("\nDeseja imprimir a saída da Fila?\n1 - Sim\n0 - Não");
				opcao = entrada.nextInt();

				entrada.nextLine();
				if (opcao != 0) {
					FilaTeste.removeDaFila();
				}
			}

			System.out.println("\nDeseja adicionar Nome Professores à Arvore?\n1 - sim\n0 - não");
			opcao = entrada.nextInt();

			entrada.nextLine();
			if (opcao != 0) {

				for (int i = 0; i < Leia.profs("./arq/professores.csv").length - 1; i++) {
					arv.inserir(ler[i]);
					System.out.println(arv.inorder(1));
				}
				System.out.println("\nNomes Professores adicionados a arvore: ");
			}
			System.out.println("\nDeseja adicionar algum nome?\n1 - sim\n0 - não");
			opcao = entrada.nextInt();

			entrada.nextLine();
			if (opcao != 0) {
				do {
					System.out.println("\nDigite o nome a ser inserido: ");
					nome = entrada.next();

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
					nome = entrada.next();
					entrada.nextLine();

					arv.Remover(nome);

					System.out.println("\nDeseja remover outro nome?\n1 - sim\n0 - não");
					opcao = entrada.nextInt();

					entrada.nextLine();
				} while (opcao != 0);

			}
			/*
			 * System.out.println("\nDeseja realizar uma busca?\n1 - sim\n0 - não");
			 * 
			 * opcao = entrada.nextInt(); entrada.nextLine();
			 * 
			 * if (opcao != 0) { do {
			 * System.out.println("\nDigite o elemento a ser buscado: "); nome =
			 * entrada.nextLine();
			 * 
			 * //arv.buscar(nome);
			 * 
			 * System.out.println("\nDeseja buscar outro nome?\n1 - sim\n0 - não"); opcao =
			 * entrada.nextInt();
			 * 
			 * entrada.nextLine(); } while (opcao != 0); }
			 */

			System.out.println("\nDeseja imprimir os elementos?\n1 - Ordem\n2 - PreOrdem\n3 - PosOrdem\n0 - Não");
			opcao = entrada.nextInt();

			entrada.nextLine();
			if (opcao != 0) {
				if (opcao == 1) {
					System.out.println("--Ordem--");
				} else if (opcao == 2) {
					System.out.println("--PreOrdem--");
				} else if (opcao == 3) {
					System.out.println("--PosOrdem--");
				}
				for (No i : arv.inorder(opcao)) {
					System.out.println(i);
				}
			}
			System.out.println("\nObrigado por utilizar o sistema ;D");

			/*
			 * System.out.
			 * println("\nDeseja Salvar o arquivo em .csv?\n1 - Ordem\n2 - PreOrdem\n3 - PosOrdem\n0 - Não"
			 * ); opcao = entrada.nextInt();
			 * 
			 * entrada.nextLine();
			 * 
			 * if (opcao != 0) {
			 * 
			 * Saida.metodoPorScan(arv);
			 * 
			 * System.out.println("\nObrigado por utilizar o sistema ;D"); } else {
			 * 
			 * 
			 * System.out.println("\nObrigado por utilizar o sistema ;D"); }
			 */

			System.out.println("\nDeseja reutilizar o programa?\n1 - Sim\n0 - Não");
			opcao = entrada.nextInt();
		} while (opcao != 0);
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

	public static int getOpcao() {
		return opcao;
	}

	public static void setOpcao(int opcao) {
		Principal.opcao = opcao;
	}
}
//fim