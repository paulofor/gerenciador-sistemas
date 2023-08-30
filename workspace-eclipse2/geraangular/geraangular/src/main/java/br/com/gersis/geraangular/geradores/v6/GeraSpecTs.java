package br.com.gersis.geraangular.geradores.v6;

import java.io.IOException;

import br.com.gersis.geraangular.geradores.GeradorArquivoTela;
import br.com.gersis.loopback.modelo.Entidade;

public class GeraSpecTs extends GeradorArquivoTela {

	
	public GeraSpecTs(String nome) {
		super(nome);
	}


	@Override
	protected void geraArquivo() throws IOException {
		this.linha("import { async, ComponentFixture, TestBed } from '@angular/core/testing';");
		this.linha();
		this.linha("import { " + this.getTela().getComponent() +" } from './" + this.getTela().getNomeHifen() +".component';");
		this.linha();
		this.linha("describe('" + this.getTela().getComponent() + "', () => {");
		this.linha("	let component: " + this.getTela().getComponent() + ";");
		this.linha("	let fixture: ComponentFixture<" + this.getTela().getComponent() + ">;");
		this.linha();
		this.linha("	beforeEach(async(() => {");
		this.linha("		TestBed.configureTestingModule({");
		this.linha("			declarations: [ " + this.getTela().getComponent() + " ]");
		this.linha("		})");
		this.linha("		.compileComponents();");
		this.linha("	}));");
		this.linha();
		this.linha("	beforeEach(() => {");
		this.linha("		fixture = TestBed.createComponent(" + this.getTela().getComponent() + ");");
		this.linha("		component = fixture.componentInstance;");
		this.linha("		fixture.detectChanges();");
		this.linha("	});");
		this.linha();
		this.linha("	it('should create', () => {");
		this.linha("		expect(component).toBeTruthy();");
		this.linha("	});");
		this.linha("});");
		
	}

}
