package br.com.arvoreAVL;

import java.util.ArrayList;

public class ArvoreAvl {

	public No raiz;

	public void inserir(String k) {
		No n = new No(k);
		inserirAVL(this.raiz, n);
	}

	public void inserirAVL(No aComparar, No aInserir) {
		if (aComparar == null) {
			this.raiz = aInserir;
			System.out.println("Nome inserido como RAIZ \n" + aInserir.getChave());

		} else {
			if (aInserir.getChave().compareTo(aComparar.getChave()) < 0) {
				if (aComparar.getEsquerda() == null) {
					aComparar.setEsquerda(aInserir);
					aInserir.setPai(aComparar);
					verificarBalanceamento(aComparar);
					System.out.println(" \nInserindo " + aInserir + " a esquerda de " + aComparar.getChave());
					System.out.println(inorder());
					System.out.println("Raiz: " + raiz);

				} else {
					inserirAVL(aComparar.getEsquerda(), aInserir);
				}
			} else if (aInserir.getChave().compareTo(aComparar.getChave()) > 0) {

				if (aComparar.getDireita() == null) {
					aComparar.setDireita(aInserir);
					aInserir.setPai(aComparar);
					verificarBalanceamento(aComparar);
					System.out.println("\nInserindo " + aInserir + " a direita de " + aComparar.getChave());
					System.out.println(inorder());
					System.out.println("Raiz: " + raiz);
				} else {
					inserirAVL(aComparar.getDireita(), aInserir);
				}
			} else {
				// O n� j� existe
				System.out.println("\nO no j� existe " + aInserir);
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
			this.raiz = atual;
		}
	}

	public void Remover(String k) {
		RemoverAVL(this.raiz, k);
		System.out.println("\nRemovendo: " + k);
		System.out.println(inorder());
		System.out.println("Raiz: " + raiz);
	}

	public void RemoverAVL(No atual, String k) {
		if (atual == null) {
			return;

		} else {

			if (atual.getChave().compareTo(k) > 0) {
				RemoverAVL(atual.getEsquerda(), k);

			} else if (atual.getChave().compareTo(k) < 0) {
				RemoverAVL(atual.getDireita(), k);

			} else if (atual.getChave() == k) {
				removerNoEncontrado(atual);
			}
		}
	}

	public void removerNoEncontrado(No aRemover) {
		No r;

		if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {

			if (aRemover.getPai() == null) {
				this.raiz = null;
				aRemover = null;
				return;
			}
			r = aRemover;

		} else {
			r = sucessor(aRemover);
			aRemover.setChave(r.getChave());
		}

		No p;
		if (r.getEsquerda() != null) {
			p = r.getEsquerda();
		} else {
			p = r.getDireita();
		}

		if (p != null) {
			p.setPai(r.getPai());
		}

		if (r.getPai() == null) {
			this.raiz = p;
		} else {
			if (r == r.getPai().getEsquerda()) {
				r.getPai().setEsquerda(p);
			} else {
				r.getPai().setDireita(p);
			}
			verificarBalanceamento(r.getPai());
		}
		r = null;
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

	public No sucessor(No q) {
		if (q.getDireita() != null) {
			No r = q.getDireita();
			while (r.getEsquerda() != null) {
				r = r.getEsquerda();
			}
			return r;
		} else {
			No p = q.getPai();
			while (p != null && q == p.getDireita()) {
				q = p;
				p = q.getPai();
			}
			return p;
		}
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

	final protected ArrayList<No> inorder() {
		ArrayList<No> ret = new ArrayList<No>();
		inorder2(raiz, ret);

		return ret;
	}

	final protected void inorder2(No no, ArrayList<No> lista) {
		if (no == null) {
			return;
		}

		inorder2(no.getEsquerda(), lista);
		lista.add(no);
		inorder2(no.getDireita(), lista);

	}

}
