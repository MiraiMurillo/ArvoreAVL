package br.com.arvoreAVL;

public class No {
    private No esquerda = null;
    private No direita = null;
    private No pai = null;
    private String chave;
    private int balanceamento = 0;

    public No(String k) {
        chave = k;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public int getBalanceamento() {
        return balanceamento;
    }

    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }
}