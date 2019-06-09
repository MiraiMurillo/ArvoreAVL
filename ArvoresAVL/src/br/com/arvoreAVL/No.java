package br.com.arvoreAVL;

public class No {
	private No esquerda;
	private No direita;
	private No pai;
	private String chave;
	private int balanceamento;
	@SuppressWarnings("unused")
	private String[] sai;
	@SuppressWarnings("unused")
	private String nome;
	public String item;

	public void LerArq(String nomeArquivo) {
		nome = nomeArquivo;
	}

	public No(String k) {
		setEsquerda(setDireita(setPai(null)));
		setBalanceamento(0);
		setChave(k);
	}

	public String toString() {
		return getChave();
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

	public No getPai() {
		return pai;
	}

	public No setPai(No pai) {
		this.pai = pai;
		return pai;
	}

	public No getDireita() {
		return direita;
	}

	public No setDireita(No direita) {
		this.direita = direita;
		return direita;
	}

	public No getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}
}