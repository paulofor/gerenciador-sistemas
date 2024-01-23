package br.com.gersis.loopback.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class ProcessoJava extends Model{

	private String nomeClasseMain;
	private String pacoteClasseMain;
	private String projeto;
	private String jar;
	private String crontab;
	private String pom;
	
	private List<PassoProcessoJava> passoProcessoJavas;
	
	private List<ProcessoEntidadeEntradaRel> processoEntidadeEntrada;
	private List<ProcessoEntidadeSaidaRel> processoEntidadeSaida;
	private List<DadoProcesso> dadoProcessos;
	
	
	public List<DadoProcesso> getDadoProcessos() {
		return dadoProcessos;
	}
	public void setDadoProcessos(List<DadoProcesso> dadoProcessos) {
		this.dadoProcessos = new ArrayList<DadoProcesso>();
		for (int i = 0; i < dadoProcessos.size(); i++) {
			Object objeto = new DadoProcesso();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) dadoProcessos.get(i), true);
			this.dadoProcessos.add((DadoProcesso) objeto);
		}
	}
	
	public List<ProcessoEntidadeEntradaRel> getProcessoEntidadeEntrada() {
		return processoEntidadeEntrada;
	}
	public void setProcessoEntidadeEntrada(List<ProcessoEntidadeEntradaRel> processoEntidadeEntrada) {
		this.processoEntidadeEntrada = new ArrayList<ProcessoEntidadeEntradaRel>();
		for (int i = 0; i < passoProcessoJavas.size(); i++) {
			Object objeto = new ProcessoEntidadeEntradaRel();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) processoEntidadeEntrada.get(i), true);
			this.processoEntidadeEntrada.add((ProcessoEntidadeEntradaRel) objeto);
		}
	}
	
	
	public List<ProcessoEntidadeSaidaRel> getProcessoEntidadeSaida() {
		return processoEntidadeSaida;
	}
	public void setProcessoEntidadeSaida(List<ProcessoEntidadeSaidaRel> processoEntidadeSaida) {
		this.processoEntidadeSaida = new ArrayList<ProcessoEntidadeSaidaRel>();
		for (int i = 0; i < processoEntidadeSaida.size(); i++) {
			Object objeto = new ProcessoEntidadeSaidaRel();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) processoEntidadeSaida.get(i), true);
			this.processoEntidadeSaida.add((ProcessoEntidadeSaidaRel) objeto);
		}
	}
	
	
	
	public List<PassoProcessoJava> getPassoProcessoJavas() {
		return passoProcessoJavas;
	}
	public void setPassoProcessoJavas(List<PassoProcessoJava> passoProcessoJavas) {
		this.passoProcessoJavas = new ArrayList<PassoProcessoJava>();
		for (int i = 0; i < passoProcessoJavas.size(); i++) {
			Object objeto = new PassoProcessoJava();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) passoProcessoJavas.get(i), true);
			this.passoProcessoJavas.add((PassoProcessoJava) objeto);
		}
	}

	
	
	public String getNomeClasseMain() {
		return nomeClasseMain;
	}
	public void setNomeClasseMain(String nomeClasseMain) {
		this.nomeClasseMain = nomeClasseMain;
	}
	public String getPacoteClasseMain() {
		return pacoteClasseMain;
	}
	public void setPacoteClasseMain(String pacoteClasseMain) {
		this.pacoteClasseMain = pacoteClasseMain;
	}
	public String getProjeto() {
		return projeto;
	}
	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}
	public String getJar() {
		return jar;
	}
	public void setJar(String jar) {
		this.jar = jar;
	}
	public String getCrontab() {
		return crontab;
	}
	public void setCrontab(String crontab) {
		this.crontab = crontab;
	}
	public String getPom() {
		return pom;
	}
	public void setPom(String pom) {
		this.pom = pom;
	}
	
	
}
