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
	private List<MetodoServer> metodoServers;
	private List<TelaFront> telaFonts;
	
	public String getNomeHifen() {
		return nome.replaceAll("([a-z])([A-Z])", "$1-$2").toLowerCase();
	}
	
	
	public boolean temSLoopback() {
		if (nome.endsWith("ia")) return false;
		else return true;
	}
	
	public List<MetodoServer> getMetodoServers() {
		return metodoServers;
	}
	public void setMetodoServers(List<MetodoServer> metodoServers) {
		this.metodoServers = new ArrayList<MetodoServer>();
		for (int i = 0; i < metodoServers.size(); i++) {
			Object objeto = new MetodoServer();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) metodoServers.get(i), true);
			this.metodoServers.add((MetodoServer) objeto);
		}
	}
	
	public List<TelaFront> getTelaFronts() {
		return telaFonts;
	}
	public void setTelaFronts(List<TelaFront> telaFonts) {
		this.telaFonts = new ArrayList<TelaFront>();
		for (int i = 0; i < telaFonts.size(); i++) {
			Object objeto = new TelaFront();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) telaFonts.get(i), true);
			this.telaFonts.add((TelaFront) objeto);
		}
	}
	
	
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
			((AtributoEntidade)objeto).setEntidade(this);
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
