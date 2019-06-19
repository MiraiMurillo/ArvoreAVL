package br.com.arvoreAVL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leia {

	// funcionando

	private static ArrayList<String> profs;

	public static ArrayList<String> profs(String arquivoCSV) {

		setProfs(new ArrayList<String>());

		try {

			FileReader arquivo = new FileReader(arquivoCSV);

			BufferedReader leitorLinhas = new BufferedReader(arquivo);

			String linha = "";

			linha = leitorLinhas.readLine();

			while (linha != null) {

				profs.add(linha);

				linha = leitorLinhas.readLine();

			}
			arquivo.close();

		} catch (IOException erro) {
			System.out.println("Erro ao ler arquivo: " + erro.getMessage());
		}
		return getProfs();
	}

	public static ArrayList<String> getProfs() {
		return profs;
	}

	public static void setProfs(ArrayList<String> profs) {
		Leia.profs = profs;
	}
}