package br.com.gersis.gerajava.geradores;

import java.io.File;
import java.io.IOException;
import java.util.List;

import br.com.gersis.gerajava.GeradorArquivoJava;
import br.com.gersis.loopback.modelo.Entidade;
import br.com.gersis.loopback.modelo.ProcessoJava;

public class DaoAplicacaoGerador extends GeradorBase {
	
	private ProcessoJava processo;
	private List<Entidade> listaEntidade;
	
	public void setProcessoJava(ProcessoJava processo) {
		this.processo = processo;
	}
	

	public void setListaEntidade(List<Entidade> listaEntidade) {
		this.listaEntidade = listaEntidade;
	}


	@Override
	public void gerar() throws IOException {
		String nomeArquivo = this.diretorioWorkspace + File.separator + this.processo.getNomeClasseMain().toLowerCase() + 
				"/src/main/java/gerador/" + this.processo.getNomeClasseMain().toLowerCase() + "/loopback/DaoAplicacao.java";
		GeradorArquivoJava arq = new GeradorArquivoJava(nomeArquivo);
		arq.criaArquivo();
		arq.linha();
		arq.linha("import com.strongloop.android.loopback.RestAdapter;");
		arq.linha();
		if (this.processo.getFazSsh()==1) {
			this.importSessaoSSH(arq);
		}
		arq.linha("import br.com.gersis.daobase.DaoBase;");
		arq.linha("import br.com.gersis.daobase.IDatasetComum;");
		arq.linha("import br.com.gersis.daobase.comum.DaoBaseComum;");
		arq.linha("import br.com.gersis.loopback.repositorio.*;");
		arq.linha();
		arq.linha("public abstract class DaoAplicacao extends DaoBase {");
		arq.linha();
		arq.linha("	private RestAdapter adapter = new RestAdapter(DaoBaseComum.urlLoopback);");
		for (Entidade entidade : this.listaEntidade) {
			arq.linha("	protected Repositorio" + entidade.getNome() + " rep" + entidade.getNome() + " = adapter.createRepository(Repositorio" + entidade.getNome() +".class);");
		}
		arq.linha();
		arq.linha();
		arq.linha("	@Override");
		arq.linha("	protected long getTempo() {");
		arq.linha("		return 5000;");
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
		if (this.processo.getFazSsh()==1) {
			this.geraSessaoSSH(arq);
		}
		
		arq.linha("}");
		arq.fecha();
	}
	
	private void importSessaoSSH(GeradorArquivoJava arq) throws IOException {
		arq.linha("import com.jcraft.jsch.ChannelSftp;");
		arq.linha("import com.jcraft.jsch.JSch;");
		arq.linha("import com.jcraft.jsch.Session;");
		arq.linha("import com.jcraft.jsch.SftpException;");

		arq.linha("import java.io.FileInputStream;");
		arq.linha("import java.util.Properties;");
	}
	
	
	private void geraSessaoSSH(GeradorArquivoJava arq) throws IOException {
		arq.linha();
		arq.linha("	protected void enviaParaServidor(String fonte, String destino) throws Exception {");
		arq.linha("		Properties prop = new Properties();");
		arq.linha("		String path = \"/etc/openai/config.properties\";");
		arq.linha("		FileInputStream input = new FileInputStream(path);");
		arq.linha("		prop.load(input);");
		arq.linha("		String passSSH = prop.getProperty(\"pass_ssh\");");
		arq.linha("		JSch jsch = new JSch();");
		arq.linha("		Session session = jsch.getSession(\"root\", \"191.252.92.222\", 22);");
		arq.linha("		session.setPassword(passSSH);");
		arq.linha("		java.util.Properties config = new java.util.Properties();");
		arq.linha("		config.put(\"StrictHostKeyChecking\", \"no\");");
		arq.linha("		session.setConfig(config);");
		arq.linha("		session.connect();");
		arq.linha("		ChannelSftp channelSftp = (ChannelSftp) session.openChannel(\"sftp\");");
		arq.linha("		channelSftp.connect();");
		arq.linha("		channelSftp.put(fonte, destino);");
		arq.linha("		channelSftp.exit();");
		arq.linha("		session.disconnect();");
		arq.linha("	} ");
		arq.linha();

	}

}
