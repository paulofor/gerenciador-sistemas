package br.com.gersis.geraangular.geradores.v6;

import java.io.IOException;

import br.com.gersis.geraangular.geradores.GeradorArquivoTela;
import br.com.gersis.loopback.modelo.Entidade;

public class GeraTs extends GeradorArquivoTela {


	public GeraTs(String nome) {
		super(nome);
	}


	public void gerar() throws IOException {
		this.criaArquivo();
		this.linha("import { Component, OnInit } from '@angular/core';");
		this.linha();
		this.linha("@Component({");
		this.linha("	selector: 'app-" + this.getTela().getNomeHifen() +"',");
		this.linha("  	templateUrl: './" + this.getTela().getNomeHifen() +".component.html',");
		this.linha("  	styleUrls: ['./" + this.getTela().getNomeHifen() +".component.css']");
		this.linha("})");
		this.linha("export class " + this.getTela().getComponent() +" extends " + this.getTela().getNome() + "BaseComponent {");
		this.logicaTela();
		this.linha("}");
		this.fecha();
	}
	
	protected void logicaTela() throws IOException {
		this.linha("	constructor() { }");
	}

}
