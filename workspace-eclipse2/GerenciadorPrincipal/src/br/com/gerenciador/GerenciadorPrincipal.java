package br.com.gerenciador;

import java.util.Scanner;

import br.com.gersis.geraangular.app.GeraAngular6App;
import br.com.gersis.geraangular.app.Sistema_ObtemParaGerarNode;
import br.com.gersis.geraangular.loopback.DatasetGersis;
import br.com.gersis.gerajava.app.GeraLoopbackAplicacao;
import br.com.gersis.geranodeloopback.app.GeraNodeLoopbackAplicacao;

public class GerenciadorPrincipal {

	public static void main(String[] args) {
		int idSistema = getUserInput();
		GeraAngular6App obj1 = new GeraAngular6App();
		obj1.executa(idSistema);
		GeraLoopbackAplicacao obj2 = new GeraLoopbackAplicacao();
		obj2.executa(idSistema);
		GeraNodeLoopbackAplicacao obj3 = new GeraNodeLoopbackAplicacao();
		obj3.executa(idSistema);
		System.out.println("concluido");
		System.exit(0);
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
		System.out.println("Gerador Completo - Selecione uma opção:");
		System.out.println("1 - Sisacao");
		System.out.println("2 - Marketing Digital");
		int opcao = scanner.nextInt();
		scanner.close();
		return opcao;
	}
}
