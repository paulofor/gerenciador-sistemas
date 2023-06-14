package br.com.gersis.gerajava.geradores;

import java.io.IOException;

public abstract class GeradorBase {

	protected String diretorioWorkspace = null;
	
	
	
	public void setDiretorioWorkspace(String diretorioWorkspace) {
		this.diretorioWorkspace = diretorioWorkspace;
	}



	public abstract void gerar() throws IOException;
	
	
}
