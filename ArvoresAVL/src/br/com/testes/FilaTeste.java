package br.com.testes;

import java.util.ArrayList;

import br.com.prof.listas.EmptyListException;
import br.com.prof.listas.Fila;

public class FilaTeste {

	private static int i;
	private static Fila fila = new Fila(); // cria o cont�iner de List

	public static void filas(ArrayList<String> Leitura) {

		for (String nome : Leitura) {
			getFila().enfileira(nome);
			getFila().print();
		}
	}

	// utiliza o m�todo enqueue

	public static void removeDaFila() {
		// remove os objetos da fila
		try {
			Object removedObject;
			while (!Fila.estaVazia()) {
				removedObject = getFila().desenfileira();// utiliza m�todo dequeue
				System.out.printf("%s saiu da Fila, pr�ximo poder� ser atendido\n", removedObject);
				getFila().print();
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