package br.com.gersis.geraangular.geradores.v6.reledit;

import java.io.IOException;

import br.com.gersis.geraangular.geradores.v6.GeraTs;
import br.com.gersis.loopback.modelo.Entidade;

public class GeraTsEditRelImpl extends GeraTs{

	
	private Entidade entidade1;
	private Entidade entidade2;
	//private String propriedadeDestino;
	
	public GeraTsEditRelImpl(String nome) {
		super(nome);
	}

	@Override
	public void geraArquivo() throws IOException {
		
		this.entidade1 = this.getEntidade().getRelacionamentos1().get(0).getEntidade1();
		this.entidade2 = this.getEntidade().getRelacionamentos1().get(1).getEntidade1();
		
		this.linha("import { Component, Inject, OnInit } from '@angular/core';");
		this.linha("import { " + this.getTela().getNome() + "BaseComponent } from './arquivo-pagina-venda-edit-rel-base.component';");
		this.linha("import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';");
		this.linha("import { ImagemPaginaVendaApi, VersaoPaginaVendaApi, ArquivoPaginaVendaApi } from '../shared/sdk';");
		this.linha();
		this.linha("@Component({");
		this.linha("	selector: 'app-" + this.getTela().getNomeHifen() +"',");
		this.linha("  	templateUrl: './" + this.getTela().getNomeHifen() +".component.html',");
		this.linha("  	styleUrls: ['./" + this.getTela().getNomeHifen() +".component.css']");
		this.linha("})");
		this.linha();
		this.linha("export class " + this.getTela().getNome() + "Component extends " + this.getTela().getNome() + "BaseComponent {");
		this.linha("	constructor(protected dialogRef: MatDialogRef<any>, protected srv1:" + this.entidade1.getNome() + "Api, protected srv2:" + this.entidade2.getNome() + "Api, ");
		this.linha("		@Inject(MAT_DIALOG_DATA) protected data: any, protected srvRel : " + this.getEntidade().getNome() + "Api) { ");
		this.linha("			super(dialogRef,srv1,srv2,data,srvRel)");
		this.linha("	 }");
		this.linha("}");
	}
	
}
