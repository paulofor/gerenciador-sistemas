package br.com.gersis.gerajava.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.com.gersis.daobase.comum.DaoBaseComum;

public class GeraLoopbackAplicacao {

	private static String UrlLoopback = "";
	
	public static void main(String[] args) {
		System.out.print("GeraLoopbackAplicacao");
		System.out.println("(22-05-2023)");
		try {
			carregaProp();
			GeraLoopbackObj obj = new GeraLoopbackObj();
			obj.executa();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
