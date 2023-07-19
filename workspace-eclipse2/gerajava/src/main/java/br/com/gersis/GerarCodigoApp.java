package br.com.gersis;

import java.util.Scanner;

public class GerarCodigoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	private static int getUserInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Selecione uma opção:");
		System.out.println("1 - Sisacao");
		System.out.println("2 - Marketing Digital");
		int opcao = scanner.nextInt();
		scanner.close();
		return opcao;
	}
}
