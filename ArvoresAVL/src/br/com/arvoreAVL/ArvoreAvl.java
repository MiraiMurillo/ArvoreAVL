package br.com.arvoreAVL;

import java.util.ArrayList;

public class ArvoreAvl {

    private No raiz;

    public void inserir(String k) {
        No n = new No(k);
        inserirAVL(raiz, n);
    }

    public void inserirAVL(No aComparar, No aInserir) {
        if (aComparar == null) {
            raiz = aInserir;
            System.out.println("Nome inserido como RAIZ \n" + aInserir.getChave());

        } else {
            if (aInserir.getChave().compareTo(aComparar.getChave()) < 0) {
                if (aComparar.getEsquerda() == null) {
                    aComparar.setEsquerda(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);
                    System.out.println(" \nInserindo " + aInserir.getChave() + " a esquerda de " + aComparar.getChave());

                    System.out.println("Raiz: " + raiz.getChave());
                } else {
                    inserirAVL(aComparar.getEsquerda(), aInserir);
                }
            } else if (aInserir.getChave().compareTo(aComparar.getChave()) > 0) {

                if (aComparar.getDireita() == null) {
                    aComparar.setDireita(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);
                    System.out.println("\nInserindo " + aInserir.getChave() + " a direita de " + aComparar.getChave());
                    System.out.println("Raiz: " + raiz.getChave());
                } else {
                    inserirAVL(aComparar.getDireita(), aInserir);
                }
            } else {

                System.out.printf("\nO No %s já existe ", aInserir.getChave());
            }
        }
    }

    public void verificarBalanceamento(No atual) {

        setBalanceamento(atual);

        int balanceamento = atual.getBalanceamento();

        if (balanceamento == -2) {

            if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
                atual = rotacaoDireita(atual);

            } else {
                atual = duplaRotacaoEsquerdaDireita(atual);
            }

        } else if (balanceamento == 2) {

            if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
                atual = rotacaoEsquerda(atual);

            } else {
                atual = duplaRotacaoDireitaEsquerda(atual);
            }
        }

        if (atual.getPai() != null) {
            verificarBalanceamento(atual.getPai());
        } else {
            raiz = atual;
        }
    }

    public void remover(String k) {
        removerAVL(raiz, k);
        System.out.println("\nRemovendo: " + k);
        inorder(1);
    }

    public void removerAVL(No atual, String k) {
        if (atual != null) {

            if (atual.getChave().compareTo(k) > 0) {
                removerAVL(atual.getEsquerda(), k);

            } else if (atual.getChave().compareTo(k) < 0) {
                removerAVL(atual.getDireita(), k);

            } else if (atual.getChave().equals(k)) {
                removerNoEncontrado(atual);
            }
        }
    }

    public void removerNoEncontrado(No aRemover) {
        No r;
        No p;

        if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {
            if (aRemover.getPai() == null) {
                raiz = null;
                return;
            }
            r = aRemover;
        } else {
            r = procura(aRemover.getChave());
            aRemover.setChave(r.getChave());
        }

        if (r.getEsquerda() != null) {
            p = r.getEsquerda();
        } else {
            p = r.getDireita();
        }

        if (p != null) {
            p.setPai(r.getPai());
        }

        if (r.getPai() == null) {
            raiz = p;
        } else {
            if (r == r.getPai().getEsquerda()) {
                r.getPai().setEsquerda(p);
            } else {
                r.getPai().setDireita(p);
            }
            verificarBalanceamento(r.getPai());
        }
    }

    public No rotacaoEsquerda(No inicial) {

        No direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null) {
            inicial.getDireita().setPai(inicial);
        }

        direita.setEsquerda(inicial);
        inicial.setPai(direita);

        if (direita.getPai() != null) {

            if (direita.getPai().getDireita() == inicial) {
                direita.getPai().setDireita(direita);

            } else if (direita.getPai().getEsquerda() == inicial) {
                direita.getPai().setEsquerda(direita);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(direita);

        return direita;
    }

    public No rotacaoDireita(No inicial) {

        No esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null) {
            inicial.getEsquerda().setPai(inicial);
        }

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

        if (esquerda.getPai() != null) {

            if (esquerda.getPai().getDireita() == inicial) {
                esquerda.getPai().setDireita(esquerda);

            } else if (esquerda.getPai().getEsquerda() == inicial) {
                esquerda.getPai().setEsquerda(esquerda);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(esquerda);

        return esquerda;
    }

    public No duplaRotacaoEsquerdaDireita(No inicial) {
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);
    }

    public No duplaRotacaoDireitaEsquerda(No inicial) {
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);
    }

    public No procura(String chave) {
        No atual = raiz;
        while (atual != null) {
            int comparacao = chave.compareTo(atual.getChave());
            if (comparacao == 0) {
                return atual;  // Nó encontrado
            } else if (comparacao < 0) {
                atual = atual.getEsquerda();  // Procurar na subárvore esquerda
            } else {
                atual = atual.getDireita();  // Procurar na subárvore direita
            }
        }
        return null;  // Nó não encontrado
    }


    private int altura(No atual) {
        if (atual == null) {
            return -1;
        }

        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            return 0;

        } else if (atual.getEsquerda() == null) {
            return 1 + altura(atual.getDireita());

        } else if (atual.getDireita() == null) {
            return 1 + altura(atual.getEsquerda());

        } else {
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
        }
    }

    private void setBalanceamento(No no) {
        no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
    }

    final protected ArrayList<No> inorder(int cod) {
        ArrayList<No> ret = new ArrayList<>();
        inorder2(raiz, ret, cod);

        return ret;
    }

    final protected void inorder2(No no, ArrayList<No> lista, int cod) {
        if (no == null) {
            return;
        }

        if (cod == 1) {
            inorder2(no.getEsquerda(), lista, cod);
            lista.add(no);
            inorder2(no.getDireita(), lista, cod);
        } else if (cod == 2) {
            lista.add(no);
            inorder2(no.getEsquerda(), lista, cod);
            inorder2(no.getDireita(), lista, cod);
        } else if (cod == 3) {
            inorder2(no.getEsquerda(), lista, cod);
            inorder2(no.getDireita(), lista, cod);
            lista.add(no);
        }
    }

}