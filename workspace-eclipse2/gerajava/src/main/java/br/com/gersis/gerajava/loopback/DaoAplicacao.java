package br.com.gersis.gerajava.loopback;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.strongloop.android.loopback.RestAdapter;

import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.daobase.comum.DaoBaseComum;
import br.com.gersis.loopback.repositorio.RepositorioSistema;

public abstract class DaoAplicacao  extends DaoBase{
	
	private RestAdapter adapter = new RestAdapter(DaoBaseComum.urlLoopback); 
	protected RepositorioSistema repSistema = adapter.createRepository(RepositorioSistema.class);
	protected String NOME_WORKSPACE = "workspace-eclipse-gerador";
	
	
	@Override
	protected long getTempo() {
		return 10000;
	}

	
	@Override
	protected IDatasetComum criaDataSet() {
		return new DatasetGersis();
	}

	protected void copiarDiretorioSeNaoVazio(String origem, String destino) throws IOException {
		File origemDir = new File(origem);
	    File destinoDir = new File(destino);
	    
	    File[] arquivos = destinoDir.listFiles();

        if (arquivos != null && arquivos.length > 0) {
            System.out.println("O diretório  " + destinoDir + " não está vazio.");
        } else {
        	FileUtils.copyDirectory(origemDir, destinoDir);
		    System.out.println("Diretorio " + destinoDir + "copiado");
        }

    }
	protected void copiarDiretorio(String origem, String destino) throws IOException {
		File origemDir = new File(origem);
	    File destinoDir = new File(destino);

	    // Copiar o diretório usando FileUtils.copyDirectory()
	    FileUtils.copyDirectory(origemDir, destinoDir);
	    System.out.println("Diretorio copiado");
    }
	protected String converteNomePacote(String diretorio) {
		String nomePacote = "";
		String paths[] = diretorio.split("/");
		boolean valendo = false;
		for (int i=0;i<paths.length;i++) {
			if (!valendo) {
				if ("java".compareTo(paths[i])==0) {
					valendo = true;
				}
			} else {
				nomePacote += "." + paths[i];
			}
		}
		return nomePacote.substring(1);
	}

}
