package br.com.gersis.geraangular.geradores.v6;

import java.io.IOException;

import br.com.gersis.geraangular.geradores.GeradorArquivoTela;
import br.com.gersis.loopback.modelo.Entidade;
import br.com.gersis.loopback.modelo.TelaFront;

public class GeraHtml extends GeradorArquivoTela {

	
	public GeraHtml(String nome) {
		super(nome);
	}

	
	public void gerar() throws IOException {
		this.criaArquivo();
		this.fecha();
	}

}
