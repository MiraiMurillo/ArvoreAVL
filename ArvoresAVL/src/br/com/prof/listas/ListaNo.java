package br.com.prof.listas;

//classe para representar um nó em uma lista
public class ListaNo {
    final Object data;
    ListaNo proximoNo;

    ListaNo(Object object) {
        this(object, null);
    }// Fim do construtor de um argumento ListaNo

    // construtor cria ListaNo que referencia

    // Object e o próximo ListaNo
    ListaNo(Object object, ListaNo node) {
        data = object;
        proximoNo = node;
    }// fim do construtor de dois argumentos ListaNo

    // retorna referência ao próximo nó na lista

}// fim da classe ListaNo
