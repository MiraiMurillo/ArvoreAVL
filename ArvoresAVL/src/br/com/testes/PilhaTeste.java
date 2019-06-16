package br.com.testes;

import java.util.ArrayList;

import br.com.prof.listas.EmptyListException;
import br.com.prof.listas.Pilha;

public class PilhaTeste {

	private static int i;
	private static Pilha stack = new Pilha();

	public static void pilhas(ArrayList<String> arrayList) {
		for (String nome : arrayList) {
			getStack().empilha(nome);
			getStack().print();
		}
	}

	public static void PT() {

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

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		PilhaTeste.i = i;
	}

	public static Pilha getStack() {
		return stack;
	}

	public static void setStack(Pilha stack) {
		PilhaTeste.stack = stack;
	}
}// fim da classe StackInheritanceTest