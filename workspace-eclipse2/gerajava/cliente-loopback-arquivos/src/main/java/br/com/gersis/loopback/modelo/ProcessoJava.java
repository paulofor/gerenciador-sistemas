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
	
	private List<PassoProcessoJava> passoProcessoJavas;
	
	
	
	
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
	
	
}
