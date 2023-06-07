package br.com.gersis.gerajava;

import java.io.IOException;

import br.com.gersis.loopback.modelo.PassoProcessoJava;
import br.com.gersis.loopback.modelo.ProcessoJava;

public class GeradorPassoProcesso extends GeradorArquivoJava {
	
	private PassoProcessoJava passo = null;
	private String nomeArquivo = null;
	private ProcessoJava processo = null;

	public GeradorPassoProcesso(String nome, PassoProcessoJava passo, ProcessoJava processo) throws IOException {
		super(nome);
		this.nomeArquivo = nome;
		this.passo = passo;
		this.processo = processo;
	}
	
	public void gerar() throws IOException {
		this.criaArquivo();
		this.linha("");
		this.linha("import gerador." + this.processo.getNomeClasseMain().toLowerCase() + ".loopback.DaoAplicacao;");
		this.linha("import gerador." + this.processo.getNomeClasseMain().toLowerCase() + ".loopback.DatasetAplicacao;");
		this.linha("import br.com.gersis.daobase.DaoBase;");
		this.linha("import br.com.gersis.daobase.IDatasetComum;");
		this.linha("");
		this.linha("public class " + this.getNomeClasse() + " extends DaoAplicacao { ");
		this.linha();
		this.linha("	@Override");
		this.linha("	protected void executaImpl() {");
		this.linha("		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();");
		this.linha("	}"); 
		this.linha("}");
		this.linha();
		this.fecha();
	}

}
