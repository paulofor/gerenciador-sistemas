package br.com.gersis.loopback.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class PassoProcessoJava extends Model{

	private String nomeClasse;
	private String pacoteClasse;
	private String tipo;
	private int ordenacao;
	private int dentroLoop;
	private String tipoPasso;
	private MetodoServer metodoServer;
	private List<DadoProcessoEntradaRel> dadoPassoEntrada;
	private List<DadoProcessoSaidaRel> dadoPassoSaida;
	
	
	
	
	public String parametrosEntrada() {
		String saida = "";
		for (int i=0;i< this.dadoPassoEntrada.size(); i++) {
			DadoProcesso dado = this.dadoPassoEntrada.get(i).getDadoProcesso();
			if (i==0) {
				saida += "ds.get" + dado.getNomePropriedade() + "()";
			} else {
				saida += ", ds.get" + dado.getNomePropriedade() + "()";
			}
		}
		return saida;
	}
	public String parametrosEntradaComTipo() {
		String saida = "";
		for (int i=0;i< this.dadoPassoEntrada.size(); i++) {
			DadoProcesso dado = this.dadoPassoEntrada.get(i).getDadoProcesso();
			if (i==0) {
				saida += " " + dado.getTipoJava() + " " + dado.getNomePropriedade() + " ";
			} else {
				saida += ", " + dado.getTipoJava() + " " + dado.getNomePropriedade() + " ";
			}
		}
		return saida;
	}
	
	public List<DadoProcessoEntradaRel> getDadoPassoEntrada() {
		return dadoPassoEntrada;
	}
	public void setDadoPassoEntrada(List<DadoProcessoEntradaRel> dadoPassoEntrada) {
		this.dadoPassoEntrada = new ArrayList<DadoProcessoEntradaRel>();
		for (int i = 0; i < dadoPassoEntrada.size(); i++) {
			Object objeto = new DadoProcessoEntradaRel();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) dadoPassoEntrada.get(i), true);
			this.dadoPassoEntrada.add((DadoProcessoEntradaRel) objeto);
		}
	}
	public List<DadoProcessoSaidaRel> getDadoPassoSaida() {
		return dadoPassoSaida;
	}
	public void setDadoPassoSaida(List<DadoProcessoSaidaRel> dadoPassoSaida) {
		this.dadoPassoSaida = new ArrayList<DadoProcessoSaidaRel>();
		for (int i = 0; i < dadoPassoSaida.size(); i++) {
			Object objeto = new DadoProcessoSaidaRel();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) dadoPassoSaida.get(i), true);
			this.dadoPassoSaida.add((DadoProcessoSaidaRel) objeto);
		}
	}
	
	
	public MetodoServer getMetodoServer() {
		return metodoServer;
	}
	public void setMetodoServer(HashMap metodoServer) {
		this.metodoServer = new MetodoServer();
		BeanUtil.setProperties(this.metodoServer, (Map<String, ? extends Object>) metodoServer, true);
	}
	
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
