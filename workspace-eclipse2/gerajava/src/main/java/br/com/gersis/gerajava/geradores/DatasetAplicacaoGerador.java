package br.com.gersis.gerajava.geradores;

import java.io.File;
import java.io.IOException;

import br.com.gersis.gerajava.GeradorArquivoJava;
import br.com.gersis.loopback.modelo.DadoProcesso;
import br.com.gersis.loopback.modelo.ProcessoJava;

public class DatasetAplicacaoGerador extends GeradorBase{

	
	private ProcessoJava processo;
	
	
	
	public void setProcesso(ProcessoJava processo) {
		this.processo = processo;
	}



	@Override
	public void gerar() throws IOException {
		String nomeArquivo = this.diretorioWorkspace + File.separator + this.processo.getNomeClasseMain().toLowerCase() + 
				"/src/main/java/gerador/" + this.processo.getNomeClasseMain().toLowerCase() + "/loopback/DatasetAplicacao.java";
		GeradorArquivoJava arq = new GeradorArquivoJava(nomeArquivo);
		arq.criaArquivo();
		arq.linha();
		arq.linha("import br.com.gersis.daobase.IDatasetComum;");
		arq.linha("import br.com.gersis.loopback.modelo.*;");
		arq.linha("import java.util.List;");
		arq.linha();
		arq.linha("public class DatasetAplicacao  implements IDatasetComum {");
		for (DadoProcesso dado : this.processo.getDadoProcessos()) {
			arq.linha("	private " + dado.getTipoJava() + " " + dado.getNomeVariavel() + ";");
		}
		arq.linha();
		arq.linha();
		for (DadoProcesso dado : this.processo.getDadoProcessos()) {
			arq.linha("	public void set" + dado.getNomePropriedade() + "(" + dado.getTipoJava() + " valor) { ");
			arq.linha("		this." + dado.getNomeVariavel() + " = valor;");
			arq.linha("	}");
			arq.linha("	public " + dado.getTipoJava() + " get" + dado.getNomePropriedade() + "() { ");
			arq.linha("		return this." + dado.getNomeVariavel() + ";");
			arq.linha("	}");
		}
		arq.linha("}");
		arq.fecha();
	}

}
