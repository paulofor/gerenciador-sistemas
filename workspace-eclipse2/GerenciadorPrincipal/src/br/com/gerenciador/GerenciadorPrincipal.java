package br.com.gerenciador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataHoraFormatada = dataHoraAtual.format(formatador);
		System.out.println("finalizou " + dataHoraFormatada);
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
		System.out.println("4 - Sugar");
		System.out.println("7 - CurriculoSis");
		int opcao = scanner.nextInt();
		scanner.close();
		return opcao;
	}
}
