package br.com.gersis.geraangular.app;

import java.util.Scanner;

import br.com.gersis.geraangular.loopback.DatasetGersis;

public class GeraAngular6Obj {

	public void executa(int idSistema) {
		DatasetGersis ds = new DatasetGersis();
		ds.setIdSistema(idSistema);
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
		System.out.println("ANGULAR6 - Selecione uma opção:");
		System.out.println("1 - Sisacao");
		System.out.println("2 - Marketing Digital");
		int opcao = scanner.nextInt();
		scanner.close();
		return opcao;
	}

}
