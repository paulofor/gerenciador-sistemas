package br.com.gersis.gerajava.geradores;

import java.io.File;
import java.io.IOException;

import br.com.gersis.gerajava.GeradorArquivoJava;
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
		arq.linha();
		arq.linha("public class DatasetAplicacao  implements IDatasetComum {");
		arq.linha("}");
		arq.fecha();
	}

}
