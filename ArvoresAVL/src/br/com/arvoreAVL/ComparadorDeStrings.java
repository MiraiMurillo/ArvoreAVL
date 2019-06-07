package br.com.arvoreAVL;

public class ComparadorDeStrings {

	public static int comparadorDeStrings(String s1, String s2) {

		System.out.println("\nComparando \"" + s1 + "\" a \"" + s2 + "\"...");

		int comparisonResult = s1.compareTo(s2);

		System.out.println("\nO resultado da Comparação foi: " + comparisonResult);
		System.out.print("\nIsto significa que \"" + s1 + "\" ");

		if (comparisonResult < 0) {
			System.out.println("\nLexicograficamente vem antes de \"" + s2 + "\".");
		} else if (comparisonResult > 0) {
			System.out.println("\nLexicograficamente vem depois de \"" + s2 + "\".");
		} else {
			System.out.println("\nÉ igual \"" + s2 + "\".");
		}
		System.out.println();

		return comparisonResult;
	}
}
