package validador.marketingdigital.integracao.hotmart.daobase;

import java.util.List;

import validador.marketingdigital.integracao.daobase.IDatasetComum;
import validador.marketingdigital.integracao.lookback.modelo.VisitaProdutoHotmart;

public class HotmartDataset implements IDatasetComum{

	private String tokenAcesso;
	private List<VisitaProdutoHotmart> listaProduto;

	private final String NOME_TOKEN = "HOTMART";
	
	public String getNomeToken() {
		return NOME_TOKEN;
	}
	
	public String getTokenAcesso() {
		return tokenAcesso;
	}

	public void setTokenAcesso(String tokenAcesso) {
		this.tokenAcesso = tokenAcesso;
	}

	public List<VisitaProdutoHotmart> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<VisitaProdutoHotmart> listaProduto) {
		this.listaProduto = listaProduto;
	}
	
	

}
