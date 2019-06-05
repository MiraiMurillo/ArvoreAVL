package br.com.arvoreAVL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leia {
	
	//funcionando
	
	public static String[] profs(String arquivoCSV) {

		String[] professores = null;
		
		try {

			FileReader arquivo = new FileReader(arquivoCSV);

			BufferedReader leitorLinhas = new BufferedReader(arquivo);

			String linha = "";

			linha = leitorLinhas.readLine();

			 professores = new String[100];

			int i = 0;

			while (linha != null) {

				professores[i] = linha;

				linha = leitorLinhas.readLine();

				i++;
			}
			arquivo.close();

		} catch (IOException erro) {
			System.out.println("Erro ao ler arquivo: " + erro.getMessage());
		}
		return professores;
	}
}