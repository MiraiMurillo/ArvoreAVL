package br.com.testes;

import java.util.ArrayList;

import br.com.prof.listas.EmptyListException;
import br.com.prof.listas.Lista;

public class ListaTeste {

	private static int i;
	private static Lista list = new Lista(); // cria o contêiner de List

	public static void listas(ArrayList<String> Leitura) {

		for (String nome : Leitura) {
			Lista.insereNoFim(nome);
			getList().print();
		}
	}

	// remove objetos da lista; imprime depois de cada remoção
	public static void retirardalistas() {
		try {
			Object removedObject = list.removeNoInicio();

			while (list.getTamanhoLista() > 0) {
				removedObject = list.removeNoFim();
				System.out.printf("\n%s removido\n", removedObject);
				list.print();
			}

		} // fim do try
		catch (EmptyListException e) {
			e.printStackTrace();
		} // fim do catch

	}// fim de main

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		ListaTeste.i = i;
	}

	public static Lista getList() {
		return list;
	}

	public static void setList(Lista list) {
		ListaTeste.list = list;
	}
}// fim da classe ListTest