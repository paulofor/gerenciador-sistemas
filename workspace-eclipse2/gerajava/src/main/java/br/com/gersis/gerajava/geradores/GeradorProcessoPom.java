package br.com.gersis.gerajava.geradores;

import java.io.IOException;

import br.com.gersis.gerajava.GeradorArquivo;
import br.com.gersis.loopback.modelo.ProcessoJava;
import br.com.gersis.loopback.modelo.Sistema;

public class GeradorProcessoPom extends GeradorArquivo{

	
	ProcessoJava processo;
	Sistema sistema;
	
	
	public GeradorProcessoPom(String nomeArquivo , ProcessoJava processo, Sistema sistema) {
		super(nomeArquivo);
		this.processo = processo;
		this.sistema = sistema;
	}

	
	public void gerar() throws IOException {
		this.criaArquivo();
		this.linha("<project xmlns=\"http://maven.apache.org/POM/4.0.0\"");
		this.linha("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
		this.linha("xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">");
		this.linha("	<modelVersion>4.0.0</modelVersion>");
		this.linha("	<parent>");
		this.linha("		<groupId>br.com.gersis</groupId>");
		this.linha("		<artifactId>" + sistema.getSigla() + "</artifactId>");
		this.linha("		<version>1.0.0</version>");
		this.linha("	</parent>");
		this.linha("	<groupId>br.com.gersis</groupId>");
		this.linha("	<artifactId>" + processo.getNomeClasseMain().toLowerCase() + "</artifactId>");
		this.linha("	<version>1.0.0</version>");
		this.linha("	<!-- Outras configurações -->");
		this.linha("	<dependencies>");
		this.linha("		<dependency>");
		this.linha("			<groupId>com.squareup.okhttp3</groupId>");
		this.linha("			<artifactId>okhttp</artifactId>");
		this.linha("			<version>3.0.1</version>");
		this.linha("		</dependency>");
		this.linha("		<dependency>");
		this.linha("			<groupId>org.apache.httpcomponents</groupId>");
		this.linha("			<artifactId>httpasyncclient</artifactId>");
		this.linha("			<version>4.1.4</version>");
		this.linha("		</dependency>");
		this.linha("		<dependency>");
		this.linha("			<groupId>org.apache.httpcomponents</groupId>");
		this.linha("			<artifactId>httpclient</artifactId>");
		this.linha("			<version>4.5.9</version>");
		this.linha("		</dependency>");
		this.linha("		<dependency>");
		this.linha("			<groupId>br.com.gersis</groupId>");
		this.linha("			<artifactId>loopback</artifactId>");
		this.linha("			<version>1.0.0</version>");
		this.linha("		</dependency>");
		this.linha("	  	<dependency>");
		this.linha("	    	<groupId>br.com.gersis</groupId>");
		this.linha("			<artifactId>daobase</artifactId>");
		this.linha("			<version>1.0.0</version>");
		this.linha("		</dependency>");
		this.linha("	</dependencies>");
		this.linha("</project>");
		this.linha("");
		this.fecha();
	}
}
