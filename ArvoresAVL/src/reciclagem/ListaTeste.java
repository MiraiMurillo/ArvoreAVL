package reciclagem;

import br.com.prof.arvore.EmptyListException;
import br.com.prof.arvore.Lista;

public class ListaTeste {

	public static void listas(String[] leitura) {

		Lista list = new Lista(); // cria o contêiner de List

		String[] Leitura = leitura;

		for (int i = 0; i < Leitura.length; i++) {

			list.insereNoInicio(Leitura[i]);

		}

		// remove objetos da lista; imprime depois de cada remoção
		try {
			Object removedObject = list.removeNoInicio();

			while (Leitura.length > 1) {
				removedObject = list.removeNoFim();
				System.out.printf("\n%s removido\n", removedObject);
				list.print();
			}

		} // fim do try
		catch (EmptyListException e) {
			e.printStackTrace();
		} // fim do catch

	}// fim de main
}// fim da classe ListTest
