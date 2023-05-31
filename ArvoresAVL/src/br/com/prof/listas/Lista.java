package br.com.prof.listas;

//definicao da classe List
public class Lista {
    private ListaNo primeiroNo;// Declara variavel de instancia com o nome de
    // PrimeiroNó
    private ListaNo ultimoNo;// Declara variavel de instancia com o nome de
    // UltimoNó
    private String nome; // String como 'lista' usada na impressao

    private int tamanhoLista;

    // construtor cria List vazia com 'list' como o nome
    public Lista() {
        this("Lista");
        tamanhoLista = 0;
    }// fim do construtor sem argumentos List

    // construtor cria uma List vazia com um nome
    public Lista(String nomeDaLista) {
        nome = nomeDaLista;
        primeiroNo = ultimoNo = null;
        tamanhoLista = 0;
    }// fim do construtor de um argumento List
    // Insere Object na frente de List

    // insere Object no fim de Lista
    public void insereNoFim(Object insertItem) {
        if (estaVazia()) {
            primeiroNo = ultimoNo = new ListaNo(insertItem);
        } else {
            ultimoNo = ultimoNo.proximoNo = new ListaNo(insertItem);
        }
        tamanhoLista++;
    }// fim do método insereNoFim

    /*
     * public void insertAtPosicao(int posicao, Object elemento) throws Exception {
     * if (posicao >= getTamanhoLista()) { throw new Exception("Erro: Lista Cheia");
     * } setAux(new Object()); setAux(getUltimoNo()); setA(getUltimoNo());
     * for(getA(); getA() != posicao; a--) {
     *
     * } }
     */
    // remove o primeiro nó de List
    public Object removeNoInicio() throws EmptyListException {
        if (estaVazia()) {
            throw new EmptyListException(nome);
        }
        Object removedItem = primeiroNo.data; // recupera dados sendo removidos
        // atualiza referências primeiroNo e ultimoNo
        if (primeiroNo == ultimoNo) {
            primeiroNo = ultimoNo = null;
        } else {
            primeiroNo = primeiroNo.proximoNo;
        }
        tamanhoLista--;
        return removedItem;// retorna dados de nó removidas
    }// fim do método removeNoFim

    // Insere na posição informada

    public Object removeNoFim() throws EmptyListException {
        if (estaVazia()) {
            throw new EmptyListException(nome); // lança excessão se List estiver vazia
        }

        Object removedItem = ultimoNo.data; // recupera dados sendo removidos

        // atualiza referências primeiroNo e ultimoNo

        if (primeiroNo == ultimoNo) {
            primeiroNo = ultimoNo = null;
        } else { // localiza o novo último nó
            ListaNo current = primeiroNo;

            // faz loop enquanto nó atual não referencia lastNode
            while (current.proximoNo != ultimoNo) {
                current = current.proximoNo;
            }

            ultimoNo = current; // atual � novo lastNode
            current.proximoNo = null;
        } // fim do else

        tamanhoLista--;
        return removedItem; // retorna dados de nó removidos
    }// fim do método removeNoFim

    // Determina se a lista estiver vazia
    public boolean estaVazia() {
        return primeiroNo == null; // retorna true se List estiver vazia
    }// fim do método estaVazia

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

    public void print() {
        if (estaVazia()) {
            System.out.printf("\nLista Vazia %s\n", nome);
            System.out.println(imprimeTamanho());
            return;
        } // fim do if

        System.out.printf("\nA lista %s é: ", nome);
        ListaNo current = primeiroNo;
        // enquanto não estiver no fim da lista, gera saída dos dados do nó
        // atual
        while (current != null) {
            System.out.printf("%s -> ", current.data);
            current = current.proximoNo;
        } // fim do While
        System.out.print("\n");
        System.out.println(imprimeTamanho());
    } // fim do método print
    // gera saída do conteúdo de List

    public String imprimeTamanho() {
        return "Tamanho da Lista: " + tamanhoLista;
    }

    public void insereNoInicio(Object insertItem) {
        if (estaVazia()) { // first e lastNode referenciam o mesmo objeto
            primeiroNo = ultimoNo = new ListaNo(insertItem);
        } else {
            primeiroNo = new ListaNo(insertItem, primeiroNo);
        } // fim do método insereNoInicio

        tamanhoLista++;
    }// fim do método insereNoInicio

    public int getTamanhoLista() {
        return tamanhoLista;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}// fim da classe Lista
