package br.com.prof.listas;

public class Fila extends Lista {

    public Fila() {
        super("Fila");
    }

    public void enfileira(Object object) {
        insereNoFim(object);
    }

    public Object desenfileira() throws EmptyListException {
        return removeNoInicio();
    }
}