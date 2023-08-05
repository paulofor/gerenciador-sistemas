package br.com.gersis.geraangular.geradores.v6.detalhe;

import java.io.IOException;

import br.com.gersis.geraangular.geradores.v6.GeraHtml;

public class GeraHtmlDetalhe extends GeraHtml {

	public GeraHtmlDetalhe(String nome) {
		super(nome);
	}

	@Override
	public void gerar() throws IOException {
		this.criaArquivo();
		this.linha("<div class=\"dgc-painel\" *ngIf=\"principal\">");
		this.linha("	<div class=\"dgc-painel-header\">");
		this.linha("	</div>");
		this.linha("</div>");
		this.fecha();
	}
	
	

}
