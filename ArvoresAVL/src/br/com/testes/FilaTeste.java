package br.com.testes;

import java.util.ArrayList;

import br.com.prof.listas.EmptyListException;
import br.com.prof.listas.Fila;
import br.com.prof.listas.Lista;

public class FilaTeste {

	public static void filas(ArrayList<String> Leitura) {

		for (String nome : Leitura) {
			Fila.enfileira(nome);
			Lista.print();
		}
	}

	// utiliza o método enqueue

	public static void removeDaFila() {
		// remove os objetos da fila
		try {
			Object removedObject;
			while (!Fila.estaVazia()) {
				removedObject = Fila.desenfileira();// utiliza método dequeue
				System.out.printf("%s saiu da Fila, próximo poderá ser atendido\n", removedObject);
				Lista.print();
			} // fim do while
		} // fim de try
		catch (EmptyListException e) {
			e.printStackTrace();// imprime a pilha de erros
		}
		// fim do catch
	}// fim de main

}// fim da classe QueueTest