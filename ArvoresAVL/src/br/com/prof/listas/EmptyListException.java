package br.com.prof.listas;

import java.io.Serial;

public class EmptyListException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    // construtor de um argumento
    public EmptyListException(String name) {
        super("A lista: " + name + " - est� vazia"); // chama construtor de superclasse
    }// fim do construtor de um argumento EmptyException
} // fim da classe EmptyListException