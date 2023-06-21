package br.com.gersis.loopback.modelo;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class DadoProcesso extends Model{

	private String nome;
	private String tipoSimples;
	private int tipoEntidadeLista;
	private Entidade tipoEntidade;
	
	
	public String getTipoJava() {
		if (tipoEntidadeLista==0) {
			if (tipoEntidade != null) return this.tipoEntidade.getNome();
			else return this.tipoSimples;
		} else {
			if (tipoEntidade != null) return "List<" + this.tipoEntidade.getNome()+ ">";
			else return "List<" + this.tipoSimples + ">";
		}
	}
	public String getNomeVariavel() {
		return nome.substring(0, 1).toLowerCase() + nome.substring(1);
	}
	public String getNomePropriedade() {
		return nome.substring(0,1).toUpperCase() + nome.substring(1);
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipoSimples() {
		return tipoSimples;
	}
	public void setTipoSimples(String tipoSimples) {
		this.tipoSimples = tipoSimples;
	}
	public int getTipoEntidadeLista() {
		return tipoEntidadeLista;
	}
	public void setTipoEntidadeLista(int tipoEntidadeLista) {
		this.tipoEntidadeLista = tipoEntidadeLista;
	}
	public Entidade getTipoEntidade() {
		return tipoEntidade;
	}
	public void setTipoEntidade(HashMap tipoEntidade) {
		this.tipoEntidade = new Entidade();
		BeanUtil.setProperties(this.tipoEntidade, (Map<String, ? extends Object>) tipoEntidade, true);
	}



	

	
	
	
	
}
