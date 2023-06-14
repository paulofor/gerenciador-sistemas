package br.com.gersis.loopback.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class Entidade extends Model{

	private String nome;
	
	private List<AtributoEntidade> atributoEntidades;
	
	private List<RelacionamentoEntidade> relacionamentos1;
	private List<RelacionamentoEntidade> relacionamentosN;
	
	
	public List<RelacionamentoEntidade> getRelacionamentosN() {
		return relacionamentosN;
	}

	public void setRelacionamentosN(List<RelacionamentoEntidade> relacionamentosN) {
		this.relacionamentosN = new ArrayList<RelacionamentoEntidade>();
		for (int i = 0; i < relacionamentosN.size(); i++) {
			Object objeto = new RelacionamentoEntidade();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) relacionamentosN.get(i), true);
			this.relacionamentosN.add((RelacionamentoEntidade) objeto);
		}
	}
	
	public List<RelacionamentoEntidade> getRelacionamentos1() {
		return relacionamentos1;
	}

	public void setRelacionamentos1(List<RelacionamentoEntidade> relacionamentos1) {
		this.relacionamentos1 = new ArrayList<RelacionamentoEntidade>();
		for (int i = 0; i < relacionamentos1.size(); i++) {
			Object objeto = new RelacionamentoEntidade();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) relacionamentos1.get(i), true);
			this.relacionamentos1.add((RelacionamentoEntidade) objeto);
		}
	}
	
	
	public List<AtributoEntidade> getAtributoEntidades() {
		return atributoEntidades;
	}

	public void setAtributoEntidades(List<AtributoEntidade> atributoEntidades) {
		this.atributoEntidades = new ArrayList<AtributoEntidade>();
		for (int i = 0; i < atributoEntidades.size(); i++) {
			Object objeto = new AtributoEntidade();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) atributoEntidades.get(i), true);
			this.atributoEntidades.add((AtributoEntidade) objeto);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNomeVariavel() {
		return this.nome.substring(0, 1).toLowerCase() + this.nome.substring(1);
	}
	
}
