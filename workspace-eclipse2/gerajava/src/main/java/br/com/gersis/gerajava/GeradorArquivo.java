package br.com.gersis.gerajava;

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
	public void linha(String texto) throws IOException {
		fw.write(texto);
		fw.write("\n");
	}
	public void fecha() throws IOException {
		fw.close();
		System.out.println("Arquivo " + nomeArquivo + " gerado com sucesso.");
	}
	
	
}
