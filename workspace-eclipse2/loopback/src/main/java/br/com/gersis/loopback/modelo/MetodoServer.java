package br.com.gersis.loopback.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class MetodoServer extends Model{

	private String nome;
	private String resposta;
	private String tipoResposta;
	private String tipoMetodo;
	
	private List<ParametroMetodoServer> parametroMetodoServers;

	
	
	public List<ParametroMetodoServer> getParametroMetodoServers() {
		return parametroMetodoServers;
	}
	public void setParametroMetodoServers(List<ParametroMetodoServer> parametroMetodoServers) {
		this.parametroMetodoServers = new ArrayList<ParametroMetodoServer>();
		for (int i = 0; i < parametroMetodoServers.size(); i++) {
			Object objeto = new ParametroMetodoServer();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) parametroMetodoServers.get(i), true);
			this.parametroMetodoServers.add((ParametroMetodoServer) objeto);
		}
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public String getTipoResposta() {
		return tipoResposta;
	}
	public void setTipoResposta(String tipoResposta) {
		this.tipoResposta = tipoResposta;
	}
	public String getTipoMetodo() {
		return tipoMetodo;
	}
	public void setTipoMetodo(String tipoMetodo) {
		this.tipoMetodo = tipoMetodo;
	}
	
	
	
	
}
