package br.com.testes;

import java.util.ArrayList;

import br.com.prof.listas.EmptyListException;
import br.com.prof.listas.Lista;

public class ListaTeste {

	public static void listas(ArrayList<String> Leitura) {
		for (String nome : Leitura) {
			Lista.insereNoFim(nome);
			Lista.print();
		}
	}

	public static void retirardalistas() {
		try {
			Object removedObject = Lista.removeNoInicio();
			while (Lista.getTamanhoLista() > 0) {
				removedObject = Lista.removeNoFim();
				System.out.printf("\n%s removido\n", removedObject);
				Lista.print();
			}
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
	}
}