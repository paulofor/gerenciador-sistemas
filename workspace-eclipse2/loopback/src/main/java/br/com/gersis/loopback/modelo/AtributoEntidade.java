package br.com.gersis.loopback.modelo;

import com.strongloop.android.loopback.Model;

public class AtributoEntidade extends Model{

	private String nome;
	private String tipoBd;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoBd() {
		return tipoBd;
	}

	public void setTipoBd(String tipoBd) {
		this.tipoBd = tipoBd;
	}
	
	public String getTipoJava() {
		if (tipoBd.indexOf("VARCHAR")!=-1) return "String";
		if (tipoBd.indexOf("DATETIME")!=-1) return "String";
		if (tipoBd.indexOf("DATE")!=-1) return "String";
		if (tipoBd.indexOf("INT")!=-1) return "int";
		if (tipoBd.indexOf("DECIMAL")!=-1) return "double";
		if (tipoBd.indexOf("TEXT")!=-1) return "String";
		return tipoBd;
	}
	public String getNomeVariavel() {
		return nome.substring(0, 1).toLowerCase() + nome.substring(1);
	}
	public String getNomePropriedade() {
		return nome.substring(0,1).toUpperCase() + nome.substring(1);
	}
}
