package br.com.gersis.geraangular.geradores.v6.detalhe;

import java.io.IOException;

import br.com.gersis.geraangular.geradores.v6.GeraTs;

public class GeraTsDetalhe extends GeraTs{

	
	public GeraTsDetalhe(String nome) {
		super(nome);
	}

	@Override
	public void gerar() throws IOException {
		this.criaArquivo();
		this.linha("import { OnInit } from \"@angular/core\";");
		this.linha("import { MatDialog } from \"@angular/material/dialog\";");
		this.linha("import { ActivatedRoute } from \"@angular/router\";");
		this.linha("import { "+ this.getEntidade().getNome() + " , " + this.getEntidade().getNome()+ "Api } from \"../shared/sdk\";");
		this.linha();
		this.linha("export class " + this.getTela().getNome() + "BaseComponent implements OnInit {");
		this.linha("	principal: " + this.getEntidade().getNome() + ";");
		this.linha("	idPrincipal: number;");
		this.linha("	constructor(protected srv: " + this.getEntidade().getNome() +"Api, protected router: ActivatedRoute, protected dialog: MatDialog) { }");
		this.linha();
		this.linha("	ngOnInit() {");
		this.linha("		this.carregaTela()");
		this.linha("	}");
		this.linha("	carregaTela() {");
		this.linha("		this.router.params.subscribe((params) => {");
		this.linha("		this.idPrincipal = params['id'];");
		this.linha("		this.srv.findById(this.idPrincipal, this.getFiltro())");
		this.linha("	 		.subscribe((result: " + this.getEntidade().getNome() + ") => {");
		this.linha("				this.principal = result;");
		this.linha("				console.log('principal:', this.principal);");
		this.linha("			})");
		this.linha("		})");
		this.linha("	}");
		this.linha("	getFiltro() {");
		this.linha("		return {}");
		this.linha("	}");
		this.linha("}");
		this.fecha();
	}

	

	
	
}
