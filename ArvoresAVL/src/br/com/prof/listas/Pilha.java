package br.com.prof.listas;

public class Pilha extends Lista {
	public Pilha() {
		super("stack - pilha");
	}// fim do construtor sem argumento StackInheritance
		// adiciona objeto à pilha

	public void empilha(Object object) {
		insereNoFim(object);
	}// fim do método push
		// remove objeto da pilha

	public Object desempilha() throws EmptyListException {
		return removeNoFim();
	}// fim do método pop
}// fim da classe StackInheritance