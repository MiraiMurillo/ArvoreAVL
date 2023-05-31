package br.com.testes;

import br.com.arvoreAVL.Leia;
import br.com.prof.listas.EmptyListException;
import br.com.prof.listas.Fila;

import java.util.ArrayList;

public class FilaTeste {
    private static final ArrayList<String> leitura = Leia.profs();
    private static final Fila fila = new Fila();

    public static void filas() {
        for (String nome : leitura) {
            fila.enfileira(nome);
            fila.print();
        }
    }

    public static void removeDaFila() {
        try {
            Object removedObject;
            while (!fila.estaVazia()) {
                removedObject = fila.desenfileira();
                System.out.printf("%s saiu da Fila, próximo poderá ser atendido\n", removedObject);
                fila.print();
            }
        } catch (EmptyListException e) {
            e.printStackTrace();
        }
    }
}