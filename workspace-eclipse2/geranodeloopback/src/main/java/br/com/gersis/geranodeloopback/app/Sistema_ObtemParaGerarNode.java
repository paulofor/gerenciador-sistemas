package br.com.gersis.geranodeloopback.app;

import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.gersis.daobase.DaoBase;
import br.com.gersis.geranodeloopback.CriaArquivos;
import br.com.gersis.geranodeloopback.loopback.DaoAplicacao;
import br.com.gersis.geranodeloopback.loopback.DatasetGersis;
import br.com.gersis.loopback.modelo.Sistema;

public class Sistema_ObtemParaGerarNode extends DaoAplicacao {

	@Override
	protected void executaImpl() {
		final DatasetGersis ds = (DatasetGersis) this.getComum();
		int idSistema = ds.getIdSistema();
		this.repSistema.obtemParaGerarNode(idSistema, new ObjectCallback<Sistema>() {

			public void onSuccess(Sistema object) {
				ds.setSistema(object);
				executaProximo();
			}

			public void onError(Throwable t) {
				onErrorBase(t);
			}
		});
	}

	@Override
	protected DaoBase getProximo() {
		return new CriaArquivos();
	}

	
	
}
