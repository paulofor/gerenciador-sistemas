package br.com.gersis.loopback.modelo;

import java.util.ArrayList;
import java.util.HashMap;
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
	private Entidade entidade;

	
	public boolean isVoid() {
		return (tipoResposta.indexOf("Void")!=-1);
	}
	public boolean isList() {
		return (tipoResposta.indexOf("List")!=-1);
	}
	public boolean isObject() {
		return (tipoResposta.indexOf("Object")!=-1);
	}
	
	public String getJavaCallbackParametro() {
		return this.getJavaCallbackParametro(this.entidade);
	}
	public String getJavaCallbackPasso() {
		return this.getJavaCallbackPasso(this.entidade);
	}
	
	
	public String getRetornoTipoNode() {
		if (this.tipoResposta==null) {
			throw new RuntimeException(nome + " está sem tipo definido");
		}
		if (this.tipoResposta.indexOf("Void")!=-1) return "object";
		if (this.tipoResposta.indexOf("List")!=-1) return "array";
		if (this.tipoResposta.indexOf("Object")!=-1) return "object";
		return null;
	}
	
	public String getJavaCallbackPasso(Entidade entidade) {
		if (this.tipoResposta==null) {
			throw new RuntimeException(entidade.getNome() + "." + nome + " está sem tipo definido");
		}
		if (this.tipoResposta.indexOf("Void")!=-1) return "new VoidCallback {";
		if (this.tipoResposta.indexOf("List")!=-1) return "new ListCallback<" + entidade.getNome() +">() {";
		if (this.tipoResposta.indexOf("Object")!=-1) return "new ObjectCallback<" + entidade.getNome() +">() {";
		return null;
	}
	public String getJavaCallbackParametro(Entidade entidade) {
		if (this.tipoResposta==null) {
			throw new RuntimeException(entidade.getNome() + "." + nome + " está sem tipo definido");
		}
		if (this.tipoResposta.indexOf("Void")!=-1) return "final VoidCallback callback";
		if (this.tipoResposta.indexOf("List")!=-1) return "final ListCallback<" + entidade.getNome() +"> callback";
		if (this.tipoResposta.indexOf("Object")!=-1) return "final ObjectCallback<" + entidade.getNome() +"> callback";
		return null;
	}
	public String getJavaCallbackNew(Entidade entidade) {
		if (this.tipoResposta.indexOf("Void")!=-1) return "new EmptyResponseParser(callback)";
		if (this.tipoResposta.indexOf("List")!=-1) return "new JsonArrayParser<" + entidade.getNome() +">(this, callback)";
		if (this.tipoResposta.indexOf("Object")!=-1) return "new JsonObjectParser<" + entidade.getNome() +">(this, callback)";
		return null;
	}

	public String getNomeHungara() {
		return this.nome.substring(0, 1).toLowerCase() + this.nome.substring(1);
	}
	
	public String getParametrosFuncaoJava(Entidade entidade) {
		String saida = "";
		for (int i=0;i<this.parametroMetodoServers.size();i++) {
			//if (i==0) {
			saida += this.parametroMetodoServers.get(i).getParametroFuncaoJava(entidade) + " ,";		
			//} else {
			//	saida += this.parametroMetodoServers.get(i).getParametroFuncaoJava();
			//}
		}
		return saida;
	}
	public String getParametroEntradaJava() {
		String saida = "";
		for (int i=0;i<this.parametroMetodoServers.size();i++) {
			saida += this.parametroMetodoServers.get(i).getNome() + " ,";		
		}
		return saida;
	}
	
	
	public Entidade getEntidade() {
		return entidade;
	}
	public void setEntidade(HashMap entidade) {
		this.entidade = new Entidade();
		BeanUtil.setProperties(this.entidade, (Map<String, ? extends Object>) entidade, true);
	}
	
	
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
		this.nome = nome.trim();
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta.trim();
	}
	public String getTipoResposta() {
		return tipoResposta;
	}
	public void setTipoResposta(String tipoResposta) {
		this.tipoResposta = tipoResposta.trim();
	}
	public String getTipoMetodo() {
		return tipoMetodo;
	}
	public void setTipoMetodo(String tipoMetodo) {
		this.tipoMetodo = tipoMetodo.trim();
	}
	
	
	
	
}
