package br.com.gersis.loopback.modelo;

import com.strongloop.android.loopback.Model;

public class Sistema extends Model{

	private String nome;
	private String sigla;
	private String nomeBancoDados;
	private String pathProjeto;
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
