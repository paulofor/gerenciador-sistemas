package br.com.gersis.geraangular.app;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.gersis.daobase.comum.DaoBaseComum;


public class GeraAngular6App {
	
	private static String UrlLoopback = "";
	
	public static void main(String[] args) {
		imprimeDataHora();
		try {
			carregaProp();
			GeraAngular6Obj obj = new GeraAngular6Obj();
			obj.executa();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void executa(int id) {
		imprimeDataHora();
		try {
			carregaProp();
			GeraAngular6Obj obj = new GeraAngular6Obj();
			obj.executa(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static void imprimeDataHora() {
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		// Crie um formatador de data e hora
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		// Formate a data e hora corrente usando o formatador
		String dataHoraFormatada = dataHoraAtual.format(formatador);
		// Exiba a data e hora corrente no console
		System.out.println(dataHoraFormatada);
	}
	
	private static void carregaProp() throws IOException {
		UrlLoopback = "http://vps-40d69db1.vps.ovh.ca:23102/api";
        DaoBaseComum.setUrl(UrlLoopback);
	}

}
