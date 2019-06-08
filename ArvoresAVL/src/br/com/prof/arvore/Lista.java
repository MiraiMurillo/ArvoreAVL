package br.com.prof.arvore;

//definicao da classe List
public class Lista {
	private static ListaNo primeiroNo;// Declara variavel de instancia com o nome de
	// PrimeiroN�
	private static ListaNo ultimoNo;// Declara variavel de instancia com o nome de
	// UltimoN�
	private String nome; // String como 'lista' usada na impressao

	private static int tamanhoLista;
	private Object aux;
	private ListaNo a;

	// construtor cria List vazia com 'list' como o nome
	public Lista() {
		this("Lista");
		Lista.tamanhoLista = 0;
	}// fim do construtor sem argumentos List

	// construtor cria uma List vazia com um nome
	public Lista(String nomeDaLista) {
		nome = nomeDaLista;
		primeiroNo = ultimoNo = null;
		Lista.tamanhoLista = 0;
	}// fim do construtor de um argumento List
		// Insere Object na frente de List

	public void insereNoInicio(Object insertItem) {
		if (estaVazia()) { // first e lastNode referenciam o mesmo objeto
			primeiroNo = ultimoNo = new ListaNo(insertItem);
		} else {
			primeiroNo = new ListaNo(insertItem, primeiroNo);
		} // fim do m�todo insereNoInicio

		Lista.tamanhoLista++;
	}// fim do m�todo insereNoInicio

	// insere Object no fim de Lista
	public static void insereNoFim(Object insertItem) {
		if (estaVazia()) {
			primeiroNo = ultimoNo = new ListaNo(insertItem);
		} else {
			ultimoNo = ultimoNo.proximoNo = new ListaNo(insertItem);
		}
		tamanhoLista++;
	}// fim do m�todo insereNoFim

	// Insere na posi��o informada

	/*
	 * public void insertAtPosicao(int posicao, Object elemento) throws Exception {
	 * if (posicao >= getTamanhoLista()) { throw new Exception("Erro: Lista Cheia");
	 * } setAux(new Object()); setAux(getUltimoNo()); setA(getUltimoNo());
	 * for(getA(); getA() != posicao; a--) {
	 * 
	 * } }
	 */
	// remove o primeiro n� de List
	public Object removeNoInicio() throws EmptyListException {
		if (estaVazia()) {
			throw new EmptyListException(nome);
		}
		Object removedItem = primeiroNo.data; // recupera dados sendo removidos
		// atualiza refer�ncias primeiroNo e ultimoNo
		if (primeiroNo == ultimoNo) {
			primeiroNo = ultimoNo = null;
		} else {
			primeiroNo = primeiroNo.proximoNo;
		}
		Lista.tamanhoLista--;
		return removedItem;// retorna dados de n� removidas
	}// fim do m�todo removeNoFim

	public Object removeNoFim() throws EmptyListException {
		if (estaVazia()) {
			throw new EmptyListException(nome); // lan�a excess�o se List estiver vazia
		}

		Object removedItem = ultimoNo.data; // recupera dados sendo removidos

		// atualiza refer�ncias primeiroNo e ultimoNo

		if (primeiroNo == ultimoNo) {
			primeiroNo = ultimoNo = null;
		}

		else { // localiza o novo �ltimo n�
			ListaNo current = primeiroNo;

			// faz loop enquanto n� atual n�o referencia lastNode
			while (current.proximoNo != ultimoNo) {
				current = current.proximoNo;
			}

			ultimoNo = current; // atual � novo lastNode
			current.proximoNo = null;
		} // fim do else

		Lista.tamanhoLista--;
		return removedItem; // retorna dados de n� removidos
	}// fim do m�todo removeNoFim

	/*
	 * public Object removeFromPosicao(int posicao) throws EmptyListException {
	 * 
	 * 
	 * return null; }
	 */

	/*
	 * public boolean buscaElemento(Object elemento) {
	 * 
	 * }
	 */

	// Determina se a lista estiver vazia
	public static boolean estaVazia() {
		return primeiroNo == null; // retorna true se List estiver vazia
	}// fim do m�todo estaVazia
		// gera sa�da do conte�do de List

	public void print() {
		if (estaVazia()) {
			System.out.printf("Lista Vazia %s\n", nome);
			System.out.println(imprimeTamanho());
			return;
		} // fim do if

		System.out.printf("\nA lista %s �: ", nome);
		ListaNo current = primeiroNo;
		// enquanto n�o estiver no fim da lista, gera sa�da dos dados do n�
		// atual
		while (current != null) {
			System.out.printf("%s -> ", current.data);
			current = current.proximoNo;
		} // fim do While
		System.out.printf("\n");
		System.out.println(imprimeTamanho());
	} // fim do m�todo print

	public String imprimeTamanho() {
		return "Tamanho da Lista: " + Lista.tamanhoLista;
	}

	public static ListaNo getPrimeiroNo() {
		return primeiroNo;
	}

	public static void setPrimeiroNo(ListaNo primeiroNo) {
		Lista.primeiroNo = primeiroNo;
	}

	public static ListaNo getUltimoNo() {
		return ultimoNo;
	}

	public static void setUltimoNo(ListaNo ultimoNo) {
		Lista.ultimoNo = ultimoNo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static int getTamanhoLista() {
		return tamanhoLista;
	}

	public static void setTamanhoLista(int tamanhoLista) {
		Lista.tamanhoLista = tamanhoLista;
	}

	public Object getAux() {
		return aux;
	}

	public void setAux(Object aux) {
		this.aux = aux;
	}

	public ListaNo getA() {
		return a;
	}

	public void setA(ListaNo a) {
		this.a = a;
	}
}// fim da classe List
