package br.com.gersis.gerajava.geradores;

import java.io.IOException;

import br.com.gersis.gerajava.GeradorArquivoJava;
import br.com.gersis.loopback.modelo.PassoProcessoJava;
import br.com.gersis.loopback.modelo.ProcessoJava;

public class GeradorPassoProcesso extends GeradorArquivoJava {
	
	protected PassoProcessoJava passo = null;
	protected String nomeArquivo = null;
	protected ProcessoJava processo = null;
	protected PassoProcessoJava passoProximo = null;;

	public GeradorPassoProcesso(String nome, PassoProcessoJava passo, PassoProcessoJava passoProximo, ProcessoJava processo) throws IOException {
		super(nome);
		this.nomeArquivo = nome;
		this.passo = passo;
		this.processo = processo;
		this.passoProximo = passoProximo;
	}
	
	public void gerar() throws IOException {
		this.criaArquivo();
		this.linha("");
		this.linha("import gerador." + this.processo.getNomeClasseMain().toLowerCase() + ".loopback.DaoAplicacao;");
		this.linha("import gerador." + this.processo.getNomeClasseMain().toLowerCase() + ".loopback.DatasetAplicacao;");
		this.linha("import br.com.gersis.daobase.DaoBase;");
		this.linha("import br.com.gersis.daobase.IDatasetComum;");
		this.linha("import br.com.gersis.loopback.modelo.*;");
		this.linha();
		this.linha("import java.util.List;");
		this.linha("import com.strongloop.android.loopback.callbacks.*;");
		this.linha("");
		this.linha("");
		this.linha("public class " + this.getNomeClasse() + " extends DaoAplicacao { ");
		this.linha();
		this.linha("	@Override");
		this.linha("	protected void executaImpl() {");
		this.linha("		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();");
		if (this.passo.getMetodoServer()!=null) {
			if (this.passo.getMetodoServer().isList()) {
				this.linha("		rep" + this.passo.getMetodoServer().getEntidade().getNome() + "." + passo.getMetodoServer().getNomeHungara() + "( new ListCallback<" + passo.getMetodoServer().getEntidade().getNome() + ">() { ");
				this.linha("			public void onSuccess(List<" + passo.getMetodoServer().getEntidade().getNome()+ "> lista) {");
				if (this.passoProximo.getDentroLoop()==1) {
					this.linha("				for (" + this.passo.getMetodoServer().getEntidade().getNome() + " item : lista) {");
					this.linha("					ds.set" + this.passo.getDadoPassoSaida().get(0).getDadoProcesso().getNomePropriedade() + "(item);");
					this.linha("					executaProximoSemFinalizar();");
					this.linha("				}");
				}
				this.linha("				finalizar();");
				this.linha("			}");
			}
			if (this.passo.getMetodoServer().isObject()) {
				this.linha("		rep" + this.passo.getMetodoServer().getEntidade().getNome() + "." + passo.getMetodoServer().getNomeHungara() + "( new ObjectCallback<" + passo.getMetodoServer().getEntidade().getNome() + ">() { ");
				this.linha("			public void onSuccess(" + passo.getMetodoServer().getEntidade().getNome()+ " object) {");
				this.linha("				finalizar();");
				this.linha("			}");
			}
			if (this.passo.getMetodoServer().isVoid()) {
				this.linha("		rep" + this.passo.getMetodoServer().getEntidade().getNome() + "." + passo.getMetodoServer().getNomeHungara() + "( new VoidCallback<" + passo.getMetodoServer().getEntidade().getNome() + ">() { ");
				this.linha("			public void onSuccess() {");
				this.linha("				finalizar();");
				this.linha("			}");
			}
			this.linha("			public void onError(Throwable t) {");
			this.linha("				onErrorBase(t);");
			this.linha("			}");
			this.linha("		});");
		}
		this.linha("	}"); 
		this.linha();
		this.linha();
		this.linha("	@Override");
		this.linha("	protected DaoBase getProximo() {");
		if (this.passoProximo==null) {
			this.linha("		return null;");
		} else {
			this.linha("		return new " + this.passoProximo.getNomeClasse() + "();");
		}
		this.linha("	}");
		this.linha("}");
		this.linha();
		this.fecha();
	}

}
