package br.com.gersis.gerajava.loopback;

import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.ProcessoJava;
import br.com.gersis.loopback.modelo.Sistema;

public class DatasetGersis implements IDatasetComum{

	private Sistema sistema;
	private int idSistema;
	
	private String nomePastaFonteCorrente;
	private String nomePastaWorkspace;
	private String pacotePrincipalProjetoCorrente;
	
	private ProcessoJava processoCorrente;

	
	
	

	public String getNomePastaWorkspace() {
		return nomePastaWorkspace;
	}
	public void setNomePastaWorkspace(String nomePastaWorkspace) {
		this.nomePastaWorkspace = nomePastaWorkspace;
	}
	public ProcessoJava getProcessoCorrente() {
		return processoCorrente;
	}
	public void setProcessoCorrente(ProcessoJava processoCorrente) {
		this.processoCorrente = processoCorrente;
	}
	
	public String getNomePastaFonteCorrente() {
		return nomePastaFonteCorrente;
	}
	public void setNomePastaFonteCorrente(String nomePastaFonteCorrente) {
		this.nomePastaFonteCorrente = nomePastaFonteCorrente;
	}
	public Sistema getSistema() {
		return sistema;
	}
	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	public int getIdSistema() {
		return idSistema;
	}
	public void setIdSistema(int idSistema) {
		this.idSistema = idSistema;
	}
	
	
}
