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

	public static void removeDaFila() {
		try {
			Object removedObject;
			while (!Fila.estaVazia()) {
				removedObject = Fila.desenfileira();
				System.out.printf("%s saiu da Fila, próximo poderá ser atendido\n", removedObject);
				Lista.print();
			}
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
	}
}