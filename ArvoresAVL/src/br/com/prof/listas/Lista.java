package br.com.prof.listas;

//definicao da classe List
public class Lista {
    private static ListaNo primeiroNo;// Declara variavel de instancia com o nome de
    // PrimeiroNó
    private static ListaNo ultimoNo;// Declara variavel de instancia com o nome de
    // UltimoNó
    private static String nome; // String como 'lista' usada na impressao

    private static int tamanhoLista;

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
        } // fim do método insereNoInicio

        Lista.tamanhoLista++;
    }// fim do método insereNoInicio

    // insere Object no fim de Lista
    public static void insereNoFim(Object insertItem) {
        if (estaVazia()) {
            primeiroNo = ultimoNo = new ListaNo(insertItem);
        } else {
            ultimoNo = ultimoNo.proximoNo = new ListaNo(insertItem);
        }
        tamanhoLista++;
    }// fim do método insereNoFim

    // Insere na posição informada

    /*
     * public void insertAtPosicao(int posicao, Object elemento) throws Exception {
     * if (posicao >= getTamanhoLista()) { throw new Exception("Erro: Lista Cheia");
     * } setAux(new Object()); setAux(getUltimoNo()); setA(getUltimoNo());
     * for(getA(); getA() != posicao; a--) {
     *
     * } }
     */
    // remove o primeiro nó de List
    public static Object removeNoInicio() throws EmptyListException {
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
        Lista.tamanhoLista--;
        return removedItem;// retorna dados de nó removidas
    }// fim do método removeNoFim

    public static Object removeNoFim() throws EmptyListException {
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

        Lista.tamanhoLista--;
        return removedItem; // retorna dados de nó removidos
    }// fim do método removeNoFim

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
    }// fim do método estaVazia
    // gera saída do conteúdo de List

    public static void print() {
        if (estaVazia()) {
            System.out.printf("\nLista Vazia %s\n", nome);
            System.out.println(imprimeTamanho());
            return;
        } // fim do if

        System.out.printf("\nA lista do tipo %s é: ", nome);
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

    public static String imprimeTamanho() {
        return "Tamanho da Lista: " + Lista.tamanhoLista;
    }

    public static int getTamanhoLista() {
        return tamanhoLista;
    }

}// fim da classe Lista
