package br.com.gersis.gerajava;

import java.io.IOException;

public class GeradorArquivoJava extends GeradorArquivo {

	public GeradorArquivoJava(String nome) {
		super(nome);
	}
	
	

	@Override
	public void criaArquivo() throws IOException {
		super.criaArquivo();
		this.linha("package " + getNomePacote() + ";");
		this.linha("");
	}



	protected String getNomePacote() {
		String nomePacote = "";
		String paths[] = nomeArquivo.split("/");
		boolean valendo = false;
		for (int i=0;i<paths.length-1;i++) {
			if (!valendo) {
				if ("java".compareTo(paths[i])==0) {
					valendo = true;
				}
			} else {
				nomePacote += "." + paths[i];
			}
		}
		return nomePacote.substring(1,nomePacote.length());
	}
	
	protected String getNomeClasse() {
		String paths[] = nomeArquivo.split("/");
		String nomeArquivo = paths[paths.length-1];
		// MeuArquivo.java
		// 012345678901234
		return nomeArquivo.substring(0, nomeArquivo.length() - 5);
	}
}
