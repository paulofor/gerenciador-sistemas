package br.com.gersis.loopback.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class Sistema extends Model{

	private String nome;
	private String sigla;
	private String nomeBancoDados;
	private String pathProjeto;
	
	private List<ProcessoJava> processoJavas;
	
	
	
	public List<ProcessoJava> getProcessoJavas() {
		return processoJavas;
	}
	public void setProcessoJavas(List<ProcessoJava> processoJavas) {
		this.processoJavas = new ArrayList<ProcessoJava>();
		for (int i = 0; i < processoJavas.size(); i++) {
			Object objeto = new ProcessoJava();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) processoJavas.get(i), true);
			this.processoJavas.add((ProcessoJava) objeto);
		}
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNomeBancoDados() {
		return nomeBancoDados;
	}
	public void setNomeBancoDados(String nomeBancoDados) {
		this.nomeBancoDados = nomeBancoDados;
	}
	public String getPathProjeto() {
		return pathProjeto;
	}
	public void setPathProjeto(String pathProjeto) {
		this.pathProjeto = pathProjeto;
	}
	
	
	
	
}
