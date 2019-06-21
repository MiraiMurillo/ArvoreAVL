package br.com.arvoreAVL;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.testes.FilaTeste;
import br.com.testes.ListaTeste;
import br.com.testes.PilhaTeste;

public class Principal {

	private static ArvoreAvl arv = new ArvoreAvl();
	private static Scanner entrada = new Scanner(System.in);
	private static int opcao = 0;
	private static ArrayList<String> profsara = Leia.profs("./arq/professores.csv");
	private static String nome;

	public static void main(String[] args) {
		System.out.println("Bem vindo ;D ");

		do {

			System.out.println("\nDeseja imprimir a Lista?\n1 - sim\n0 - não");
			setOpcao(getEntrada().nextInt());

			if (getOpcao() != 0) {

				ListaTeste.listas(getProfsara());

				System.out.println("\nDeseja imprimir a saída da Lista?\n1 - sim\n0 - não");
				setOpcao(getEntrada().nextInt());

				if (getOpcao() != 0) {
					ListaTeste.retirardalistas();
				}
			}

			System.out.println("\nDeseja imprimir a Pilha?\n1 - sim\n0 - não");
			setOpcao(getEntrada().nextInt());

			if (getOpcao() != 0) {

				PilhaTeste.pilhas(getProfsara());
				System.out.println("\nDeseja imprimir a saída da Pilha?\n1 - Sim\n0 - Não");
				setOpcao(getEntrada().nextInt());

				if (getOpcao() != 0) {
					PilhaTeste.PT();
				}
			}

			System.out.println("\nDeseja imprimir a Fila?\n1 - sim\n0 - não");
			setOpcao(getEntrada().nextInt());

			if (getOpcao() != 0) {
				FilaTeste.filas(getProfsara());
				System.out.println("\nDeseja imprimir a saída da Fila?\n1 - Sim\n0 - Não");
				setOpcao(getEntrada().nextInt());

				if (getOpcao() != 0) {
					FilaTeste.removeDaFila();
				}
			}

			System.out.println("\nDeseja adicionar Nome Professores à Arvore?\n1 - sim\n0 - não");
			setOpcao(getEntrada().nextInt());

			if (getOpcao() != 0) {

				for (String eita : getProfsara()) {
					getArv().inserir(eita);
				}
				removerdaqui();
			}
			adicionardaqui();

			if (getOpcao() == 1) {
				removerdaqui();
			}

			System.out.println("\nDeseja procurar alguém?\n1 - Sim\n0 - Não");
			setOpcao(getEntrada().nextInt());
			if (getOpcao() != 0) {
				System.out.println("Informe o nome a ser procurado: ");
				setNome(getEntrada().next());
				No nom = new No(getNome());
				getArv().Procura(nom);
			}

			System.out.println("\nDeseja imprimir os elementos?\n1 - Ordem\n2 - PreOrdem\n3 - PosOrdem\n0 - Não");
			getEntrada().nextLine();
			setOpcao(getEntrada().nextInt());

			if (getOpcao() != 0) {

				if (getOpcao() == 1) {
					System.out.println("--Ordem--");
				} else if (getOpcao() == 2) {
					System.out.println("--PreOrdem--");
				} else if (getOpcao() == 3) {
					System.out.println("--PosOrdem--");
				}
				for (No i : arv.inorder(getOpcao())) {
					System.out.println(i);
				}
			}
			System.out.println("\nObrigado por utilizar o sistema ;D");

			System.out.println("\nDeseja reutilizar o programa?\n1 - Sim\n0 - Não");
			setOpcao(getEntrada().nextInt());
		} while (getOpcao() != 0);
	}

	public static void removerdaqui() {
		System.out.println("\nDeseja remover algum nome?\n1 - sim\n0 - não");
		setOpcao(getEntrada().nextInt());

		if (getOpcao() != 0) {
			do {
				System.out.println("\nDigite o nome a ser removido: ");
				setNome(getEntrada().next());

				getArv().Remover(nome);

				System.out.println("\nDeseja remover outro nome?\n1 - sim\n0 - não");
				getEntrada().nextLine();
				setOpcao(getEntrada().nextInt());

			} while (getOpcao() != 0);

		}
	}

	public static void adicionardaqui() {
		System.out.println("\nDeseja adicionar algum nome?\n1 - sim\n0 - não");
		setOpcao(getEntrada().nextInt());

		if (getOpcao() != 0) {
			do {
				System.out.println("\nDigite o nome a ser inserido: ");
				setNome(getEntrada().next());

				getArv().inserir(nome);

				System.out.println("\nDeseja adicionar outro nome?\n1 - sim\n0 - não");
				setOpcao(getEntrada().nextInt());

			} while (getOpcao() != 0);
		}
	}

	public static ArrayList<String> getProfsara() {
		return profsara;
	}

	public static void setProfsara(ArrayList<String> profsara) {
		Principal.profsara = profsara;
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

	public static String getNome() {
		return nome;
	}

	public static void setNome(String nome) {
		Principal.nome = nome;
	}
}
//fim