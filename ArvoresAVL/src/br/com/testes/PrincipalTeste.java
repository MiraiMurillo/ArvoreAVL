package br.com.testes;

import br.com.prof.listas.EmptyListException;
import br.com.prof.listas.Fila;
import br.com.prof.listas.Lista;
import br.com.prof.listas.Pilha;

import java.util.Scanner;

public class PrincipalTeste {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int cod;
        do {
            Lista lista = new Lista();
            Fila fila = new Fila();
            Pilha pilha = new Pilha();

            // insere na lista
            System.out.println("--Lista--\n--Inserção--");

            String elem;
            do {
                do {
                    System.out.println("\nDeseja Inserir?\n0 - Não/Pular\n1 - No Inicio\n2 - No Fim");
                    cod = entrada.nextInt();
                    if (cod < 0 || cod > 2) {
                        System.out.println("\nCódigo inválido.");
                    }
                } while (cod < 0 || cod > 2);
                System.out.println("\nQual elemento deseja inserir? ");
                elem = entrada.next();
                if (cod == 1) {
                    lista.insereNoInicio(elem);
                    lista.print();
                } else if (cod == 2) {
                    lista.insereNoFim(elem);
                    lista.print();
                }
                if (cod == 0 && !lista.estaVazia()) {
                    lista.print();
                }
            } while (cod != 0);

            // remove objetos da lista; imprime depois de cada remoção
            try {
                Object removedObject = null;
                System.out.println("\n--Remoção--");
                do {
                    if (lista.estaVazia()) {
                        System.out.println("A Lista Está Vazia.");
                        cod = 0;
                    } else {
                        do {
                            System.out.println("\nDeseja Remover?\n0 - Não/Pular\n1 - No Inicio\n2 - No Fim");
                            cod = entrada.nextInt();
                            if (cod < 0 || cod > 2) {
                                System.out.println("\nCódigo inválido.");
                            }
                        } while (cod < 0 || cod > 2);

                        if (cod == 1) {
                            removedObject = lista.removeNoInicio();
                        } else if (cod == 2) {
                            removedObject = lista.removeNoFim();

                        }
                        System.out.printf("\n%s removido\n", removedObject);
                        lista.print();
                    }
                } while (cod != 0);

            } // fim do try
            catch (EmptyListException e) {
                e.printStackTrace();
            } // fim do catch

            // fila
            System.out.println("\n--Fila--\n--Inserção--");
            // utiliza o método enFila
            do {
                do {
                    System.out.println("\nDeseja Inserir?\n0 - Não/Pular\n1 - Sim");
                    cod = entrada.nextInt();
                    if (cod < 0 || cod > 1) {
                        System.out.println("\nCódigo inválido.");
                    }
                } while (cod < 0 || cod > 1);
                if (cod == 1) {
                    System.out.println("\nQual elemento deseja Inserir?");
                    elem = entrada.next();
                    fila.enfileira(elem);
                    fila.print();
                }
            } while (cod == 1);

            // remove os objetos da fila
            try {
                Object removedObject;
                if (!fila.estaVazia()) {
                    System.out.println("\n--Remoção--");
                    while (!(fila.getTamanhoLista() == 0)) {
                        removedObject = fila.desenfileira();// utiliza método deFila
                        System.out.printf("\n%s saiu da Fila, próximo poderá ser atendido\n", removedObject);
                        fila.print();
                    } // fim do while
                }
            } // fim de try
            catch (EmptyListException e) {
                e.printStackTrace();// imprime a pilha de erros
            } // fim do catch

            System.out.println("\n--Pilha--\nInserção");

            do {
                do {
                    System.out.println("\nDeseja Inserir?\n0 - Não/Pular\n1 - Sim");
                    cod = entrada.nextInt();
                    if (cod < 0 || cod > 1) {
                        System.out.println("\nCódigo inválido.");
                    }
                } while (cod < 0 || cod > 1);
                if (cod == 1) {
                    System.out.println("\nQual elemento deseja inserir? ");
                    elem = entrada.next();
                    pilha.empilha(elem);
                    pilha.print();
                } else if (!pilha.estaVazia()) {
                    pilha.print();
                }
            } while (cod == 1);
            // utliza método push

            // remove itens da pilha
            try {
                Object removedObject;
                System.out.println("\n--Remoção--");
                while (!(pilha.getTamanhoLista() == 0)) {
                    removedObject = pilha.desempilha();// utiliza o método pop
                    System.out.printf("\n%s removido da pilha\n", removedObject);
                    pilha.print();
                } // fim do While
            } // fim do try
            catch (EmptyListException e) {
                e.printStackTrace();
            } // fim do catch
            do {
                System.out.println("Deseja Reutilizar O Programa?\n1 - Sim\n2 - Não");
                cod = entrada.nextInt();
                if (cod < 1 || cod > 2) {
                    System.out.println("\nCódigo inválido.");
                }
            } while (cod < 1 || cod > 2);
            if (cod == 1) {
                System.out.println();
            }
        } while (cod == 1);

        System.out.println("\n-- Obrigado por testar ;D --");
    }
}
