package br.com.arvoreAVL;

import br.com.testes.FilaTeste;
import br.com.testes.ListaTeste;
import br.com.testes.PilhaTeste;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    private static final ArvoreAvl arv = new ArvoreAvl();
    private static final Scanner entrada = new Scanner(System.in);
    private static final ArrayList<String> profsara = Leia.profs();
    private static int opcao = 0;
    private static String nome;

    public static void main(String[] args) {
        System.out.println("Bem vindo ;D ");

        do {

            System.out.println("\nDeseja imprimir a Lista?\n1 - sim\n0 - não");
            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao != 0) {

                ListaTeste.listas(profsara);

                System.out.println("\nDeseja imprimir a saída da Lista?\n1 - sim\n0 - não");
                opcao = entrada.nextInt();
                entrada.nextLine();

                if (opcao != 0) {
                    ListaTeste.retirardalistas();
                }
            }

            System.out.println("\nDeseja imprimir a Pilha?\n1 - sim\n0 - não");
            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao != 0) {
                PilhaTeste.pilhas(profsara);

                System.out.println("\nDeseja imprimir a saída da Pilha?\n1 - Sim\n0 - Não");
                opcao = entrada.nextInt();
                entrada.nextLine();

                if (opcao != 0) {
                    PilhaTeste.PT();
                }
            }

            System.out.println("\nDeseja imprimir a Fila?\n1 - sim\n0 - não");
            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao != 0) {
                FilaTeste.filas();

                System.out.println("\nDeseja imprimir a saída da Fila?\n1 - Sim\n0 - Não");
                opcao = entrada.nextInt();
                entrada.nextLine();

                if (opcao != 0) {
                    FilaTeste.removeDaFila();
                }
            }

            System.out.println("\nDeseja adicionar Nome Professores à Arvore?\n1 - sim\n0 - não");
            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao != 0) {
                for (String eita : profsara) {
                    arv.inserir(eita);
                }
                removerdaqui();
            }
            adicionardaqui();

            if (opcao == 1) {
                removerdaqui();
            }

            System.out.println("\nDeseja procurar alguém?\n1 - Sim\n0 - Não");
            opcao = entrada.nextInt();
            entrada.nextLine();
            do {
                if (opcao != 0) {
                    System.out.println("Informe o nome a ser procurado: ");
                    nome = entrada.nextLine();

                    No noProcurado = arv.procura(nome);
                    if (noProcurado != null) {
                        System.out.println("Nome encontrado: " + noProcurado.getChave());
                    } else {
                        System.out.println("Nome não encontrado.");
                    }
                    System.out.println("Deseja procurar mais alguém?\n1 - Sim\n0 - Não");
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                }
            } while (opcao != 0);

            System.out.println("\nDeseja imprimir os elementos?\n1 - Ordem\n2 - PreOrdem\n3 - PosOrdem\n0 - Não");
            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao != 0) {

                if (opcao == 1) {
                    System.out.println("--Ordem--");
                } else if (opcao == 2) {
                    System.out.println("--PreOrdem--");
                } else if (opcao == 3) {
                    System.out.println("--PosOrdem--");
                }
                for (No i : arv.inorder(opcao)) {
                    System.out.println(i.getChave());
                }
            }
            System.out.println("\nObrigado por utilizar o sistema ;D");

            System.out.println("\nDeseja reutilizar o programa?\n1 - Sim\n0 - Não");
            opcao = entrada.nextInt();
            entrada.nextLine();
        } while (opcao != 0);
    }

    public static void removerdaqui() {
        System.out.println("\nDeseja remover algum nome?\n1 - sim\n0 - não");
        opcao = entrada.nextInt();
        entrada.nextLine();

        if (opcao != 0) {
            do {
                System.out.println("\nDigite o nome a ser removido: ");
                nome = entrada.nextLine();

                arv.remover(nome);

                System.out.println("\nDeseja remover outro nome?\n1 - sim\n0 - não");
                opcao = entrada.nextInt();
                entrada.nextLine();

            } while (opcao != 0);

        }
    }

    public static void adicionardaqui() {
        System.out.println("\nDeseja adicionar algum nome?\n1 - sim\n0 - não");
        opcao = entrada.nextInt();
        entrada.nextLine();

        if (opcao != 0) {
            do {
                System.out.println("\nDigite o nome a ser inserido: ");
                do {
                    nome = entrada.nextLine();
                } while (nome.isBlank());

                arv.inserir(nome);

                System.out.println("\nDeseja adicionar outro nome?\n1 - sim\n0 - não");
                opcao = entrada.nextInt();
                entrada.nextLine();

            } while (opcao != 0);
        }
    }

}
//fim