package br.com.gersis.geraangular.geradores.v6.detalhe;

import java.io.IOException;

import br.com.gersis.geraangular.geradores.v6.GeraHtml;

public class GeraHtmlDetalhe extends GeraHtml {

	public GeraHtmlDetalhe(String nome) {
		super(nome);
	}

	@Override
	public void geraArquivo() throws IOException {
	
		this.linha("<div class=\"dgc-painel\" *ngIf=\"principal\">");
		this.linha("<div class=\"dgc-painel-header\" *ngIf=\"principal\">");
		this.linha("	<span>{{principal.nome}}</span>");
		this.linha("</div>");
		this.linha("");
		this.linha("<div class=\"dgc-card\">");
		this.linha("<div class=\"dgc-card-header\">");
		this.linha("<span>Quadro 1</span>");
		this.linha("</div>");
		this.linha("<div class=\"dgc-card-detalhe\" *ngFor=\"let rel of principal.processoEntidadeSaida\">");
		this.linha("<span></span>");
		this.linha("</div>");
		this.linha("<div class=\"dgc-card-comandos\">");
		this.linha("</div> ");
		this.linha(" </div>");
		this.linha("	");
		this.linha("<div class=\"dgc-card\">");
		this.linha("<div class=\"dgc-card-header\">");
		this.linha("<span>Quadro 2</span>");
		this.linha("	</div>");
		this.linha("<div class=\"dgc-card-detalhe\" *ngFor=\"let rel of principal.processoEntidadeSaida\">");
		this.linha("<span></span>");
		this.linha("</div>");
		this.linha("<div class=\"dgc-card-comandos\">");
		this.linha("			</div> ");
		this.linha("  </div>");
		this.linha("<div class=\"dgc-card-comandos\">");
		this.linha("<button class=\"btn-primary btn-sm btn\" (click)=\"editaPasso()\">Novo</button>");
		this.linha("</div> ");
		this.linha("</div>");
		this.linha("");

	  
	}
	
	

}
