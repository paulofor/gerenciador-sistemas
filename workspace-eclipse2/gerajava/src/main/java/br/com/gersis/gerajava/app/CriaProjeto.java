package br.com.gersis.gerajava.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import br.com.gersis.daobase.DaoBase;
import br.com.gersis.gerajava.loopback.DaoAplicacao;
import br.com.gersis.gerajava.loopback.DatasetGersis;
import br.com.gersis.loopback.modelo.Sistema;

public class CriaProjeto extends DaoAplicacao {

	private Sistema sistema = null;
	private String pathWorkspace = null;
	private File directory = null;
	
	@Override
	protected void executaImpl() {
		sistema = ((DatasetGersis)this.getComum()).getSistema();
		this.pathWorkspace = sistema.getPathProjeto() + File.separator + "workspace-eclipse-gerador";
		directory = new File(this.pathWorkspace);
        if (!directory.exists()) {
        	directory.mkdirs(); // Cria o diretório se ele não existir
        }
        try {
        	//criaGitIgnore();
        	copiarDiretorio("arquivos",this.pathWorkspace);
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	private void copiarDiretorio(String origem, String destino) throws IOException {
		File origemDir = new File(origem);
	    File destinoDir = new File(destino);

	    // Copiar o diretório usando FileUtils.copyDirectory()
	    FileUtils.copyDirectory(origemDir, destinoDir);
	    System.out.println("Diretorio copiado");
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
		return new CriaClasseBasica();
	}

}
