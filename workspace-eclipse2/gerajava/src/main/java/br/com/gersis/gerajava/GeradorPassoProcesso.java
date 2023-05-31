package br.com.gersis.gerajava;

import java.io.IOException;

import br.com.gersis.loopback.modelo.PassoProcessoJava;

public class GeradorPassoProcesso extends GeradorArquivoJava {
	
	private PassoProcessoJava passo = null;
	private String nomeArquivo = null;

	public GeradorPassoProcesso(String nome, PassoProcessoJava passo) throws IOException {
		super(nome);
		this.nomeArquivo = nome;
		this.passo = passo;
	}
	
	public void gerar() throws IOException {
		this.criaArquivo();
		this.linha("package " + this.getNomePacote());
		this.linha("public class " + this.getNomeClasse() + " { ");
		this.linha("}");
		this.fecha();
	}

}
