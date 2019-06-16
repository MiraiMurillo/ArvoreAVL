package br.com.prof.listas;

public class Fila extends Lista {

	// contrutor sem argumento
	public Fila() {
		super("Queue - Fila");
	}// fim do construtor sem argumento Fila
		// adiciona o objeto à fila

	public void enfileira(Object object) {
		insereNoFim(object);
	}// fim do método enfileira
		// remove o objeto da fila

	public Object desenfileira() throws EmptyListException {
		return removeNoInicio();
	}// fim do método desenfileira
		// determina se a fila está vazia

} // fim da classe Fila