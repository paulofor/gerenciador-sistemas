package br.com.gersis.geraangular.geradores;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorArquivo {

	private FileWriter fw;
	protected String nomeArquivo = null;
	
	public GeradorArquivo(String nome) {
		this.nomeArquivo = nome;
	}
	public void criaArquivo() throws IOException {
		fw = new FileWriter(nomeArquivo);
	}
	public boolean criaArquivoSeNaoExiste() throws IOException {
	    File arquivo = new File(nomeArquivo);
	    if (!arquivo.exists()) {
	        fw = new FileWriter(arquivo);
	        return true;
	    } else {
	    	fw = null;
	    	return false;
	    }
	}
	public void linha(String texto) throws IOException {
		fw.write(texto);
		fw.write("\n");
	}
	public void linha() throws IOException {
		fw.write("\n");
	}
	public void fecha() throws IOException {
		fw.close();
		System.out.println("Arquivo " + nomeArquivo + " gerado com sucesso.");
	}
	
	
}
