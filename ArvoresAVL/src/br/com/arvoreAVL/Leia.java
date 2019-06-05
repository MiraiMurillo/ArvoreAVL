package br.com.arvoreAVL;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Leia {

	private static String[] professores;

	public static String[] profs(String arquivoCSV) {
			
			BufferedReader br = null;
			String linha = "";
			String csvDivisor = "  ";
			setProfessores(null);

				try {

					br = new BufferedReader(new FileReader(arquivoCSV));
					while ((linha = br.readLine()) != null) {

						setProfessores(linha.split(csvDivisor));
						return getProfessores();

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
				return null;
			}

			public static String[] getProfessores() {
				return professores;
			}

			public static void setProfessores(String[] professores) {
				Leia.professores = professores;
			}
		}















