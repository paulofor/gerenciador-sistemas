package br.com.gersis.geraangular.geradores.v6.edit;

import java.io.IOException;

import br.com.gersis.geraangular.geradores.v6.GeraTs;

public class GeraTsEditImpl  extends GeraTs{

	public GeraTsEditImpl(String nome) {
		super(nome);
	}

	public void geraArquivo() throws IOException {
		this.linha("import { Component, Inject } from '@angular/core';");
		this.linha("import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';");
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
		this.linha("	 constructor(protected dialogRef: MatDialogRef<any>");
		this.linha("	    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: " + this.getEntidade().getNome() +"Api");
		this.linha("		  ) {");
		this.linha("	   super(dialogRef,data,servico);");
		this.linha("	}");
		this.linha();
		this.linha("}");
	}
}
