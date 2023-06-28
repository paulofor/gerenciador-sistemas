package br.com.gersis.geranodeloopback.loopback;

import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.ProcessoJava;
import br.com.gersis.loopback.modelo.Sistema;

public class DatasetGersis implements IDatasetComum{

	private Sistema sistema;
	private int idSistema;
	
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
