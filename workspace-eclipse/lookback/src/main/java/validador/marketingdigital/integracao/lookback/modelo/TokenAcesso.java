package validador.marketingdigital.integracao.lookback.modelo;

import com.strongloop.android.loopback.Model;

public class TokenAcesso extends Model{

	private String nome;
	private String token;
	private String dataAtualizacao;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(String dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	
}
