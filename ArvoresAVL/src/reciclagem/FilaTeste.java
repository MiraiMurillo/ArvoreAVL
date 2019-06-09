package reciclagem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.com.prof.arvore.EmptyListException;
import br.com.prof.arvore.Fila;

public class FilaTeste {

	private static int i;
	private static Fila fila = new Fila(); // cria o contêiner de List

	public static void filas(String Leitura) {

		try {

			FileReader arquivo = new FileReader(Leitura);

			BufferedReader leitorLinhas = new BufferedReader(arquivo);

			String linha = "";

			linha = leitorLinhas.readLine();

			setI(0);

			while (linha != null) {

				fila.enfileira(linha);

				linha = leitorLinhas.readLine();

				setI(getI() + 1);

				fila.print();
			}
			arquivo.close();

		} catch (IOException erro) {
			System.out.println("Erro ao ler arquivo: " + erro.getMessage());
		}
	}

	// utiliza o método enqueue

	public static void removeDaFila() {
		// remove os objetos da fila
		try {
			Object removedObject;
			while (!fila.imprimeTamanho().equals("Tamanho da Lista: 0")) {
				removedObject = fila.desenfileira();// utiliza método dequeue
				System.out.printf("%s saiu da Fila, próximo poderá ser atendido\n", removedObject);
				fila.print();
			} // fim do while
		} // fim de try
		catch (EmptyListException e) {
			e.printStackTrace();// imprime a pilha de erros
		}
		// fim do catch
	}// fim de main

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		FilaTeste.i = i;
	}

	public static Fila getFila() {
		return fila;
	}

	public static void setFila(Fila fila) {
		FilaTeste.fila = fila;
	}
}// fim da classe QueueTest