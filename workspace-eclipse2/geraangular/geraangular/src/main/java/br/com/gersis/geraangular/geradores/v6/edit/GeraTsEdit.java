package br.com.gersis.geraangular.geradores.v6.edit;

import java.io.IOException;

import br.com.gersis.geraangular.geradores.v6.GeraTs;

public class GeraTsEdit extends GeraTs{

	
	public GeraTsEdit(String nome) {
		super(nome);
	}

	@Override
	public void geraArquivo() throws IOException {
		this.linha("import { Inject, OnInit } from \"@angular/core\";");
		this.linha("import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';");
		this.linha("import { " + this.getEntidade().getNome() + ", " + this.getEntidade().getNome() + "Api } from \"../shared/sdk\";");
		this.linha();
		this.linha("export class " + this.getTela().getNome() + "BaseComponent implements OnInit{");
		this.linha();
		this.linha("	itemPre: any;");
		this.linha("	item: " + this.getEntidade().getNome() + ";");
		this.linha("	origem: any;");
		this.linha();
		this.linha("    constructor(protected dialogRef: MatDialogRef<any>");
		this.linha("        , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: " + this.getEntidade().getNome() + "Api,");
		this.linha("      ) {");
		this.linha("    }");
		this.linha();
		this.linha();
		this.linha("	ngOnInit() {");
		this.linha("		console.log(\"Data(BaseEdit):\", this.data);");
		this.linha(" 		if (this.data.origem) {");
		this.linha(" 			this.origem = this.data.origem;");
		this.linha(" 		}");
		this.linha("  		if (!this.data.item) {");
		this.linha("  			console.log(\"fluxo nova\");");
		this.linha("  			this.item = this.criaItem();");
		this.linha("  		} else {");
		this.linha("  			console.log('fluxo altera');");
		this.linha("  			this.item = this.data.item;");
		this.linha("  			console.log('Item(BaseEdit):', this.item);");
		this.linha("  		}");
		this.linha("  		this.montaCombos();");
		this.linha("   		this.posItem();");
		this.linha(" 	}");
		this.linha();
		this.linha(" 	onSubmit() {");
		this.linha("		this.preSubmit();");
		this.linha("	    console.log('Submit(BaseEdit):' , this.item);");
		this.linha("	    this.servico.upsert(this.item, (err, obj) => {");
		this.linha("	    	if (err) {");
		this.linha("	    		console.log(\"ErroUpsert:\" + JSON.stringify(err));");
		this.linha("		 	} else {");
		this.linha("     		}");
		this.linha("    		this.posSubmit();");
		this.linha("    	}).subscribe((e: any) => {");
		this.linha("    		console.log(JSON.stringify(e));");
		this.linha("   			this.closeDialog();");
		this.linha("  		});");
		this.linha("  	}");
		this.linha();
		this.linha("	preSubmit() {");
		this.linha("	}");
		this.linha("	closeDialog() {");
		this.linha("		this.dialogRef.close('Pizza!');");
		this.linha("	}");
		this.linha("	criaItem() {");
		this.linha("   		return new " + this.getEntidade().getNome() + "();");
		this.linha("	}");
		this.linha("	montaCombos() {");
		this.linha("	}");
		this.linha("	posItem() {");
		this.linha("	}");
		this.linha("	posSubmit() {");
		this.linha("	}");
		this.linha("}");
	}

	

	
	
}
