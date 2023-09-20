package br.com.gersis.geranodeloopback.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import br.com.gersis.daobase.comum.DaoBaseComum;

public class GeraNodeLoopbackAplicacao {

	private static String UrlLoopback = "";
	
	public static void main(String[] args) {
		System.out.println("GeraLoopbackAplicacao");
		imprimeDataHora();
		try {
			carregaProp();
			GeraNodeLoopbackObj obj = new GeraNodeLoopbackObj();
			obj.executa();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void executa(int id) {
		System.out.println("GeraLoopbackAplicacao");
		imprimeDataHora();
		try {
			carregaProp();
			GeraNodeLoopbackObj obj = new GeraNodeLoopbackObj();
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
		//System.out.println("Dir:" + System.getProperty("user.dir"));
		//InputStream input = new FileInputStream("CriaPythonTreinoRede.config");
		//Properties prop = new Properties();
        //prop.load(input);
        //UrlLoopback = prop.getProperty("loopback.url");
		UrlLoopback = "http://vps-40d69db1.vps.ovh.ca:23102/api";
        DaoBaseComum.setUrl(UrlLoopback);
	}

}
