package br.com.gersis.geranodeloopback.app;

import java.util.Scanner;

import br.com.gersis.geranodeloopback.loopback.DatasetGersis;

public class GeraNodeLoopbackObj {
	
	
	public void executa(int id) {
		DatasetGersis ds = new DatasetGersis();
		ds.setIdSistema(id);
		Sistema_ObtemParaGerarNode exec = new Sistema_ObtemParaGerarNode();
		exec.setComum(ds);
		exec.executa();
	}

	public void executa() {
		DatasetGersis ds = new DatasetGersis();
		ds.setIdSistema(getUserInput());
		Sistema_ObtemParaGerarNode exec = new Sistema_ObtemParaGerarNode();
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
