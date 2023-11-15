package br.com.gersis.geranodeloopback.geradores;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorArquivo {

	private FileWriter fw;
	protected String nomeArquivo = null;
	private String linhaBuffer1 = null;
	private String linhaBuffer2 = null;
	private boolean executouFlush1 = true;
	
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
	public void linhaBuffer1(String texto) {
		this.executouFlush1 = false;
		this.linhaBuffer1 = texto;
	}
	public void linhaBuffer2(String texto) {
		this.linhaBuffer2 = texto;
	}
	public void flush1() throws IOException {
		if (this.linhaBuffer1!=null)
			this.linha(linhaBuffer1);
		this.linhaBuffer1 = null;
		this.executouFlush1 = true;
	}
	public boolean executouFlush1() {
		return this.executouFlush1;
	}
	public void flush2() throws IOException {
		if (this.linhaBuffer2!=null)
			this.linha(linhaBuffer2);
		this.linhaBuffer2 = null;
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
