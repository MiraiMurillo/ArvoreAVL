package br.com.prof.listas;

public class Pilha extends Lista {
	
	public Pilha() {
		super("Stack - pilha");
	}

	public static void empilha(Object object) {
		insereNoFim(object);
	}

	public static Object desempilha() throws EmptyListException {
		return removeNoFim();
	}
}