package br.com.gersis.gerajava;

public abstract class GeradorArquivoJava extends GeradorArquivo {

	public GeradorArquivoJava(String nome) {
		super(nome);
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
		return nomePacote.substring(1,nomePacote.length()-1);
	}
	
	protected String getNomeClasse() {
		String paths[] = nomeArquivo.split("/");
		String nomeArquivo = paths[paths.length];
		// MeuArquivo.java
		// 012345678901234
		return nomeArquivo.substring(0, nomeArquivo.length() - 5);
	}
}
