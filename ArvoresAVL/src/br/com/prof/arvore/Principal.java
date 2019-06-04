package br.com.prof.arvore;

public class Principal {

	public static void main(String[] args) {

		// Lista
		Lista list = new Lista(); // cria o contêiner de List

		// insere inteiros na lista
		list.insereNoInicio(-1);
		list.print();
		list.insereNoInicio(0);
		list.print();
		list.insereNoFim(1);
		list.print();
		list.insereNoFim(5);
		list.print();
		list.insereNoInicio(3);
		list.print();

		// remove objetos da lista; imprime depois de cada remoção
		try {
			Object removedObject = list.removeNoInicio();
			System.out.printf("%s removido\n", removedObject);
			list.print();
			removedObject = list.removeNoInicio();
			System.out.printf("%s removido\n", removedObject);
			list.print();
			removedObject = list.removeNoFim();
			System.out.printf("%s removido\n", removedObject);
			list.print();
			removedObject = list.removeNoFim();
			System.out.printf("%s removido\n", removedObject);
			list.print();
			removedObject = list.removeNoFim();
			System.out.printf("%s removido\n", removedObject);
			list.print();
		} // fim do try
		catch (EmptyListException e) {
			e.printStackTrace();
		} // fim do catch

		// fila
		Fila queue = new Fila();
		// utiliza o método enqueue
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

		Pilha stack = new Pilha();
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
