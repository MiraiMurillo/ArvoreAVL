package br.com.arvoreAVL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Leia {

	// Versão instável de merda

	private String[] professores;

	public static void main(String[] args) {

		Leia obj = new Leia();
		obj.run();
	}

	public void run() {

		String arquivoCSV = "./arq/Professores.csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ",";
		setProfessores(null);

		try {

			br = new BufferedReader(new FileReader(arquivoCSV));
			while ((linha = br.readLine()) != null) {

				setProfessores(linha.split(csvDivisor));

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			if (br != null) {

				try {

					br.close();

				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public String[] getProfessores() {
		return professores;
	}

	public void setProfessores(String[] professores) {
		this.professores = professores;
	}
}