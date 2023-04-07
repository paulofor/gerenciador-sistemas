package sisacao.coinmarketcap.app;

import sisacao.coinmarketcap.callback.CoinMarketCapCallback;

public class CoinMarketCapApp {
	
	public static String UrlLoopback = "";

	public static void main(String[] args) {
		try {

			CoinMarketCapCallback obj = new CoinMarketCapCallback();
			obj.executaPrincipal();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
