package br.com.prof.arvore;

public class PilhaTeste {
	public static void main(String[] args) {
		Pilha stack = new Pilha();
		// utliza método push
		stack.empilha(-1);
		stack.print();
		stack.empilha(0);
		stack.print();
		stack.empilha(1);
		stack.print();
		stack.empilha(5);
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
}// fim da classe StackInheritanceTest