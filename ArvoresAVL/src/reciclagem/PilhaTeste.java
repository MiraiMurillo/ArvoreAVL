package reciclagem;

import br.com.prof.arvore.EmptyListException;
import br.com.prof.arvore.Pilha;

public class PilhaTeste {

	static Pilha stack = new Pilha();

	public static void PT(String[] leitura) {

		// utliza método push

		for (int i = 0; i < leitura.length; i++) {
			stack.empilha(leitura[i]);
		}

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
	}// fim do main

	public static void empilha(String[] leitura) {
		// TODO Auto-generated method stub

	}
}// fim da classe StackInheritanceTest