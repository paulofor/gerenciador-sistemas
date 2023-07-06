package br.com.gersis.geranodeloopback;

import java.io.File;

import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.DummyDaoBase;
import br.com.gersis.geranodeloopback.geradores.GeraJsonClasse;
import br.com.gersis.geranodeloopback.loopback.DaoAplicacao;
import br.com.gersis.geranodeloopback.loopback.DatasetGersis;
import br.com.gersis.loopback.modelo.Entidade;
import br.com.gersis.loopback.modelo.Sistema;

public class CriaArquivos extends DaoAplicacao{
	
	
	public CriaArquivos() {
		this.dummy = new DummyDaoBase();
	}

	@Override
	protected void executaImpl() {
		DatasetGersis ds = (DatasetGersis) this.getComum();
		Sistema sistema = ds.getSistema();
		String pathPadrao = "loopback-server/common/models";
		String pathArquivos = sistema.getPathProjeto() + File.separator + pathPadrao;
		this.verificaECriaSubdiretorios(sistema.getPathProjeto(),pathPadrao);
		try {
			for (Entidade entidade : sistema.getEntidades()) {
				String nomeArquivo = pathArquivos + "/" + entidade.getNomeHifen() + ".json";
				GeraJsonClasse gerador = new GeraJsonClasse(nomeArquivo);
				gerador.setEntidade(entidade);
				gerador.gerar();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finalizar();
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

	
	@Override
	protected DaoBase getProximo() {
		return this.dummy;
	}

}
