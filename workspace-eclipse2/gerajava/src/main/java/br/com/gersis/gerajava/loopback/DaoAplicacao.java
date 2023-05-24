package br.com.gersis.gerajava.loopback;

import com.strongloop.android.loopback.RestAdapter;

import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.daobase.comum.DaoBaseComum;
import br.com.gersis.loopback.repositorio.RepositorioSistema;

public abstract class DaoAplicacao  extends DaoBase{
	
	private RestAdapter adapter = new RestAdapter(DaoBaseComum.urlLoopback); 
	protected RepositorioSistema repSistema = adapter.createRepository(RepositorioSistema.class);

	@Override
	protected long getTempo() {
		return 10000;
	}

	
	@Override
	protected IDatasetComum criaDataSet() {
		return new DatasetGersis();
	}


	
	

}
