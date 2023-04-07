package validador.marketingdigital.integracao.hotmart.app;

import validador.marketingdigital.integracao.daobase.comum.DaoBaseComum;

public class HotmartApp {

	public static String UrlLoopback = "";

	public static void main(String[] args) {
		DaoBaseComum.setUrl("http://localhost:23101/api");
		try {
			HotmartObj obj = new HotmartObj();
			obj.executa();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

//	private static void carregaProp() throws IOException {
//		System.out.println("Dir:" + System.getProperty("user.dir"));
//		InputStream input = new FileInputStream("CotacaoCoinMarketCap.config");
//		Properties prop = new Properties();
//        prop.load(input);
//        UrlLoopback = prop.getProperty("loopback.url");
//        DaoBaseComum.setUrl(UrlLoopback);
//	}
	
}
