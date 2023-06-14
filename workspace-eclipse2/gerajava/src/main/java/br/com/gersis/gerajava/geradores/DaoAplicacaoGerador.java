package br.com.gersis.gerajava.geradores;

import java.io.File;
import java.io.IOException;
import java.util.List;

import br.com.gersis.gerajava.GeradorArquivoJava;
import br.com.gersis.loopback.modelo.Entidade;
import br.com.gersis.loopback.modelo.ProcessoJava;

public class DaoAplicacaoGerador extends GeradorBase {
	
	private ProcessoJava processo;
	private List<Entidade> listaEntidade;
	
	public void setProcessoJava(ProcessoJava processo) {
		this.processo = processo;
	}
	

	public void setListaEntidade(List<Entidade> listaEntidade) {
		this.listaEntidade = listaEntidade;
	}


	@Override
	public void gerar() throws IOException {
		String nomeArquivo = this.diretorioWorkspace + File.separator + this.processo.getNomeClasseMain().toLowerCase() + 
				"/src/main/java/gerador/" + this.processo.getNomeClasseMain().toLowerCase() + "/loopback/DaoAplicacao.java";
		GeradorArquivoJava arq = new GeradorArquivoJava(nomeArquivo);
		arq.criaArquivo();
		arq.linha();
		arq.linha("import com.strongloop.android.loopback.RestAdapter;");
		arq.linha();
		arq.linha("import br.com.gersis.daobase.DaoBase;");
		arq.linha("import br.com.gersis.daobase.IDatasetComum;");
		arq.linha("import br.com.gersis.daobase.comum.DaoBaseComum;");
		arq.linha("import br.com.gersis.loopback.repositorio.*;");
		arq.linha();
		arq.linha("public abstract class DaoAplicacao extends DaoBase {");
		arq.linha();
		arq.linha("	private RestAdapter adapter = new RestAdapter(DaoBaseComum.urlLoopback);");
		for (Entidade entidade : this.listaEntidade) {
			arq.linha("	protected Repositorio" + entidade.getNome() + " rep" + entidade.getNome() + " = adapter.createRepository(Repositorio" + entidade.getNome() +".class);");
		}
		arq.linha();
		arq.linha();
		arq.linha("	@Override");
		arq.linha("	protected long getTempo() {");
		arq.linha("		return 10000;");
		arq.linha("	}");
		arq.linha();
		arq.linha("	@Override");
		arq.linha("	protected IDatasetComum criaDataSet() {");
		arq.linha("		return new DatasetAplicacao();");
		arq.linha("	}");
		arq.linha();
		arq.linha("	@Override");
		arq.linha("	protected DaoBase getProximo() {");
		arq.linha("		return null;");
		arq.linha("	} ");
		arq.linha();
		arq.linha("}");
		arq.fecha();
	}

}
