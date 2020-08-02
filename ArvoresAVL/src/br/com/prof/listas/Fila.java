package br.com.prof.listas;

public class Fila extends Lista {

    public Fila() {
        super("Fila");
    }

    public static void enfileira(Object object) {
        insereNoFim(object);
    }

    public static Object desenfileira() throws EmptyListException {
        return removeNoInicio();
    }
}