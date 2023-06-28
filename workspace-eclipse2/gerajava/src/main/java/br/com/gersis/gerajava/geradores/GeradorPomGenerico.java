package br.com.gersis.gerajava.geradores;

import java.io.IOException;

import br.com.gersis.gerajava.GeradorArquivo;
import br.com.gersis.loopback.modelo.ProcessoJava;

public class GeradorPomGenerico  extends GeradorArquivo{

	String nomeArquivo;
	String idPrincipal;
	String idModulo;
	
	public GeradorPomGenerico(String nomeArquivo, String idPrincipal, String idModulo) {
		super(nomeArquivo);
		this.idModulo = idModulo;
		this.idPrincipal = idPrincipal;
	}
	
	public void gerar() throws IOException {
		this.criaArquivo();
		this.linha("<project xmlns=\"http://maven.apache.org/POM/4.0.0\"");
		this.linha("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
		this.linha("xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">");
		this.linha("	<modelVersion>4.0.0</modelVersion>");
		this.linha("	<parent>");
		this.linha("		<groupId>br.com.gersis</groupId>");
		this.linha("		<artifactId>" + idPrincipal + "</artifactId>");
		this.linha("		<version>1.0.0</version>");
		this.linha("	</parent>");
		this.linha("	<groupId>br.com.gersis</groupId>");
		this.linha("	<artifactId>" + idModulo + "</artifactId>");
		this.linha("	<version>1.0.0</version>");
		this.linha("	<!-- Outras configurações -->");
		this.linha("	<dependencies>");
		this.linha("		<dependency>");
		this.linha("			<groupId>org.json</groupId>");
		this.linha("			<artifactId>json</artifactId>");
		this.linha("			<version>20131018</version>");
		this.linha("		</dependency>");
		/*
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
		this.linha("			<groupId>com.ning</groupId>");
		this.linha("			<artifactId>async-http-client</artifactId>");
		this.linha("			<version>1.9.40</version>");
		this.linha("		</dependency>");
		this.linha("		<dependency>");
		this.linha("			<groupId>com.google.common</groupId>");
		this.linha("			<artifactId>google-collect</artifactId>");
		this.linha("			<version>0.5</version>");
		this.linha("		</dependency>");
		*/
		this.linha("	</dependencies>");
		this.linha("</project>");
		this.linha("");
		this.fecha();
	}

}
