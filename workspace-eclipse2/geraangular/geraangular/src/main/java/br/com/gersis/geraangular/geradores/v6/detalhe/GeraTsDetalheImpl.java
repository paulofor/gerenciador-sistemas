package br.com.gersis.geraangular.geradores.v6.detalhe;

import java.io.IOException;

import br.com.gersis.geraangular.geradores.v6.GeraTs;

public class GeraTsDetalheImpl  extends GeraTs{

	public GeraTsDetalheImpl(String nome) {
		super(nome);
	}

	public void gerar() throws IOException {
		this.criaArquivo();
		this.linha("import { Component, OnInit } from '@angular/core';");
		this.linha("import { MatDialog } from '@angular/material';");
		this.linha("import { ActivatedRoute } from '@angular/router';");
		this.linha("import { " + this.getEntidade().getNome() + "Api } from '../shared/sdk';");
		this.linha("import { " + this.getTela().getNome()+ "BaseComponent } from './" + this.getTela().getNomeHifen()+ "-base.component';");
		this.linha();
		this.linha("@Component({");
		this.linha("	selector: 'app-" + this.getTela().getNomeHifen() +"',");
		this.linha("  	templateUrl: './" + this.getTela().getNomeHifen() +".component.html',");
		this.linha("  	styleUrls: ['./" + this.getTela().getNomeHifen() +".component.css']");
		this.linha("})");
		this.linha("export class " + this.getTela().getComponent() +" extends " + this.getTela().getNome() + "BaseComponent {");
		this.linha();
		this.linha("	constructor(protected srv: " + this.getEntidade().getNome() +"Api, protected router: ActivatedRoute, protected dialog: MatDialog) { ");
		this.linha("		super(srv,router,dialog);");
		this.linha("	}");
		this.linha();
		this.linha("}");
		this.fecha();
	}
}
