package br.com.prof.listas;

public class Fila extends Lista {

    public Fila() {
        super("Queue - Fila");
    }

    public void enfileira(Object object) {
        insereNoFim(object);
    }

    public Object desenfileira() throws EmptyListException {
        return removeNoInicio();
    }
}