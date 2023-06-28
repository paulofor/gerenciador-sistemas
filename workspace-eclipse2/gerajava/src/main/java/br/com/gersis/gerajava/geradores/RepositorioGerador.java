package br.com.gersis.gerajava.geradores;

import java.io.IOException;

import br.com.gersis.gerajava.GeradorArquivoJava;
import br.com.gersis.loopback.modelo.Entidade;
import br.com.gersis.loopback.modelo.MetodoServer;
import br.com.gersis.loopback.modelo.ParametroMetodoServer;

public class RepositorioGerador extends GeradorBase {

	private Entidade entidade;
	
	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}
	
	@Override
	public void gerar() throws IOException {
		String nomeArquivo = this.diretorioWorkspace + "/loopback/src/main/java/br/com/gersis/loopback/repositorio/Repositorio" + entidade.getNome() + ".java";
		GeradorArquivoJava arq = new GeradorArquivoJava(nomeArquivo);
		arq.criaArquivo();
		arq.linha();
		arq.linha("import java.util.HashMap;");
		arq.linha("import java.util.Map;");
		arq.linha("import com.strongloop.android.loopback.ModelRepository;");
		arq.linha("import com.strongloop.android.loopback.callbacks.JsonArrayParser;");
		arq.linha("import com.strongloop.android.loopback.callbacks.JsonObjectParser;");
		arq.linha("import com.strongloop.android.loopback.callbacks.EmptyResponseParser;");
		arq.linha("import com.strongloop.android.loopback.callbacks.ListCallback;");
		arq.linha("import com.strongloop.android.loopback.callbacks.ObjectCallback;");
		arq.linha("import com.strongloop.android.loopback.callbacks.VoidCallback;");
		arq.linha("import com.strongloop.android.remoting.adapters.RestContractItem;");
		arq.linha();
		arq.linha("import br.com.gersis.loopback.modelo." + this.entidade.getNome() + ";");
		arq.linha();
		arq.linha("public class Repositorio" + this.entidade.getNome() + " extends ModelRepository<" + this.entidade.getNome() + "> {");
		arq.linha();
		arq.linha("	public Repositorio" + this.entidade.getNome() + "() {");
		arq.linha("		super(\"" + this.entidade.getNome() + "\", " + this.entidade.getNome() + ".class);");
		arq.linha("	}");
		arq.linha("	@Override");
		arq.linha("	protected String verificaNomeUrl(String nome) {");
		arq.linha("		return \"" + this.entidade.getNome() +"\";");
		arq.linha("	}");
		arq.linha();
		arq.linha();
		arq.linha("	// ***  Operações  ***");
		arq.linha();
		for (MetodoServer metodo : this.entidade.getMetodoServers()) {
			arq.linha("	public synchronized void " + metodo.getNomeHungara()+ "(" + metodo.getParametrosFuncaoJava(this.entidade) +  metodo.getJavaCallbackParametro(entidade)+ " ) {");
			arq.linha("		RestContractItem contrato = new RestContractItem(\"" + entidade.getNome() + (entidade.temSLoopback()?"s/":"/") + metodo.getNomeHungara() + "\",\"" + metodo.getTipoMetodo() + "\");");
			arq.linha("		this.getRestAdapter().getContract().addItem(contrato, \"" + entidade.getNome() + "." + metodo.getNomeHungara() + "\");");
			arq.linha("		Map<String, Object> params = new HashMap<String, Object>();");

			for (ParametroMetodoServer param : metodo.getParametroMetodoServers()) {
				if (param.isObject()) {
					arq.linha("		params.put(\"" + param.getNome() + "\", " + param.getNome()+ ".getJSON());");
				} else {
					arq.linha("		params.put(\"" + param.getNome() + "\", " + param.getNome()+ ");");
				}
			}
			arq.linha("		invokeStaticMethod(\"" + metodo.getNomeHungara() +"\", params,   " + metodo.getJavaCallbackNew(entidade) + ");");
			arq.linha("	}");
			arq.linha();
		}
		arq.linha();
		arq.linha("}");
		arq.fecha();
		
	}

}
