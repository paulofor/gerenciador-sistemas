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
		String pathArquivos = sistema.getPathProjeto() + File.separator + "loopback-server/commom/models";
		try {
			for (Entidade entidade : sistema.getEntidades()) {
				String nomeArquivo = pathArquivos + "/" + entidade.getNome().toLowerCase() + ".json";
				GeraJsonClasse gerador = new GeraJsonClasse(nomeArquivo);
				gerador.criaArquivo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finalizar();
	}

	
	@Override
	protected DaoBase getProximo() {
		return this.dummy;
	}

}
