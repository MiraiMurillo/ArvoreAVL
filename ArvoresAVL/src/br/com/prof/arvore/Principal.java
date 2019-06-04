package br.com.prof.arvore;

import java.util.Scanner;

public class Principal {

	private static Scanner entrada;

	public static void main(String[] args) {

		entrada = new Scanner(System.in);

		Lista list = new Lista();
		Pilha stack = new Pilha();
		Fila queue = new Fila();

		int cod;
		String elem;

		// insere na lista

		System.out.println("\n--Lista--");
		System.out.println("\n--Inser��o--");

		do {
			do {
				System.out.println("\nDeseja Inserir?\n0 - N�o/Pular\n1 - Inicio\n2 - Fim");
				cod = entrada.nextInt();
				if (cod < 0 || cod > 2) {
					System.out.println("\nC�digo inv�lido.");
				}
			} while (cod < 0 || cod > 2);
			if (cod == 1) {
				System.out.println("\nQual elemento deseja inserir? ");
				elem = entrada.next();
				list.insereNoInicio(elem);
				list.print();
			} else if (cod == 2) {
				System.out.println("\nQual elemento deseja inserir? ");
				elem = entrada.next();
				list.insereNoFim(elem);
				list.print();
			}
		} while (cod != 0);

		// remove objetos da lista; imprime depois de cada remo��o
		try {
			Object removedObject;
			System.out.println("\n--Remo��o--");
			do {
				if (list.estaVazia()) {
					System.out.println("A Lista Est� Vazia.");
					cod = 0;
				} else if (!list.estaVazia()) {
					do {
						System.out.println("\nDeseja Remover?\n0 - N�o/Pular\n1 - No Inicio\n2 - No Fim");
						cod = entrada.nextInt();
						if (cod < 0 || cod > 2) {
							System.out.println("\nC�digo inv�lido.");
						}
					} while (cod < 0 || cod > 2);

					if (cod == 1) {
						System.out.println();
						removedObject = list.removeNoInicio();
						System.out.printf("%s removido\n", removedObject);
						list.print();
					} else if (cod == 2) {
						System.out.println();
						removedObject = list.removeNoFim();
						System.out.printf("%s removido\n", removedObject);
						list.print();
					}
				}
			} while (cod != 0);

		} // fim do try
		catch (EmptyListException e) {
			e.printStackTrace();
		} // fim do catch

		// fila
		System.out.println("--Fila--");
		System.out.println("--Inser��o--");
		// utiliza o m�todo enqueue
		do {
			do {
				System.out.println("\nDeseja Inserir?\n0 - N�o/Pular\n1 - Sim");
				cod = entrada.nextInt();
				if (cod < 0 || cod > 2) {
					System.out.println("\nC�digo inv�lido.");
				}
			} while (cod < 0 || cod > 2);
			if (cod == 1) {
				System.out.println("Qual elemento deseja Inserir?");
				elem = entrada.next();
				queue.enfileira(elem);
				queue.print();
			}
		} while (cod == 1);

		// remove os objetos da fila
		try {
			Object removedObject;
			while (!queue.imprimeTamanho().equals("Tamanho da Lista: 0")) {
				removedObject = queue.desenfileira();// utiliza m�todo dequeue
				System.out.printf("%s saiu da Fila, pr�ximo poder� ser atendido\n", removedObject);
				queue.print();
			} // fim do while
		} // fim de try
		catch (EmptyListException e) {
			e.printStackTrace();// imprime a pilha de erros
		} // fim do catch

		System.out.println("--Pilha--");
		System.out.println("--Inser��o--");

		do {
			System.out.println("Deseja Inserir?\n0 - N�o/Pular\n1 - Sim");
			if (cod == 1) {
				System.out.println("Qual elemento deseja inserir? ");
				elem = entrada.next();
				stack.empilha(elem);
				stack.print();
			}
		} while (cod == 1);
		// utliza m�todo push

		// remove itens da pilha
		try {
			Object removedObject = null;
			while (!stack.imprimeTamanho().equals("Tamanho da Lista: 0")) {
				removedObject = stack.desempilha();// utiliza o m�todo pop
				System.out.printf("%s removido da pilha\n", removedObject);
				stack.print();
			} // fim do While
		} // fim do trry
		catch (EmptyListException e) {
			e.printStackTrace();
		} // fim do catch
	}
}
