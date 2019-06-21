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
		try {
			Object removedObject = null;
			while (!Pilha.imprimeTamanho().equals("Tamanho da Lista: 0")) {
				removedObject = Pilha.desempilha();
				System.out.printf("%s removido da pilha\n", removedObject);
				Pilha.print();
			}
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
	}
}