package br.com.gersis.loopback.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class ParametroMetodoServer extends Model{

	private String nome;
	private String tipo;
	private int posicao;
	
	public String getTipoJava() {
		if (tipo.indexOf("number-int")!=-1) return "int";
		if (tipo.indexOf("number-double")!=-1) return "double";
		if (tipo.indexOf("string")!=-1) return "String";
		if (tipo.indexOf("date")!=-1) return "String";
		if (tipo.indexOf("object")!=-1) return null;
		return tipo;
	}
	public String getTipoNode() {
		if (tipo.indexOf("number-int")!=-1) return "number";
		if (tipo.indexOf("number-double")!=-1) return "number";
		if (tipo.indexOf("string")!=-1) return "string";
		if (tipo.indexOf("date")!=-1) return "string";
		if (tipo.indexOf("object")!=-1) return "object";
		return tipo;
	}
	
	public boolean isObject() {
		return (tipo.indexOf("object")!=-1);
	}
	public boolean isList() {
		return (tipo.indexOf("array")!=-1);
	}
	
	public String getParametroFuncaoJava(Entidade entidade) {
		if (tipo.indexOf("object")!=-1) return entidade.getNome() + " " + this.nome;
		if (tipo.indexOf("array")!=-1) return "List<" + entidade.getNome() + "> " + this.nome;
		return this.getTipoJava() + " " + this.nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	
	
	
	
}
