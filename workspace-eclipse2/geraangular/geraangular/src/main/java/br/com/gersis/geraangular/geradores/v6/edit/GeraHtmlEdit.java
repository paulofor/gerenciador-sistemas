package br.com.gersis.geraangular.geradores.v6.edit;

import java.io.IOException;

import br.com.gersis.geraangular.geradores.v6.GeraHtml;

public class GeraHtmlEdit extends GeraHtml {

	public GeraHtmlEdit(String nome) {
		super(nome);
	}

	
	
	
	@Override
	protected void geraArquivo() throws IOException {
		this.linha("<h2 *ngIf=\"item\" mat-dialog-title>" + this.getEntidade().getNome() + "</h2>");
		this.linha();
		this.linha("<form *ngIf=\"item\" class=\"example-full-width\" (ngSubmit)=\"onSubmit()\">");
		this.linha();
		this.linha("	<mat-dialog-content>");
		this.linha();
		this.linha("		<mat-form-field class=\"example-full-width\">");
		this.linha("		<input matInput #nome [(ngModel)]=\"item.nome\" name=\"nome\" placeholder=\"Nome\" />");
		this.linha("		</mat-form-field>");
		this.linha();
		this.linha();
		this.linha("	</mat-dialog-content>");
		this.linha();
		this.linha("	<mat-dialog-actions>");
		this.linha("		<button mat-raised-button>Salvar</button>");
		this.linha("		<button mat-raised-button mat-dialog-close>Fechar</button>");
		this.linha("	</mat-dialog-actions>");
		this.linha("");
		this.linha("</form>");
	}


}
	