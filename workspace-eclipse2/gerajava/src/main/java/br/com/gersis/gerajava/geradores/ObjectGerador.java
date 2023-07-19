package br.com.gersis.gerajava.geradores;

import java.io.IOException;

import br.com.gersis.loopback.modelo.PassoProcessoJava;
import br.com.gersis.loopback.modelo.ProcessoJava;

public class ObjectGerador extends GeradorPassoProcesso {


	
	

	public ObjectGerador(String nome, PassoProcessoJava passo, PassoProcessoJava passoProximo, ProcessoJava processo, int posicaoPasso)
			throws IOException {
		super(nome, passo, passoProximo, processo, posicaoPasso);

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
		this.linha("		" + passoProximo.getNomeClasse() + " exec = new " + passoProximo.getNomeClasse() + "();");
		this.linha("		exec.setComum(ds);");
		this.linha("		exec.executa();");
		this.linha("		finalizar();");
		this.linha("	}"); 
		this.linha("	public int getNumPasso() {");
		this.linha("		return 1;");
		this.linha("	}");
		this.linha("}");
		this.linha();
		this.fecha();
	}
}
