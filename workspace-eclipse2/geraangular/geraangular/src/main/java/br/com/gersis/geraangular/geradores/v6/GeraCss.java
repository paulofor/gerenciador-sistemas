package br.com.gersis.geraangular.geradores.v6;

import java.io.IOException;

import br.com.gersis.geraangular.geradores.GeradorArquivoTela;

public class GeraCss extends GeradorArquivoTela {
	
	public GeraCss(String nome) {
		super(nome);
	}


	public void gerar() throws IOException {
		this.criaArquivo();
		this.fecha();
	}
}
