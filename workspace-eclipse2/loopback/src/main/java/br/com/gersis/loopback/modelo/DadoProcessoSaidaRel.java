package br.com.gersis.loopback.modelo;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.remoting.BeanUtil;

public class DadoProcessoSaidaRel {

	private DadoProcesso dadoProcesso;

	public DadoProcesso getDadoProcesso() {
		return dadoProcesso;
	}

	public void setDadoProcesso(HashMap dadoProcesso) {
		this.dadoProcesso = new DadoProcesso();
		BeanUtil.setProperties(this.dadoProcesso, (Map<String, ? extends Object>) dadoProcesso, true);
	}
	
}
