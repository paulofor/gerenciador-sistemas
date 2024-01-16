package br.com.gersis.geraangular.geradores.v6.reledit;

import java.io.IOException;

import br.com.gersis.geraangular.geradores.v6.GeraTs;
import br.com.gersis.loopback.modelo.Entidade;

public class GeraTsEditRel extends GeraTs {

	
	private Entidade entidade1;
	private Entidade entidade2;
	private String propriedadeDestino;
	
	public GeraTsEditRel(String nome) {
		super(nome);

	}

	@Override
	public void geraArquivo() throws IOException {
		
		
		this.entidade1 = this.getEntidade().getRelacionamentos1().get(0).getEntidade1();
		this.entidade2 = this.getEntidade().getRelacionamentos1().get(1).getEntidade1();
		
		
		this.linha("import { Inject, OnInit } from \"@angular/core\";");
		this.linha("import { MAT_DIALOG_DATA, MatDialogRef } from \"@angular/material/dialog\";");
		//this.linha("import { ActivatedRoute } from \"@angular/router\";");
		this.linha("import { " + this.entidade1.getNome() + ", " + this.entidade2.getNome() + ", " + this.entidade1.getNome() + "Api, " + this.entidade2.getNome() + "Api, BaseLoopBackApi } from \"../shared/sdk\";");
		this.linha("import { " + this.getEntidade().getNome() + ", " + this.getEntidade().getNome() + "Api } from \"../shared/sdk\";");

		
		this.linha("export class " + this.getTela().getNome() + "BaseComponent implements OnInit {");
		this.linha();
		this.linha("	principal: any");
		this.linha("	srvOrigem : BaseLoopBackApi");
		this.linha("	srvDestino : BaseLoopBackApi");
		this.linha("	listaBase : any[]");
		this.linha("	propriedadeDestino : string");
		this.linha("	propriedadeOrigem : string");
		this.linha();
		this.linha("	constructor(protected dialogRef: MatDialogRef<any>, protected srv1:" + this.entidade1.getNome() + "Api, protected srv2:" + this.entidade2.getNome() + "Api, ");
		this.linha("		@Inject(MAT_DIALOG_DATA) protected data: any, protected srvRel : " + this.getEntidade().getNome() + "Api) { }");
		this.linha();
		this.linha("	ngOnInit() {");
		this.linha("		if (this.data.origem) {");
		this.linha("			this.principal = this.data.origem;");
		this.linha("			if (this.principal instanceof " + this.entidade1.getNome() + ") {");
		this.linha("				this.srvOrigem = this.srv1");
		this.linha("				this.srvDestino = this.srv2");
		this.linha("				this.propriedadeDestino = '" + this.entidade2.getNomeVariavel() + "';");
		this.linha("				this.propriedadeOrigem = '" + this.entidade1.getNomeVariavel() + "';");
		this.linha("			} else {");
		this.linha("				this.srvOrigem = this.srv2");
		this.linha("				this.srvDestino = this.srv1");
		this.linha("				this.propriedadeDestino = '" + this.entidade1.getNomeVariavel() + "';");
		this.linha("				this.propriedadeOrigem = '" + this.entidade2.getNomeVariavel() + "';");
		this.linha("			}");
		this.linha("			this.carregaTela();");
		this.linha("		}");
		this.linha("		//this.preCarregaTela();");
		this.linha("	}");
		this.linha();
		this.linha("	carregaTela() {");
		this.linha("		this.srvDestino.find(this.getFiltro())");
		this.linha("			.subscribe((result:any[]) => {");
		this.linha("				this.listaBase = result;");
		this.linha("			})");
		this.linha("	}");
		this.linha();
		this.linha("	posCarregaLista() {}");
		this.linha();
		this.linha();
		this.linha("	getFiltro() {");
		this.linha("		return {");
	    this.linha("  			'include' : {");
	    this.linha("    		'relation' : '" + this.getEntidade().getNomeVariavel() + "s',");
	    this.linha("    		'scope' : {");
	    this.linha("      			'where' : {'" + this.entidade1.getNomeVariavel() + "Id' : this.principal.id }");
	    this.linha("    		} ");
	    this.linha("    		} ");
	    this.linha("    	} ");
	    this.linha("  	}");
		this.linha();
		this.linha("	getCheck(item:any) : boolean {");
		this.linha("    	return (item['" + this.getEntidade().getNomeVariavel() + "s'].length>0);");
		this.linha("  	}");
		this.linha();
		this.linha();
		

		this.linha("	onChange(event, index, item : any) {");
		this.linha("		if (event.checked) {");
		this.linha("			let relNovo = new " +  this.getEntidade().getNome() + "();");
		this.linha("			relNovo[this.propriedadeOrigem  + 'Id'] = this.principal.id;");
		this.linha("			relNovo[this.propriedadeDestino + 'Id'] = item.id;");
		this.linha("			item['" + this.getEntidade().getNomeVariavel() + "s'].push(relNovo);");
		this.linha("		} else {");
		this.linha("			item['" + this.getEntidade().getNomeVariavel() + "s'] = [];");
		this.linha("		}");
		this.linha("	}");
		this.linha("	");	  
		this.linha("	onSubmit() {");
		this.linha("		let listaEnvio:any[] = [];");
		this.linha("		for(let i=0;i<this.listaBase.length;i++) {");
		this.linha("			if (this.listaBase[i]['" + this.getEntidade().getNomeVariavel() + "s'].length>0) {");
		this.linha("				listaEnvio.push(this.listaBase[i]['" + this.getEntidade().getNomeVariavel() + "s'][0]);");
		this.linha("			}");
		this.linha("		}");
		this.linha("		if (!this.srvRel['AtualizaRelacionamento']) {");
		this.linha("			console.log('Não existe AtualizaRelacionamento em ' , this.srvRel);");
		this.linha("		}");
		this.linha("		this.srvRel['AtualizaRelacionamento'](this.principal.id, listaEnvio)");
		this.linha("			.subscribe((resultado) => {");
		this.linha("				this.dialogRef.close('Pizza!');");
		this.linha("			})");
		this.linha("	}");
		this.linha();		
		this.linha();		
		this.linha("}");
																																																										
	}

}
