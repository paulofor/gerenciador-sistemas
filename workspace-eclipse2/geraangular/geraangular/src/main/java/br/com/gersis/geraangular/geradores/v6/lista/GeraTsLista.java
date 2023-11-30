package br.com.gersis.geraangular.geradores.v6.lista;

import java.io.IOException;

import br.com.gersis.geraangular.geradores.v6.GeraTs;

public class GeraTsLista extends GeraTs{

	
	public GeraTsLista(String nome) {
		super(nome);
	}

	@Override
	public void geraArquivo() throws IOException {
		this.linha("import { OnInit } from \"@angular/core\";");
		this.linha("import { MatDialog } from \"@angular/material/dialog\";");
		this.linha("import { ActivatedRoute } from \"@angular/router\";");
		this.linha("import { "+ this.getEntidade().getNome() + " , " + this.getEntidade().getNome()+ "Api } from \"../shared/sdk\";");
		this.linha("import { " + this.getEntidade().getNome()+ "EditComponent } from \"../" + this.getEntidade().getNomeHifen() + "-edit/" + this.getEntidade().getNomeHifen() + "-edit.component\";");
		this.linha();
		this.linha("export class " + this.getTela().getNome() + "BaseComponent implements OnInit {");
		this.linha("	principal: " + this.getEntidade().getNome() + ";");
		this.linha("	listaBase:"  + this.getEntidade().getNome() + "[]");
		this.linha("	idPrincipal: number;");
		this.linha("	constructor(protected srv: " + this.getEntidade().getNome() +"Api, protected router: ActivatedRoute, protected dialog: MatDialog) { }");
		this.linha();
		this.linha("	ngOnInit() {");
		this.linha("    	this.preCarregaTela();");
		this.linha("       	this.carregaTela();");
		this.linha("   	}");
		this.linha();
		this.linha("    preCarregaTela() {}");
		this.linha("	posCarregaLista() {}");
		this.linha();
		this.linha("    carregaTela() {");
		if (this.getTela().getMetodoServer()==null) {
			this.linha("        this.srv.find(this.getFiltro())");
		} else {
			this.linha("        this.srv." + this.getTela().getMetodoServer().getNome() + "()");
		}
		this.linha("	     .subscribe((result:" + this.getEntidade().getNome() + "[]) => {");
		this.linha("            console.log('result: ' , result);");
		this.linha("            this.listaBase = result;");
		this.linha("            this.posCarregaLista();");
		this.linha("        })");
		this.linha("    }");
		this.linha();
		this.linha("	edita(edicao?) {");
		this.linha("		this.dialog.afterAllClosed.subscribe(result => {");
		this.linha("			this.carregaTela();");
		this.linha("		});");
		this.linha("		this.dialog.open(this.getComponente(), {");
		this.linha("			width: '800px',");
		this.linha("			data: {");
		this.linha("				item: edicao");
		this.linha("			}");
		this.linha("		});");
		this.linha("	}");
		this.linha("	getComponente() : any {");
		this.linha("		return " + this.getEntidade().getNome() + "EditComponent");
		this.linha("	}");
		this.linha();
		this.linha();
		this.linha("	dialogo1(dados) {");
		this.linha("        console.log('dialogo1.dados:' , dados);");
		this.linha("        this.dialog.afterAllClosed.subscribe(result => {");
		this.linha("            this.carregaTela();");
		this.linha("        });");
		this.linha("        this.dialog.open(this.getDialogo1(), {");
		this.linha("            width: '800px',");
		this.linha("            data: dados");
		this.linha("        });");
		this.linha("	}");
		this.linha("	getDialogo1() : any {");
		this.linha("	}");
		this.linha();
		this.linha();
		this.linha("    dialogo2(dados) {");
		this.linha("    	console.log('dialogo2.dados:' , dados);");
		this.linha("    	this.dialog.afterAllClosed.subscribe(result => {");
		this.linha(" 			this.carregaTela();");
		this.linha("   		});");
		this.linha("   		this.dialog.open(this.getDialogo2(), {");
		this.linha("			width: '800px',");
		this.linha("   			data: dados");
		this.linha("  		});");
		this.linha("  	}");
		this.linha(" 	getDialogo2() : any {");
		this.linha("    }");
		this.linha();
		this.linha();
		this.linha("	getFiltro() {");
		this.linha("		return {}");
		this.linha("	}");
		this.linha("}");
	}

	

	
	
}
