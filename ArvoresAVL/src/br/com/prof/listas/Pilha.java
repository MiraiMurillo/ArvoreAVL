package br.com.prof.listas;

public class Pilha extends Lista {

    public Pilha() {
        super("Stack - pilha");
    }

    public void empilha(Object object) {
        insereNoFim(object);
    }

    public Object desempilha() throws EmptyListException {
        return removeNoFim();
    }
}