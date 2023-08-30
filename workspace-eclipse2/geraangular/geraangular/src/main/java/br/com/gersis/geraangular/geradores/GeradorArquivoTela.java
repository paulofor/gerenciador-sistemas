package br.com.gersis.geraangular.geradores;

import java.io.IOException;

import br.com.gersis.loopback.modelo.Entidade;
import br.com.gersis.loopback.modelo.TelaFront;

public abstract class GeradorArquivoTela extends GeradorArquivo {


	private Entidade entidade;
	private TelaFront tela;
	
	public GeradorArquivoTela(String nome) {
		super(nome);
	}
	
	public final void gerar() throws IOException {
		this.criaArquivo();
		this.geraArquivo();
		this.fecha();
	}
	public final void gerarSeNaoExiste() throws IOException {
		if (this.criaArquivoSeNaoExiste()) {
			this.geraArquivo();
			this.fecha();
		}
		
	}
	protected abstract void geraArquivo() throws IOException;
	
	public final Entidade getEntidade() {
		return entidade;
	}
	public final void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}
	public final TelaFront getTela() {
		return tela;
	}
	public final void setTela(TelaFront tela) {
		this.tela = tela;
	}
	
	
}
