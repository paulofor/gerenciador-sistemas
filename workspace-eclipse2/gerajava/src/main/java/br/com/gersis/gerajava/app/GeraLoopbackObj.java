package br.com.gersis.gerajava.app;

import java.util.Scanner;

import br.com.gersis.gerajava.loopback.DatasetGersis;

public class GeraLoopbackObj {

	public void executa() {
		DatasetGersis ds = new DatasetGersis();
		ds.setIdSistema(getUserInput());
		Sistema_ObtemParaGerarJava exec = new Sistema_ObtemParaGerarJava();
		exec.setComum(ds);
		exec.executa();
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
