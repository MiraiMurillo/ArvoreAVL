package br.com.testes;

import java.util.Scanner;

import br.com.prof.listas.EmptyListException;
import br.com.prof.listas.Fila;
import br.com.prof.listas.Lista;
import br.com.prof.listas.Pilha;

public class PrincipalTeste {

    @SuppressWarnings("static-access")
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int cod;
        do {
            Lista list = new Lista();
            Pilha stack = new Pilha();
            Fila queue = new Fila();

            // insere na lista
            System.out.println("--Lista--");
            System.out.println("--Inserção--");

            String elem;
            do {
                do {
                    System.out.println("\nDeseja Inserir?\n0 - Não/Pular\n1 - No Inicio\n2 - No Fim");
                    cod = entrada.nextInt();
                    if (cod < 0 || cod > 2) {
                        System.out.println("\nCódigo inválido.");
                    }
                } while (cod < 0 || cod > 2);
                if (cod == 1) {
                    System.out.println("\nQual elemento deseja inserir? ");
                    elem = entrada.next();
                    list.insereNoInicio(elem);
                    list.print();
                } else if (cod == 2) {
                    System.out.println("\nQual elemento deseja inserir? ");
                    elem = entrada.next();
                    list.insereNoFim(elem);
                    list.print();
                }
                if (cod == 0 && !list.estaVazia()) {
                    list.print();
                }
            } while (cod != 0);

            // remove objetos da lista; imprime depois de cada remoção
            try {
                Object removedObject;
                System.out.println("\n--Remoção--");
                do {
                    if (list.estaVazia()) {
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
                            System.out.println();
                            removedObject = list.removeNoInicio();
                            System.out.printf("%s removido\n", removedObject);
                            list.print();
                        } else if (cod == 2) {
                            System.out.println();
                            removedObject = list.removeNoFim();
                            System.out.printf("%s removido\n", removedObject);
                            list.print();
                        }
                    }
                } while (cod != 0);

            } // fim do try
            catch (EmptyListException e) {
                e.printStackTrace();
            } // fim do catch

            // fila
            System.out.println("\n--Fila--");
            System.out.println("--Inserção--");
            // utiliza o método enqueue
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
                    queue.enfileira(elem);
                    queue.print();
                }
            } while (cod == 1);

            // remove os objetos da fila
            try {
                Object removedObject;
                if (!queue.estaVazia()) {
                    System.out.println("\n--Remoção--");
                    while (!queue.imprimeTamanho().equals("Tamanho da Lista: 0")) {
                        removedObject = queue.desenfileira();// utiliza método dequeue
                        System.out.printf("\n%s saiu da Fila, próximo poderá ser atendido\n", removedObject);
                        queue.print();
                    } // fim do while
                }
            } // fim de try
            catch (EmptyListException e) {
                e.printStackTrace();// imprime a pilha de erros
            } // fim do catch

            System.out.println("\n--Pilha--");
            System.out.println("--Inserção--");

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
                    stack.empilha(elem);
                    stack.print();
                } else if (!stack.estaVazia()) {
                    stack.print();
                }
            } while (cod == 1);
            // utliza método push

            // remove itens da pilha
            try {
                Object removedObject;
                System.out.println("\n--Remoção--");
                while (!stack.imprimeTamanho().equals("Tamanho da Lista: 0")) {
                    removedObject = stack.desempilha();// utiliza o método pop
                    System.out.printf("\n%s removido da pilha\n", removedObject);
                    stack.print();
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
