package reciclagem;

import br.com.prof.arvore.EmptyListException;
import br.com.prof.arvore.Fila;

public class FilaTeste {
	public static void filas(String[] leitura) {
		Fila queue = new Fila();
		
		// utiliza o método enqueue
		
		for (int i = 0; i < leitura.length; i++) {
			
			queue.enfileira(leitura[i]);
		}
	
		
		// remove os objetos da fila
		try {
			Object removedObject;
			while (!queue.imprimeTamanho().equals("Tamanho da Lista: 0")) {
				removedObject = queue.desenfileira();// utiliza método dequeue
				System.out.printf("%s saiu da Fila, próximo poderá ser atendido\n", removedObject);
				queue.print();
			} // fim do while
		} // fim de try
		catch (EmptyListException e) {
			e.printStackTrace();// imprime a pilha de erros
		} 
		// fim do catch
	}// fim de main
}// fim da classe QueueTest