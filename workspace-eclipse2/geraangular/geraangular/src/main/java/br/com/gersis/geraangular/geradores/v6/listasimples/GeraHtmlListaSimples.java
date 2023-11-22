package br.com.gersis.geraangular.geradores.v6.listasimples;

import java.io.IOException;

import br.com.gersis.geraangular.geradores.v6.GeraHtml;

public class GeraHtmlListaSimples extends GeraHtml {

	public GeraHtmlListaSimples(String nome) {
		super(nome);
	}

	@Override
	public void geraArquivo() throws IOException {
		this.linha("<div class=\"dgc-painel\">");
		this.linha("	<div class=\"dgc-painel-header\">");
		this.linha("		<span>" + this.getEntidade().getNome() + "</span>");
		this.linha("  		<button class=\"btn btn-primary btn-sm dgc-botao-comando dgc-direita\" (click)=\"edita()\">novo</button>");
		this.linha("	</div>");
		this.linha("	<div class=\"dgc-painel-principal\" *ngIf=\"listaBase\">");
		this.linha("		<div class=\"dgc-card\" *ngFor=\"let item of listaBase\">");
		this.linha(" 			<div class=\"dgc-card-header\">");
		this.linha(" 				<span>{{item.nome}}</span>");
		this.linha(" 			</div>");
		this.linha(" 			<div class=\"dgc-card-comandos\">");
		this.linha(" 				<button class=\"btn-primary btn-sm btn\" (click)=\"edita(item)\">Editar</button>");
		this.linha(" 			</div>");
		this.linha(" 		</div>");
		this.linha("  	</div>");
		this.linha("</div>");
	}
	
	

}
