package br.com.gersis.gerajava.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import br.com.gersis.daobase.DaoBase;
import br.com.gersis.gerajava.geradores.GeradorPrincipalPom;
import br.com.gersis.gerajava.geradores.GeradorProcessoPom;
import br.com.gersis.gerajava.geradores.ModelGerador;
import br.com.gersis.gerajava.geradores.RepositorioGerador;
import br.com.gersis.gerajava.loopback.DaoAplicacao;
import br.com.gersis.gerajava.loopback.DatasetGersis;
import br.com.gersis.loopback.modelo.Entidade;
import br.com.gersis.loopback.modelo.ProcessoJava;
import br.com.gersis.loopback.modelo.Sistema;

public class CriaProjeto extends DaoAplicacao {

	private Sistema sistema = null;
	private String pathWorkspace = null;
	private File directory = null;
	private DatasetGersis ds = null;
	
	private String diretorioPassos = null;
	
	
	@Override
	protected void executaImpl() {
		ds = (DatasetGersis) this.getComum();
		sistema = ds.getSistema();
        try {
        	criaWorkspace();
        	for (ProcessoJava processo:sistema.getProcessoJavas()) {
           		ds.setProcessoCorrente(processo);
         		criaProjeto(processo);
        		executaProximoSemFinalizar();
        	}
        	ModelGerador model = new ModelGerador();
        	RepositorioGerador repositorio = new RepositorioGerador();
        	model.setDiretorioWorkspace(ds.getNomePastaWorkspace());
        	repositorio.setDiretorioWorkspace(ds.getNomePastaWorkspace());
        	for (Entidade entidade:sistema.getEntidades()) {
        		model.setEntidade(entidade);
        		repositorio.setEntidade(entidade);
        		model.gerar();
        		repositorio.gerar();
        	}
        	finalizar();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	
	private void criaWorkspace() throws IOException {
		this.pathWorkspace = sistema.getPathProjeto() + File.separator + NOME_WORKSPACE;
		ds.setNomePastaWorkspace(pathWorkspace);
		directory = new File(this.pathWorkspace);
        if (!directory.exists()) {
        	directory.mkdirs(); // Cria o diretório se ele não existir
        }
        
        String nomeArquivo = this.pathWorkspace + File.separator + "pom.xml";
        GeradorPrincipalPom pomPrincipal = new GeradorPrincipalPom(nomeArquivo, sistema);
        pomPrincipal.gerar();
        //copiarDiretorioSeNaoVazio("arquivos",this.pathWorkspace);
	}
	
	
	private void criaProjeto(ProcessoJava processo) throws IOException {
		String nomePasta = this.pathWorkspace ;
		this.verificarECriarDiretorio(nomePasta);
		String nomePastaFonteJava = processo.getNomeClasseMain().toLowerCase() + "/src/main/java/gerador/" + processo.getNomeClasseMain().toLowerCase();
		this.verificaECriaSubdiretorios(nomePasta, nomePastaFonteJava);
		ds.setNomePastaFonteCorrente(nomePasta + File.separator + nomePastaFonteJava);
		
		String arquivoPom = nomePasta + File.separator + processo.getNomeClasseMain().toLowerCase() + File.separator + "pom.xml";
		GeradorProcessoPom pom =  new GeradorProcessoPom(arquivoPom, processo, sistema);
		pom.gerar();
	}
	
	private void verificaECriaSubdiretorios(String principal, String caminho) {
		 File diretorio = new File(principal);
        // Cria os subdiretórios
        String[] subdiretorios = caminho.split("/");
        for (String subdiretorio : subdiretorios) {
            diretorio = new File(diretorio, subdiretorio);
            if (!diretorio.exists()) {
                diretorio.mkdir();
                System.out.println("Subdiretório '" + subdiretorio + "' criado.");
            } else {
                System.out.println("Subdiretório '" + subdiretorio + "' já existe.");
            }
        }
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
	
	

	
	private void criaGitIgnore() throws IOException {
		File file = new File(directory, ".gitignore");
		if (file.exists()) {
            System.out.println("O arquivo .gitignore já existe em: " + file.getAbsolutePath());
            return;
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("/.metadata/");
        writer.close();
        System.out.println("Arquivo .gitignore criado com sucesso em: " + file.getAbsolutePath());
	}

	@Override
	protected DaoBase getProximo() {
		return new CriaClasseBasicaProjeto();
	}

}
