package validador.marketingdigital.integracao.lookback.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import validador.marketingdigital.integracao.lookback.modelo.TokenAcesso;

public class RepositorioTokenAcesso extends ModelRepository<TokenAcesso>{

	public RepositorioTokenAcesso() {
		super("TokenAcesso", TokenAcesso.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "TokenAcessos";
	}
	

	
	public synchronized void obtemPorNome(String nome, final ListCallback<TokenAcesso> callback ) {
		RestContractItem contrato = new RestContractItem("TokenAcessos/obtemPorNome","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TokenAcesso.obtemPorNome");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("nome", nome);
        invokeStaticMethod("obtemPorNome", params,    new JsonArrayParser<TokenAcesso>(this, callback));
	}

}