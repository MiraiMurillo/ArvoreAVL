package br.com.testes;

import br.com.prof.listas.EmptyListException;
import br.com.prof.listas.Pilha;

import java.util.ArrayList;

public class PilhaTeste {
    static Pilha pilha = new Pilha();

    public static void pilhas(ArrayList<String> arrayList) {
        for (String nome : arrayList) {
            pilha.empilha(nome);
            pilha.print();
        }
    }

    public static void PT() {
        pilha.print();
        try {
            Object removedObject;
            while (!pilha.imprimeTamanho().equals("Tamanho da Lista: 0")) {
                removedObject = pilha.desempilha();
                System.out.printf("%s removido da pilha\n", removedObject);
                pilha.print();
            }
        } catch (EmptyListException e) {
            e.printStackTrace();
        }
    }
}