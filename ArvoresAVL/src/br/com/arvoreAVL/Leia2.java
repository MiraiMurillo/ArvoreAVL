package br.com.arvoreAVL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Leia2 {

	private static File arquivoCSV;
	private static String linhasDoArquivo;
	private static Scanner leitor;
	private static String[] ois = new String[381];

	public static void main(String[] args) {

		setArquivoCSV(new File("./arq/Professores.csv"));

		try {

			setLinhasDoArquivo(new String());
			leitor = new Scanner(getArquivoCSV());

			for (int i = 0; leitor.hasNext(); i++) {
				setLinhasDoArquivo(leitor.next());
				ois[i] = getLinhasDoArquivo();
			}
		} catch (FileNotFoundException e) {

		}
		for (int i = 0; i < ois.length; i++) {
			System.out.println(ois[i]);
		}
	}

	public static File getArquivoCSV() {
		return arquivoCSV;
	}

	public static void setArquivoCSV(File arquivoCSV) {
		Leia2.arquivoCSV = arquivoCSV;
	}

	public static String getLinhasDoArquivo() {
		return linhasDoArquivo;
	}

	public static void setLinhasDoArquivo(String string) {
		Leia2.linhasDoArquivo = string;
	}

	public static String[] getOis() {
		return ois;
	}

	public static void setOis(String[] ois) {
		Leia2.ois = ois;
	}
}
