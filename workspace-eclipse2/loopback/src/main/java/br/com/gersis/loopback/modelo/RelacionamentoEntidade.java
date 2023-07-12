package br.com.gersis.loopback.modelo;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class RelacionamentoEntidade extends Model{

	private String nome1;
	private String nomeN;
	private Entidade entidade1;
	private Entidade entidadeN;
	private int entidadeNId;
	private int entidade1Id;
	
	
	
	public int getEntidadeNId() {
		return entidadeNId;
	}
	public void setEntidadeNId(int entidadeNId) {
		this.entidadeNId = entidadeNId;
	}
	public int getEntidade1Id() {
		return entidade1Id;
	}
	public void setEntidade1Id(int entidade1Id) {
		this.entidade1Id = entidade1Id;
	}
	public String getNome1() {
		if (nome1==null) return this.getEntidade1().getNome();
		else return nome1;
	}
	public String getNome1Propriedade() {
		return getNome1().substring(0, 1).toUpperCase() + getNome1().substring(1);
	}
	public String getNome1Variavel() {
		return getNome1().substring(0, 1).toLowerCase() + getNome1().substring(1);
	}
	public String getNome1Chave() {
		return getNome1().substring(0, 1).toLowerCase() + getNome1().substring(1) + "Id";
	}
	public String getNome1TipoChaveNode() {
		return "number";
	}
	public void setNome1(String nome1) {
		this.nome1 = nome1;
	}
	public String getNomeN() {
		if (nomeN==null) {
			String nomeEntidade = this.getEntidadeN().getNome();
			if ("s".equals(nomeEntidade.substring(nomeEntidade.length()-1,nomeEntidade.length()))) {
				return nomeEntidade;
			} else {
				return this.getEntidadeN().getNome() + "s";
			}
		}
		else return nomeN;
	}
	public void setNomeN(String nomeN) {
		this.nomeN = nomeN;
	}
	public String getNomeNPropriedade() {
		return getNomeN().substring(0, 1).toUpperCase() + getNomeN().substring(1);
	}
	public String getNomeNVariavel() {
		return getNomeN().substring(0, 1).toLowerCase() + getNomeN().substring(1);
	}
	public Entidade getEntidadeN() {
		return entidadeN;
	}
	public void setEntidadeN(HashMap entidadeN) {
		this.entidadeN = new Entidade();
		BeanUtil.setProperties(this.entidadeN, (Map<String, ? extends Object>) entidadeN, true);
	}
	
	public Entidade getEntidade1() {
		return entidade1;
	}
	public void setEntidade1(HashMap entidade1) {
		this.entidade1 = new Entidade();
		BeanUtil.setProperties(this.entidade1, (Map<String, ? extends Object>) entidade1, true);
	}

	
	
}
