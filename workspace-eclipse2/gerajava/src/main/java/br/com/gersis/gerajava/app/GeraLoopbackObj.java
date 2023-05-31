package br.com.gersis.gerajava.app;

import br.com.gersis.gerajava.loopback.DatasetGersis;

public class GeraLoopbackObj {

	public void executa() {
		DatasetGersis ds = new DatasetGersis();
		ds.setIdSistema(1);
		Sistema_ObtemParaGerarJava exec = new Sistema_ObtemParaGerarJava();
		exec.setComum(ds);
		exec.executa();
	}

}
