package br.com.prof.arvore;

public class Pilha extends Lista {
	public Pilha() {
		super("stack - pilha");
	}// fim do construtor sem argumento StackInheritance
		// adiciona objeto � pilha

	public void empilha(Object object) {
		insereNoFim(object);
	}// fim do m�todo push
		// remove objeto da pilha

	public Object desempilha() throws EmptyListException {
		return removeNoFim();
	}// fim do m�todo pop
}// fim da classe StackInheritance