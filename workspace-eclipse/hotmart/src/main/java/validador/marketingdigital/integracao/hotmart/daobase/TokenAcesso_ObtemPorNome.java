package validador.marketingdigital.integracao.hotmart.daobase;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import validador.marketingdigital.integracao.daobase.comum.DaoBaseComum;
import validador.marketingdigital.integracao.lookback.repositorio.RepositorioTokenAcesso;

public class TokenAcesso_ObtemPorNome  extends DaoBaseComum{

	private RestAdapter adapter = new RestAdapter(DaoBaseComum.urlLoopback); 
	protected RepositorioTokenAcesso repToken = adapter.createRepository(RepositorioTokenAcesso.class);

	
	
	@Override
	protected long getTempo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void executaImpl() {
		final HotmartDataset ds = (HotmartDataset) getComum();
		
		this.repToken.insereLista(ds.getListaProduto(), new VoidCallback() {

			public void onSuccess() {
				finalizar();
			}

			public void onError(Throwable t) {
				onErrorBase(t);
			}

		});
		
	}
}
