package validador.marketingdigital.integracao.hotmart.callback;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicHeader;
import org.json.JSONArray;
import org.json.JSONObject;

import br.com.digicom.coletorjson.ICallbackJSON;
import br.com.digicom.coletorjson.ParserJson2;
import validador.marketingdigital.integracao.daobase.DaoBase;
import validador.marketingdigital.integracao.daobase.comum.DaoBaseComum;
import validador.marketingdigital.integracao.hotmart.daobase.HotmartDataset;
import validador.marketingdigital.integracao.hotmart.daobase.ProdutoHotmart_InsereListaProdutoHotmart;
import validador.marketingdigital.integracao.lookback.modelo.VisitaProdutoHotmart;

public class HotmartSearchCallback extends DaoBaseComum implements ICallbackJSON {

	
	private List<VisitaProdutoHotmart> listaProduto = new ArrayList<VisitaProdutoHotmart>();
	
	public URL getUrl() throws MalformedURLException {
		return new URL("https://api-affiliation-market.hotmart.com/v1/market/hottest/search");
	}

	public void setJsonList(JSONArray result) {
		System.out.println("Recebi lista");
	}

	public void setJson(JSONObject result) {
		System.out.println("Recebi objeto");
		JSONArray produtos = result.getJSONArray("content");
		System.out.println("Produtos:" + produtos.length());
		for (int i=0; i<produtos.length(); i++) {
			VisitaProdutoHotmart produtoObj = new VisitaProdutoHotmart(produtos.getJSONObject(i));
			this.listaProduto.add(produtoObj);
		}
		HotmartDataset ds = (HotmartDataset) this.getComum();
		ds.setListaProduto(this.listaProduto);
		this.executaProximo();
	}

	public void inicializacao() {
		// TODO Auto-generated method stub
		
	}

	public void finalizacaoOk() {
		// TODO Auto-generated method stub
		
	}

	public void setString(String responseBody) {
		// TODO Auto-generated method stub
	}

	@Override
	protected long getTempo() {
		return 3000;
	}

	@Override
	protected void executaImpl() {
		HotmartDataset ds = (HotmartDataset) this.getComum();
		
		ParserJson2 parser = new ParserJson2(this);
		parser.addHeader(new BasicHeader("Content-Type","application/json"));
		parser.addHeader(new BasicHeader("Authorization","Bearer " + ds.getTokenAcesso()));
		parser.start();


	}

	public String getBody() {
		return "{\"name\":\"hottest\",\"rows\":100,\"locale\":\"PT_BR\",\"page\":\"5\"}";
	}

	@Override
	protected DaoBase getProximo() {
		return new ProdutoHotmart_InsereListaProdutoHotmart();
	} 

	
}
