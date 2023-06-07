package br.com.gersis.loopback.modelo;

import com.strongloop.android.loopback.Model;

public class PassoProcessoJava extends Model{

	private String nomeClasse;
	private String pacoteClasse;
	private String tipo;
	private int ordenacao;
	private int dentroLoop;
	private String tipoPasso;
	
	
	public String getNomeClasse() {
		return nomeClasse;
	}
	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}
	public String getPacoteClasse() {
		return pacoteClasse;
	}
	public void setPacoteClasse(String pacoteClasse) {
		this.pacoteClasse = pacoteClasse;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getOrdenacao() {
		return ordenacao;
	}
	public void setOrdenacao(int ordenacao) {
		this.ordenacao = ordenacao;
	}
	public int getDentroLoop() {
		return dentroLoop;
	}
	public void setDentroLoop(int dentroLoop) {
		this.dentroLoop = dentroLoop;
	}
	public String getTipoPasso() {
		return tipoPasso;
	}
	public void setTipoPasso(String tipoPasso) {
		this.tipoPasso = tipoPasso;
	}
	
	
	
	
}
