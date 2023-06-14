package br.com.gersis.loopback.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class ProcessoEntidadeEntradaRel extends Model{

	
	private Entidade entidade;

	public Entidade getEntidade() {
		return entidade;
	}
	public void setEntidade(Entidade entidade) {
		this.entidade = new Entidade();
		BeanUtil.setProperties(this.entidade, (Map<String, ? extends Object>) entidade, true);
	}
	
	
	
}
