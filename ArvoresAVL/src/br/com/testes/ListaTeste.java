package br.com.testes;

import br.com.prof.listas.EmptyListException;
import br.com.prof.listas.Lista;

import java.util.ArrayList;

public class ListaTeste {
    static Lista lista = new Lista();

    public static void listas(ArrayList<String> Leitura) {
        for (String nome : Leitura) {
            lista.insereNoFim(nome);
            lista.print();
        }
    }

    public static void retirardalistas() {
        try {
            Object removedObject;
            while (lista.getTamanhoLista() > 0) {
                removedObject = lista.removeNoFim();
                System.out.printf("\n%s removido\n", removedObject);
                lista.print();
            }
        } catch (EmptyListException e) {
            e.printStackTrace();
        }
    }
}