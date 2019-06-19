package br.com.testes;

import java.util.ArrayList;
import br.com.prof.listas.EmptyListException;
import br.com.prof.listas.Pilha;

public class PilhaTeste {

	public static void pilhas(ArrayList<String> arrayList) {
		for (String nome : arrayList) {
			Pilha.empilha(nome);
			Pilha.print();
		}
	}

	public static void PT() {

		Pilha.print();
		// remove itens da pilha
		try {
			Object removedObject = null;
			while (!Pilha.imprimeTamanho().equals("Tamanho da Lista: 0")) {
				removedObject = Pilha.desempilha();// utiliza o método pop
				System.out.printf("%s removido da pilha\n", removedObject);
				Pilha.print();
			} // fim do While
		} // fim do trry
		catch (EmptyListException e) {
			e.printStackTrace();
		} // fim do catch
	}// fim do main
}// fim da classe StackInheritanceTest