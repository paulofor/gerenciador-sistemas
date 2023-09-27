package br.com.gersis.gerajava.geradores;

import java.io.IOException;

import br.com.gersis.gerajava.GeradorArquivoJava;
import br.com.gersis.gerajava.app.GeradorException;
import br.com.gersis.loopback.modelo.DadoProcessoSaidaRel;
import br.com.gersis.loopback.modelo.ParametroMetodoServer;
import br.com.gersis.loopback.modelo.PassoProcessoJava;
import br.com.gersis.loopback.modelo.ProcessoJava;

public class GeradorPassoProcesso extends GeradorArquivoJava {
	
	protected PassoProcessoJava passo = null;
	protected String nomeArquivo = null;
	protected ProcessoJava processo = null;
	protected PassoProcessoJava passoProximo = null;
	protected int posicaoPasso; 

	public GeradorPassoProcesso(String nome, PassoProcessoJava passo, PassoProcessoJava passoProximo, ProcessoJava processo, int posicaoPasso) throws IOException {
		super(nome);
		System.out.println(processo.getNomeClasseMain() + "." + passo.getNomeClasse() + " ( proximo: " + (passoProximo!=null?passoProximo.getNomeClasse():"-") + ")");
		this.nomeArquivo = nome;
		this.passo = passo;
		this.processo = processo;
		this.passoProximo = passoProximo;
		this.posicaoPasso = posicaoPasso;
	}
	
	public void gerar() throws IOException {
		this.criaArquivo();
		this.linha();
		this.linha("import gerador." + this.processo.getNomeClasseMain().toLowerCase() + ".loopback.DaoAplicacao;");
		this.linha("import gerador." + this.processo.getNomeClasseMain().toLowerCase() + ".loopback.DatasetAplicacao;");
		this.linha("import gerador." + this.processo.getNomeClasseMain().toLowerCase() + ".passo.impl.*;");
		this.linha("import br.com.gersis.daobase.*;");
		this.linha("import br.com.gersis.loopback.modelo.*;");
		this.linha();
		this.linha("import java.util.List;");
		this.linha("import com.strongloop.android.loopback.callbacks.*;");
		this.linha("");
		this.linha("");
		this.linha("public abstract class " + this.getNomeClasse() + " extends DaoAplicacao { ");
		this.linha();
		this.linha("	private int NUM_PASSO = " + this.posicaoPasso + ";");
		this.linha();
		this.linha();
		if (this.passo.getMetodoServer()!=null && this.passo.getMetodoServer().getParametroMetodoServers() != null) {
			for (ParametroMetodoServer param : this.passo.getMetodoServer().getParametroMetodoServers()) {
				if (param.getTipoJava(this.passo.getMetodoServer().getEntidade())!=null) {
					this.linha("	protected " + param.getTipoJava(this.passo.getMetodoServer().getEntidade()) + " " + param.getNome() + ";");
				} else {
					this.linha("	protected " + this.passo.getMetodoServer().getEntidade().getNome() + " " + param.getNome() + ";");
				}
			}
		}
		if (this.passo.getMetodoServer()==null) {
			this.linha("	// campos saida");
			for (DadoProcessoSaidaRel dado : this.passo.getDadoPassoSaida()) {
				this.linha("	protected " + dado.getDadoProcesso().getTipoJava() + "  saida" + dado.getDadoProcesso().getNomePropriedade()+ ";");
			}
		}
		this.linha();
		this.linha("	@Override");
		this.linha("	protected final void executaImpl() {");
		this.linha("		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();");
		this.linha("		if (executaCustom(" + this.passo.parametrosEntrada() + ")) {");
		if (this.passo.getMetodoServer()!=null) {
			if (this.passo.getMetodoServer().isList()) {
				String entradaFuncao = "";
				for (ParametroMetodoServer param : this.passo.getMetodoServer().getParametroMetodoServers()) {
					entradaFuncao += param.getNome() + ",";
				}
				
				this.linha("			rep" + this.passo.getMetodoServer().getEntidade().getNome() + "." + passo.getMetodoServer().getNomeHungara() + "( " + entradaFuncao + " new ListCallback<" + passo.getMetodoServer().getEntidade().getNome() + ">() { ");
				this.linha("				public void onSuccess(List<" + passo.getMetodoServer().getEntidade().getNome()+ "> lista) {");
				if (this.passoProximo!=null && this.passoProximo.getDentroLoop()==1) {
					this.linha("					for (" + this.passo.getMetodoServer().getEntidade().getNome() + " item : lista) {");
					if (this.passo.getDadoPassoSaida().size()==0) {
						throw new GeradorException("Passo " + this.passo.getNomeClasse() + " em " + this.processo.getNomeClasseMain() + " precisa ter dado de saída");
					}
					this.linha("						ds.set" + this.passo.getDadoPassoSaida().get(0).getDadoProcesso().getNomePropriedade() + "(item);");
					this.linha("						executaProximoSemFinalizar();");
					this.linha("					}");
					this.linha("					preFinalizar();");	
					this.linha("					finalizar();");
				} else {
					if (this.passo.getDadoPassoSaida().size()==0) {
						throw new GeradorException("Passo " + this.passo.getNomeClasse() + " em " + this.processo.getNomeClasseMain() + " precisa ter dado de saída");
					}
					this.linha("						ds.set" + this.passo.getDadoPassoSaida().get(0).getDadoProcesso().getNomePropriedade() + "(lista);");
					this.linha("						executaProximo();");
				}
				this.linha("				}");
			}
			if (this.passo.getMetodoServer().isObject()) {
				this.linha("			rep" + this.passo.getMetodoServer().getEntidade().getNome() + "." + passo.getMetodoServer().getNomeHungara() + "( " + this.passo.getMetodoServer().getParametroEntradaJava() + " new ObjectCallback<" + passo.getMetodoServer().getEntidade().getNome() + ">() { ");
				this.linha("				public void onSuccess(" + passo.getMetodoServer().getEntidade().getNome()+ " object) {");
				if (this.passo.getDadoPassoSaida().size()!=0) {
					this.linha("					ds.set" +  this.passo.getDadoPassoSaida().get(0).getDadoProcesso().getNomePropriedade() + "(object);");
				}
				this.linha("					//preFinalizar();");
				this.linha("					executaProximo();");
				this.linha("				}");
			}
			if (this.passo.getMetodoServer().isVoid()) {
				String entradaFuncao = "";
				for (ParametroMetodoServer param : this.passo.getMetodoServer().getParametroMetodoServers()) {
					entradaFuncao += param.getNome() + ",";
				}
				
				this.linha("			rep" + this.passo.getMetodoServer().getEntidade().getNome() + "." + passo.getMetodoServer().getNomeHungara() + "( " + entradaFuncao + " new VoidCallback() { ");
				this.linha("				public void onSuccess() {");
				this.linha("					executaProximo();");
				this.linha("				}");
			}
			this.linha("				public void onError(Throwable t) {");
			this.linha("					onErrorBase(t);");
			this.linha("				}");
			this.linha("			});");
		} else {
			for (DadoProcessoSaidaRel dado : this.passo.getDadoPassoSaida()) {
				this.linha("			ds.set" + dado.getDadoProcesso().getNomePropriedade()+ "(saida" + dado.getDadoProcesso().getNomePropriedade()+ ");");
			}
			this.linha("			executaProximo();");
		}
		this.linha("		} else {");
		if (this.passo.getMetodoServer()!=null) {
			this.linha("			executaProximo();");
		} else { 
			this.linha("			finalizar();");		
		}
		this.linha("		}");
		
		this.linha("	}"); 
		
		this.linha();
		this.linha();
		this.linha("	@Override");
		this.linha("	protected final DaoBase getProximo() {");
		if (this.passoProximo==null || this.passoProximo.isFinalizacao()) {
			this.linha("		return new DummyDaoBase();");
		} else {
			if (posicaoPasso==0) {
				this.linha("		return new " + this.passoProximo.getNomeClasse() + "();");
			} else {
				this.linha("		return new " + this.passoProximo.getNomeClasse() + "Impl();");
			}
			
		}
		this.linha("	}");
		this.linha();
		this.linha();
		this.linha("	protected boolean executaCustom(" + this.passo.parametrosEntradaComTipo() + ") { return true; }");
		this.linha();
		this.linha("	protected void preFinalizar() { return; }");
		this.linha();
		this.linha("	public int getNumPasso() {");
		this.linha("		return NUM_PASSO;");
		this.linha("	}");
		this.linha();
		this.linha();
		this.linha("}");
		this.linha();
		this.fecha();
	}

}
