package br.com.gersis.gerajava.app;

import java.io.File;
import java.io.IOException;

import br.com.gersis.daobase.DaoBase;
import br.com.gersis.gerajava.GeradorArquivo;
import br.com.gersis.gerajava.GeradorArquivoJava;
import br.com.gersis.gerajava.GeradorPassoProcesso;
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
	
	@Override
	protected void executaImpl() {
		// TODO Auto-generated method stub
		ds = (DatasetGersis) this.getComum();
		this.processo = ds.getProcessoCorrente();
		this.diretorioProjeto = ds.getNomePastaWorkspace() + File.separator + this.processo.getNomeClasseMain().toLowerCase();
		try {
			this.criaArquivosProjeto();
			this.criaPacoteFonte();
			this.criaArquivoMain();
			this.criaDataset();
			this.criaDaoAplicacao();
			for (PassoProcessoJava passo : processo.getPassoProcessoJavas()) {
        		criaPasso(passo);
    		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finalizar();
	}
	
	private void criaDataset() throws IOException {
		String nomeArquivo = this.diretorioLoopback + File.separator + "DaoAplicacao.java";
		GeradorArquivoJava arq = new GeradorArquivoJava(nomeArquivo);
		arq.criaArquivo();
		arq.linha();
		arq.linha("import com.strongloop.android.loopback.RestAdapter;");
		arq.linha();
		arq.linha("import br.com.gersis.daobase.DaoBase;");
		arq.linha("import br.com.gersis.daobase.IDatasetComum;");
		arq.linha("import br.com.gersis.daobase.comum.DaoBaseComum;");
		arq.linha();
		arq.linha("public abstract class DaoAplicacao extends DaoBase {");
		arq.linha();
		arq.linha("	private RestAdapter adapter = new RestAdapter(DaoBaseComum.urlLoopback);");
		arq.linha();
		arq.linha();
		arq.linha("	@Override");
		arq.linha("	protected long getTempo() {");
		arq.linha("		return 10000;");
		arq.linha("	}");
		arq.linha();
		arq.linha("	@Override");
		arq.linha("	protected IDatasetComum criaDataSet() {");
		arq.linha("		return new DatasetAplicacao();");
		arq.linha("	}");
		arq.linha();
		arq.linha("	@Override");
		arq.linha("	protected DaoBase getProximo() {");
		arq.linha("		return null;");
		arq.linha("	} ");
		arq.linha();
		arq.linha("}");
		arq.fecha();
	}
	private void criaDaoAplicacao() throws IOException {
		String nomeArquivo = this.diretorioLoopback + File.separator + "DatasetAplicacao.java";
		GeradorArquivoJava arq = new GeradorArquivoJava(nomeArquivo);
		arq.criaArquivo();
		arq.linha();
		arq.linha("import br.com.gersis.daobase.IDatasetComum;");
		arq.linha();
		arq.linha("public class DatasetAplicacao  implements IDatasetComum {");
		arq.linha("}");
		arq.fecha();
	}
	
	private void criaArquivosProjeto() throws IOException {
		copiarDiretorio("projeto",this.diretorioProjeto);
		copiarDiretorio("daobase-arquivos",ds.getNomePastaWorkspace());
		String projetoClienteLoopback = ds.getNomePastaWorkspace() + File.separator + "loopback";
		copiarDiretorio("cliente-loopback-arquivos",projetoClienteLoopback);
		this.criaArquivoProject();
	}
	
	private void criaPacoteFonte() {
		
		diretorioApp = ds.getNomePastaFonteCorrente() + "/app";
		diretorioLoopback = ds.getNomePastaFonteCorrente() + "/loopback";
		diretorioPasso = ds.getNomePastaFonteCorrente() + "/passo";
		this.verificarECriarDiretorio(this.diretorioApp);
		this.verificarECriarDiretorio(this.diretorioLoopback);
		this.verificarECriarDiretorio(this.diretorioPasso);
	}
	
	
	private void criaPasso(PassoProcessoJava passo) throws IOException {
		String diretorioPassos = ds.getNomePastaFonteCorrente() + "/passo";
		String nomeArquivo = diretorioPassos + File.separator + passo.getNomeClasse() + ".java";
		GeradorPassoProcesso arqPasso = new GeradorPassoProcesso(nomeArquivo,passo, this.processo);
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
		arq.linha("import " + this.converteNomePacote(diretorioPasso) + ".*;");
		arq.linha("");
		arq.linha("import br.com.gersis.daobase.comum.DaoBaseComum;");
		arq.linha("");
		arq.linha("public class " + processo.getNomeClasseMain() + " {");
		arq.linha("");
		arq.linha("	private static String UrlLoopback = \"\";");
		arq.linha("");
		arq.linha("	public static void main(String[] args) {");
		arq.linha("			System.out.print(\"" + this.processo.getNomeClasseMain() + "\");");
		arq.linha("			System.out.println(\"(22-05-2023)\");");
		arq.linha("		try {");
		arq.linha("			carregaProp();");
		PassoProcessoJava objeto = this.processo.getPassoProcessoJavas().get(1);
		arq.linha("			" + objeto.getNomeClasse() + " obj = new " + objeto.getNomeClasse() + "();");
		arq.linha("			obj.executa();");
		arq.linha("			System.exit(0);");
		arq.linha("		} catch (Exception e) {");
		arq.linha("			e.printStackTrace();");
		arq.linha("		}");
		arq.linha("	}");
		arq.linha("");
		arq.linha("	private static void carregaProp() throws IOException {");
		arq.linha("		//System.out.println(\"Dir:\" + System.getProperty(\"user.dir\"));");
		arq.linha("		//InputStream input = new FileInputStream(\"CriaPythonTreinoRede.config\");");
		arq.linha("		//Properties prop = new Properties();");
		arq.linha("		//prop.load(input);");
		arq.linha("		//UrlLoopback = prop.getProperty(\"loopback.url\");");
		arq.linha("		UrlLoopback = \"http://vps-40d69db1.vps.ovh.ca:23102/api\";");
		arq.linha("		DaoBaseComum.setUrl(UrlLoopback);");
		arq.linha("	}");
		arq.linha("");
		arq.linha("	private static void preparaComum() {");
		arq.linha("		DaoBaseComum.setUrl(UrlLoopback);");
		for (int i=0;i<this.processo.getPassoProcessoJavas().size()-1;i++) {
			arq.linha("		DaoBaseComum.setProximo(\"" + this.processo.getPassoProcessoJavas().get(i).getNomeClasse() +"\", new " + this.processo.getPassoProcessoJavas().get(i+1).getNomeClasse() +"());");
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
            System.out.println("O diretório já existe.");
        } else {
        	System.out.println("Vai criar " + nomeDiretorio);
            boolean criado = diretorio.mkdir();
            if (criado) {
                System.out.println("Diretório criado com sucesso.");
            } else {
                System.out.println("Falha ao criar o diretório.");
            }
        }
    }

}
