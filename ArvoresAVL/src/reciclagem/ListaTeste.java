package reciclagem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import br.com.prof.arvore.EmptyListException;
import br.com.prof.arvore.Lista;

public class ListaTeste {

	private static int i;
	private static Lista list = new Lista(); // cria o contêiner de List

	public static void listas(String Leitura) {

		try {

			FileReader arquivo = new FileReader(Leitura);

			BufferedReader leitorLinhas = new BufferedReader(arquivo);

			String linha = "";

			linha = leitorLinhas.readLine();

			setI(0);

			while (linha != null) {

				list.insereNoInicio(linha);

				linha = leitorLinhas.readLine();

				setI(getI() + 1);

				list.print();
			}
			arquivo.close();

		} catch (IOException erro) {
			System.out.println("Erro ao ler arquivo: " + erro.getMessage());
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
