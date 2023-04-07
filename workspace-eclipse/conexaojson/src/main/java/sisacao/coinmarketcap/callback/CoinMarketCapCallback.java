package sisacao.coinmarketcap.callback;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.digicom.coletorjson.ICallbackJSON;
import br.com.digicom.coletorjson.ParserJson2;


public class CoinMarketCapCallback implements ICallbackJSON { 

	public void executaPrincipal() {
		ParserJson2 parser = new ParserJson2(this);
		parser.start();
	}
	
	
	public URL getUrl() throws MalformedURLException {
		return new URL("https://vps-40d69db1.vps.ovh.ca:21189/api/Cosmetic_OportunidadeDias/listaApp");
	}

	public void setJsonList(JSONArray result) {
		System.out.println("Chegou resultado Lista");
	}

	public void setJson(JSONObject result) {
		System.out.println("Chegou resultado Objecto");
	}

	
	
	public void inicializacao() {
	}

	public void finalizacaoOk() {
	}

	
	public void setString(String responseBody) {
		System.out.println(responseBody);
	}


	public String getBody() {
		// TODO Auto-generated method stub
		return null;
	}


	
	

}
