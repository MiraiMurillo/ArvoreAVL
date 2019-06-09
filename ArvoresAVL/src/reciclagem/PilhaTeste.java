package reciclagem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.com.prof.arvore.EmptyListException;
import br.com.prof.arvore.Pilha;

public class PilhaTeste {

	private static int i;
	private static Pilha stack = new Pilha();

	public static void pilhas(String Leitura) {

		try {

			FileReader arquivo = new FileReader(Leitura);

			BufferedReader leitorLinhas = new BufferedReader(arquivo);

			String linha = "";

			linha = leitorLinhas.readLine();

			setI(0);

			while (linha != null) {

				stack.empilha(linha);

				linha = leitorLinhas.readLine();

				setI(getI() + 1);

				stack.print();
			}
			arquivo.close();

		} catch (IOException erro) {
			System.out.println("Erro ao ler arquivo: " + erro.getMessage());
		}
	}

	public static void PT() {

		stack.print();
		// remove itens da pilha
		try {
			Object removedObject = null;
			while (!stack.imprimeTamanho().equals("Tamanho da Lista: 0")) {
				removedObject = stack.desempilha();// utiliza o método pop
				System.out.printf("%s removido da pilha\n", removedObject);
				stack.print();
			} // fim do While
		} // fim do trry
		catch (EmptyListException e) {
			e.printStackTrace();
		} // fim do catch
	}// fim do main

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		PilhaTeste.i = i;
	}

	public static Pilha getStack() {
		return stack;
	}

	public static void setStack(Pilha stack) {
		PilhaTeste.stack = stack;
	}
}// fim da classe StackInheritanceTest 