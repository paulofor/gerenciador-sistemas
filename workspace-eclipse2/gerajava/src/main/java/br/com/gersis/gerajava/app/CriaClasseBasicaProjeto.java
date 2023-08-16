package br.com.gersis.gerajava.app;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.gersis.daobase.DaoBase;
import br.com.gersis.gerajava.GeradorArquivo;
import br.com.gersis.gerajava.GeradorArquivoJava;
import br.com.gersis.gerajava.geradores.DaoAplicacaoGerador;
import br.com.gersis.gerajava.geradores.DatasetAplicacaoGerador;
import br.com.gersis.gerajava.geradores.GeradorPassoProcesso;
import br.com.gersis.gerajava.geradores.GeradorPassoProcessoImpl;
import br.com.gersis.gerajava.geradores.GeradorPomGenerico;
import br.com.gersis.gerajava.geradores.ObjectGerador;
import br.com.gersis.gerajava.loopback.DaoAplicacao;
import br.com.gersis.gerajava.loopback.DatasetGersis;
import br.com.gersis.loopback.modelo.PassoProcessoJava;
import br.com.gersis.loopback.modelo.ProcessoJava;

public class CriaClasseBasicaProjeto extends DaoAplicacao {

	private DatasetGersis ds = null;
	private String diretorioApp = null;
	private String diretorioLoopback = null;
	private String diretorioPasso = null;
	private ProcessoJava processo = null;
	
	private String diretorioProjeto = null;
	private String pacotePrincipal = null;
	
	private String diretorioPassoImpl = null;
	
	@Override
	protected void executaImpl() {
		ds = (DatasetGersis) this.getComum();
		this.processo = ds.getProcessoCorrente();
		this.diretorioProjeto = ds.getNomePastaWorkspace() + File.separator + this.processo.getNomeClasseMain().toLowerCase();
		try {
			this.criaArquivosProjeto();
			this.criaPacoteFonte();
			this.criaArquivoMain();
			this.criaDatasetAplicacao();
			this.criaDaoAplicacao();
			if (processo.getPassoProcessoJavas().size()>1) {
				for (int i=0;i<processo.getPassoProcessoJavas().size();i++) {
					if (i==0) {
						this.criaPasso1(processo.getPassoProcessoJavas().get(i),processo.getPassoProcessoJavas().get(i+1),i); 
					} else {
						if (i==processo.getPassoProcessoJavas().size()-1) {
							this.criaPasso(processo.getPassoProcessoJavas().get(i),null,i);
						} else {
							this.criaPasso(processo.getPassoProcessoJavas().get(i),processo.getPassoProcessoJavas().get(i+1),i);
						}
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finalizar();
	}
	
	private void criaDaoAplicacao() throws IOException {
		DaoAplicacaoGerador daoAplicacaoGer = new DaoAplicacaoGerador();
		daoAplicacaoGer.setDiretorioWorkspace(ds.getNomePastaWorkspace());
		daoAplicacaoGer.setProcessoJava(processo);
		daoAplicacaoGer.setListaEntidade(ds.getSistema().getEntidades());
		daoAplicacaoGer.gerar();
	}
	private void criaDatasetAplicacao() throws IOException {
		DatasetAplicacaoGerador datasetGer = new DatasetAplicacaoGerador();
		datasetGer.setDiretorioWorkspace(ds.getNomePastaWorkspace());
		datasetGer.setProcesso(processo);
		datasetGer.gerar();
	}
	
	private void criaArquivosProjeto() throws IOException {
		//copiarDiretorio("projeto",this.diretorioProjeto);
		copiarDiretorio("daobase-arquivos",ds.getNomePastaWorkspace());
		String projetoClienteLoopback = ds.getNomePastaWorkspace() + File.separator + "loopback";
		copiarDiretorio("cliente-loopback-arquivos",projetoClienteLoopback);
		this.criaArquivoProject();
		
		String pomLookback = projetoClienteLoopback + File.separator + "pom.xml";
		GeradorPomGenerico pom = new GeradorPomGenerico(pomLookback, ds.getSistema().getSigla() , "loopback");
		pom.gerar();
		
		String pomDaobase =  ds.getNomePastaWorkspace() + File.separator + "daobase" + File.separator + "pom.xml";
		pom = new GeradorPomGenerico(pomDaobase, ds.getSistema().getSigla() , "daobase");
		pom.gerar();
	}
	
	private void criaPacoteFonte() {
		
		diretorioApp = ds.getNomePastaFonteCorrente() + "/app";
		diretorioLoopback = ds.getNomePastaFonteCorrente() + "/loopback";
		diretorioPasso = ds.getNomePastaFonteCorrente() + "/passo";
		diretorioPassoImpl = ds.getNomePastaFonteCorrente() + "/passo/impl";
		this.verificarECriarDiretorio(this.diretorioApp);
		this.verificarECriarDiretorio(this.diretorioLoopback);
		this.verificarECriarDiretorio(this.diretorioPasso);
		this.verificarECriarDiretorio(this.diretorioPassoImpl);
	}
	
	
	private void criaPasso(PassoProcessoJava passo,PassoProcessoJava proximo, int posicaoPasso) throws IOException {
		String diretorioPassos = ds.getNomePastaFonteCorrente() + "/passo";
		String nomeArquivo = diretorioPassos + File.separator + passo.getNomeClasse() + ".java";
		GeradorPassoProcesso arqPasso = new GeradorPassoProcesso(nomeArquivo,passo, proximo,this.processo, posicaoPasso);
		arqPasso.gerar();
		
		String diretorioPassosImpl = ds.getNomePastaFonteCorrente() + "/passo/impl";
		String nomeArquivoImpl = diretorioPassosImpl + File.separator + passo.getNomeClasse() + "Impl.java";
		GeradorPassoProcessoImpl arqPassoImpl = new GeradorPassoProcessoImpl(nomeArquivoImpl,passo, proximo,this.processo, posicaoPasso);
		arqPassoImpl.gerar();
	}
	private void criaPasso1(PassoProcessoJava passo, PassoProcessoJava proximo, int posicaoPasso) throws IOException {
		String diretorioPassos = ds.getNomePastaFonteCorrente() + "/passo";
		String nomeArquivo = diretorioPassos + File.separator + passo.getNomeClasse() + ".java";
		ObjectGerador arqPasso = new ObjectGerador(nomeArquivo,passo, proximo, this.processo, posicaoPasso);
		arqPasso.gerar();
	}
	
	private void criaArquivoProject() throws IOException {
		String nomeArquivoProject = this.diretorioProjeto + File.separator + ".project";
		GeradorArquivo arq = new GeradorArquivo(nomeArquivoProject);
		arq.criaArquivo();
		arq.linha("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		arq.linha("<projectDescription>");
		arq.linha("	<name>" +  this.processo.getNomeClasseMain().toLowerCase() + "</name>");
		arq.linha("	<comment></comment>");
		arq.linha("	<projects>");
		arq.linha("	</projects>");
		arq.linha("	<buildSpec>");
		arq.linha("		<buildCommand>");
		arq.linha("			<name>org.eclipse.jdt.core.javabuilder</name>");
		arq.linha("			<arguments>");
		arq.linha("			</arguments>");
		arq.linha("		</buildCommand>");
		arq.linha("		<buildCommand>");
		arq.linha("			<name>org.eclipse.m2e.core.maven2Builder</name>");
		arq.linha("			<arguments>");
		arq.linha("			</arguments>");
		arq.linha("			</buildCommand>");
		arq.linha("		</buildSpec>");
		arq.linha("		<natures>");
		arq.linha("	<nature>org.eclipse.jdt.core.javanature</nature>");
		arq.linha("		<nature>org.eclipse.m2e.core.maven2Nature</nature>");
		arq.linha("	</natures>");
		arq.linha("</projectDescription>");
		arq.fecha();
	}
	private void criaArquivoPom() throws IOException {
		String nomeArquivoPom = this.diretorioProjeto + File.separator + "pom.xml";
		GeradorArquivo arq = new GeradorArquivo(nomeArquivoPom);
		arq.criaArquivo();
		arq.linha("<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
		arq.linha("	xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">");
		arq.linha("	<modelVersion>4.0.0</modelVersion>");
		arq.linha("");
		arq.linha("	<groupId>validador.marketingdigital.integracao</groupId>");
		arq.linha("	<artifactId>" + this.processo.getNomeClasseMain().toLowerCase() + "</artifactId>");
		arq.linha("	<version>0.0.1-SNAPSHOT</version>");
		arq.linha("	<packaging>jar</packaging>");
		arq.linha("");
		arq.linha("	<name>" + this.processo.getNomeClasseMain().toLowerCase() + "</name>");
		arq.linha("	<url>http://maven.apache.org</url>");
		arq.linha("");
		arq.linha("	<properties>");
		arq.linha("		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>");
		arq.linha("	</properties>");
		arq.linha("");
		arq.linha("	<dependencies>");
		arq.linha("");
		arq.linha("		<dependency>");
		arq.linha("			<groupId>org.json</groupId>");
		arq.linha("			<artifactId>json</artifactId>");
		arq.linha("			<version>20131018</version>");
		arq.linha("		</dependency>");
		arq.linha("		<dependency>");
		arq.linha("			<groupId>junit</groupId>");
		arq.linha("			<artifactId>junit</artifactId>");
		arq.linha("			<version>3.8.1</version>");
		arq.linha("			<scope>test</scope>");
		arq.linha("		</dependency>");
		arq.linha("");
		arq.linha("		<dependency>");
		arq.linha("			<groupId>org.apache.httpcomponents</groupId>");
		arq.linha("			<artifactId>httpasyncclient</artifactId>");
		arq.linha("			<version>4.1.4</version>");
		arq.linha("		</dependency>");
		arq.linha("");
		arq.linha("		<dependency>");
		arq.linha("			<groupId>org.apache.httpcomponents</groupId>");
		arq.linha("			<artifactId>httpclient</artifactId>");
		arq.linha("			<version>4.5.9</version>");
		arq.linha("		</dependency>");
		arq.linha("");
		arq.linha("</dependencies>");
		arq.linha("</project>");
		arq.fecha();
	}
	
	
	
	private void criaArquivoMain() throws IOException {
		String nomeArquivoMain = this.diretorioApp + File.separator + processo.getNomeClasseMain() + ".java";
		String nomePacote = converteNomePacote(this.diretorioApp);
		GeradorArquivoJava arq = new GeradorArquivoJava(nomeArquivoMain);
		arq.criaArquivo();
		arq.linha("import java.io.FileInputStream;");
		arq.linha("import java.io.IOException;");
		arq.linha("import java.io.InputStream;");
		arq.linha("import java.util.Properties;");
		arq.linha("import java.io.FileWriter;");
		arq.linha("import java.io.PrintWriter;");
		arq.linha();
		arq.linha("import " + this.converteNomePacote(diretorioPasso) + ".*;");
		arq.linha("import " + this.converteNomePacote(diretorioPasso) + ".impl.*;");
		arq.linha("import br.com.gersis.daobase.comum.DaoBaseComum;");
		arq.linha("");
		arq.linha("public class " + processo.getNomeClasseMain() + " {");
		arq.linha("");
		arq.linha("	private static String UrlLoopback = \"\";");
		arq.linha("");
		arq.linha("	public static void main(String[] args) {");
		arq.linha("		System.out.print(\"" + this.processo.getNomeClasseMain() + "\");");

		LocalDateTime dataHoraAtual = LocalDateTime.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = dataHoraAtual.format(formatador);

		arq.linha("		System.out.println(\"(" + dataHoraFormatada +")\");");
		arq.linha("		try {");
		arq.linha("			carregaProp();");
		if (this.processo.getPassoProcessoJavas().size()==0) {
			throw new GeradorException("Processo " + this.processo.getNomeClasseMain() + " não possui passos");
		}
		PassoProcessoJava objeto = this.processo.getPassoProcessoJavas().get(0);
		arq.linha("			" + objeto.getNomeClasse() + " obj = new " + objeto.getNomeClasse() + "();");
		arq.linha("			obj.executa();");
		arq.linha("			System.out.println(\"finalizou\");");
		arq.linha("			System.exit(0);");
		arq.linha("		} catch (Exception e) {");
		arq.linha("			gravarErro(e);");
		arq.linha("		}");
		arq.linha("	}");
		arq.linha("");
		arq.linha();
		arq.linha("	private static void gravarErro(Exception e) {");
		arq.linha("		try {");
		arq.linha("			FileWriter fileWriter = new FileWriter(\"" + this.processo.getNomeClasseMain() + ".err\", true);");
		arq.linha("			PrintWriter printWriter = new PrintWriter(fileWriter);");
		arq.linha("			e.printStackTrace(printWriter);");
		arq.linha("			printWriter.close();");
		arq.linha("		} catch (IOException ex) {");
		arq.linha("			ex.printStackTrace();");
		arq.linha("		}");
		arq.linha("	}");
		arq.linha();
		arq.linha("	private static void carregaProp() throws IOException {");
		arq.linha("		//System.out.println(\"Dir:\" + System.getProperty(\"user.dir\"));");
		arq.linha("		//InputStream input = new FileInputStream(\"CriaPythonTreinoRede.config\");");
		arq.linha("		//Properties prop = new Properties();");
		arq.linha("		//prop.load(input);");
		arq.linha("		//UrlLoopback = prop.getProperty(\"loopback.url\");");
		arq.linha("		UrlLoopback = \"" + ds.getSistema().getUrlBackApi() + "\";");
		arq.linha("		DaoBaseComum.setUrl(UrlLoopback);");
		arq.linha("	}");
		arq.linha("");
		arq.linha("	private static void preparaComum() {");
		arq.linha("		DaoBaseComum.setUrl(UrlLoopback);");
		for (int i=0;i<this.processo.getPassoProcessoJavas().size()-1;i++) {
			arq.linha("		DaoBaseComum.setProximo(\"" + this.processo.getPassoProcessoJavas().get(i).getNomeClasse() +"\", new " + this.processo.getPassoProcessoJavas().get(i+1).getNomeClasse() +"Impl());");
		}
		arq.linha("	}");
		arq.linha("}");
        arq.fecha();
	}

	@Override
	protected DaoBase getProximo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void verificarECriarDiretorio(String nomeDiretorio) {
	    File diretorio = new File(nomeDiretorio);
        if (diretorio.exists()) {
            //System.out.println("O diretório já existe.");
        } else {
        	//System.out.println("Vai criar " + nomeDiretorio);
            boolean criado = diretorio.mkdir();
            if (criado) {
                System.out.println("Diretório criado com sucesso.");
            } else {
                System.out.println("Falha ao criar o diretório.");
            }
        }
    }

}
