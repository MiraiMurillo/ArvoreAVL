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
		System.out.println("\n--Inserção--");

		do {
			System.out.println("\nDeseja Inserir?\n0 - Não/Pular\n1 - Inicio\n2 - Fim");
			cod = entrada.nextInt();
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
			System.out.println("Deseja Inserir Mais Itens?\n1 - Sim\n2 - Não");
		} while (cod == 1);

		// remove objetos da lista; imprime depois de cada remoção
		try {
			Object removedObject;
			System.out.println("\n--Remoção--");
			do {
				if (list.estaVazia()) {
					System.out.println("A Lista Está Vazia.");
				} else if (!list.estaVazia()) {
					System.out.println("\nDeseja Remover?\n0 - Não/Pular\n1 - Inicio\n2 - Fim");
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
					System.out.println("Deseja Inserir Mais Itens?\n1 - Sim\n2 - Não");
				}
			} while (cod == 1);

		} // fim do try
		catch (EmptyListException e) {
			e.printStackTrace();
		} // fim do catch

		// fila
		System.out.println("--Fila--");
		System.out.println("--Inserção--");
		// utiliza o método enqueue
		do {
			System.out.println("\nDeseja Inserir?\n0 - Não/Pular\n1 - Sim");
			cod = entrada.nextInt();
		} while (cod == 1);
		queue.enfileira(-1);
		queue.print();
		queue.enfileira(0);
		queue.print();
		queue.enfileira(1);
		queue.print();
		queue.enfileira(5);
		queue.print();
		queue.enfileira(7);
		queue.print();
		// remove os objetos da fila
		try {
			Object removedObject;
			while (!queue.imprimeTamanho().equals("Tamanho da Lista: 0")) {
				removedObject = queue.desenfileira();// utiliza método dequeue
				System.out.printf("%s saiu da Fila, próximo poderá ser atendido\n", removedObject);
				queue.print();
			} // fim do while
		} // fim de try
		catch (EmptyListException e) {
			e.printStackTrace();// imprime a pilha de erros
		} // fim do catch

		// utliza método push
		stack.empilha(-1);
		stack.print();
		stack.empilha(0);
		stack.print();
		stack.empilha(1);
		stack.print();
		stack.empilha(5);
		stack.print();
		// remove itens da pilha
		try {
			Object removedObject = null;
			while (!stack.imprimeTamanho().equals("Tamanho da Lista: 0")) {
				removedObject = stack.desempilha();// utiliza o método pop
				System.out.printf("%s removido da pilha\n", removedObject);
				stack.print();
			} // fim do While
		} // fim do trry
		catch (EmptyListException e) {
			e.printStackTrace();
		} // fim do catch
	}

}
