package br.com.gersis.loopback.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.gersis.loopback.modelo.Sistema;

public class RepositorioSistema extends ModelRepository<Sistema>{

	public RepositorioSistema() {
		super("Sistema", Sistema.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "Sistemas";
	}
	
	public void obtemParaGerarJava(final int idSistema, final ObjectCallback<Sistema> callback ) {
		RestContractItem contrato = new RestContractItem("Sistemas/obtemParaGerarJava","GET");
		this.getRestAdapter().getContract().addItem(contrato, "Sistema.obtemParaGerarJava");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idSistema", idSistema);
        invokeStaticMethod("obtemParaGerarJava", params,   new JsonObjectParser<Sistema>(this, callback));
	}
	
	public void obtemParaGerarNode(final int idSistema, final ObjectCallback<Sistema> callback ) {
		RestContractItem contrato = new RestContractItem("Sistemas/obtemParaGerarNode","GET");
		this.getRestAdapter().getContract().addItem(contrato, "Sistema.obtemParaGerarNode");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idSistema", idSistema);
        invokeStaticMethod("obtemParaGerarNode", params,   new JsonObjectParser<Sistema>(this, callback));
	}
	
	

}
