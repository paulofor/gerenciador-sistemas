package br.com.gersis.gerajava.geradores;

import java.io.IOException;

import br.com.gersis.gerajava.GeradorArquivo;
import br.com.gersis.loopback.modelo.ProcessoJava;
import br.com.gersis.loopback.modelo.Sistema;

public class GeradorPrincipalPom extends GeradorArquivo{

	Sistema sistema;
	
	
	public GeradorPrincipalPom(String nomeArquivo , Sistema sistema) {
		super(nomeArquivo);
		this.sistema = sistema;
	}

	
	public void gerar() throws IOException {
		this.criaArquivo();
		this.linha("<project xmlns=\"http://maven.apache.org/POM/4.0.0\"");
		this.linha("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
		this.linha("xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">");
		this.linha("	<modelVersion>4.0.0</modelVersion>");
		this.linha("	<groupId>br.com.gersis</groupId>");
		this.linha("	<artifactId>" + sistema.getSigla() + "</artifactId>");
		this.linha("	<version>1.0.0</version>");
		this.linha("	<packaging>pom</packaging>");
		this.linha("	<name>principal</name>");
		this.linha("	<modules>");
		this.linha("		<module>loopback</module>");
		this.linha("		<module>daobase</module>");
		for (ProcessoJava processo : this.sistema.getProcessoJavas()) {
			this.linha("		<module>" + processo.getNomeClasseMain().toLowerCase() + "</module>");
		}
		this.linha("	</modules>");
		this.linha("");
		this.linha("</project>");
		this.linha("");
		this.fecha();
	}
}
