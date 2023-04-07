package br.com.digicom.coletorjson;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public interface ICallbackJSON {

	
	URL getUrl() throws MalformedURLException;

	void setJsonList(JSONArray result);

	void setJson(JSONObject result);

	void inicializacao();

	void finalizacaoOk();

	void setString(String responseBody);
	
	String getBody();

}
