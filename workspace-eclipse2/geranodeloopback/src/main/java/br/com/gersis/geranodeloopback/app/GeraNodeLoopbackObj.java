package br.com.gersis.geranodeloopback.app;

import br.com.gersis.geranodeloopback.loopback.DatasetGersis;

public class GeraNodeLoopbackObj {

	public void executa() {
		DatasetGersis ds = new DatasetGersis();
		ds.setIdSistema(1);
		Sistema_ObtemParaGerarNode exec = new Sistema_ObtemParaGerarNode();
		exec.setComum(ds);
		exec.executa();
	}

}
