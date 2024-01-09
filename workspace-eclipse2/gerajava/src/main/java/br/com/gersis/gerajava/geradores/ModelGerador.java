package br.com.gersis.gerajava.geradores;

import java.io.IOException;

import br.com.gersis.gerajava.GeradorArquivoJava;
import br.com.gersis.loopback.modelo.AtributoEntidade;
import br.com.gersis.loopback.modelo.Entidade;
import br.com.gersis.loopback.modelo.RelacionamentoEntidade;

public class ModelGerador extends GeradorBase {

	
	private Entidade entidade;
	
	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}
	
	
	@Override
	public void gerar() throws IOException {
		String nomeArquivo = this.diretorioWorkspace + "/loopback/src/main/java/br/com/gersis/loopback/modelo/" + entidade.getNome() + ".java";
		GeradorArquivoJava arq = new GeradorArquivoJava(nomeArquivo);
		arq.criaArquivo();
		arq.linha();
		arq.linha("import java.util.ArrayList;");
		arq.linha("import java.util.HashMap;");
		arq.linha("import java.util.List;");
		arq.linha("import java.util.Map;");
		arq.linha();
		arq.linha("import com.strongloop.android.loopback.Model;");
		arq.linha("import com.strongloop.android.remoting.BeanUtil;");
		arq.linha("import org.json.JSONObject;");
		arq.linha();
		
		arq.linha();
		arq.linha("public class " + this.entidade.getNome() + " extends Model {");
		arq.linha();
		
		arq.linha();
		for (AtributoEntidade atributo : entidade.getAtributoEntidades()) {
			if (!"id".equals(atributo.getNomeVariavel())) {
				arq.linha("	private " + atributo.getTipoJava() + " " + atributo.getNomeVariavel() + ";");
			}
		}
		arq.linha("	// Relacionamentos 1");
		for (RelacionamentoEntidade rel : entidade.getRelacionamentos1()) {
			arq.linha("	private " + rel.getEntidade1().getNome() + " " + rel.getNome1() + ";");
		}
		arq.linha("	// Relacionamentos N");
		for (RelacionamentoEntidade rel : entidade.getRelacionamentosN()) {
			arq.linha("	private List<" + rel.getEntidadeN().getNome() + "> " + rel.getNomeN()  + ";");
		}
		arq.linha();
		arq.linha("	public void setId(Long id) {");
		arq.linha("		this.setIdObjeto(id);");
		arq.linha("	}");
		arq.linha("	public void setId(Integer id) {");
		arq.linha("		this.setIdObjeto(id);");
		arq.linha("	}");
		arq.linha();
		arq.linha("	public int getIdInteger() {");
		arq.linha("		return new Integer(getId().toString());");
		arq.linha("	}");
		arq.linha("	public long getIdLong() {");
		arq.linha("		return new Long(getId().toString());");
		arq.linha("	}");
		arq.linha();
		arq.linha("	public JSONObject getJSON() {");
		arq.linha("		JSONObject obj = new JSONObject();");
		arq.linha("		try {");
		arq.linha("			obj.put(\"id\",getId());");
		for (AtributoEntidade atributo : entidade.getAtributoEntidades()) {
			if (!"id".equals(atributo.getNomeVariavel())) {
				arq.linha("			obj.put(\"" + atributo.getNomeVariavel() + "\", " + atributo.getNomeVariavel() + ");");
			}
		}
		arq.linha("		} catch (Exception e) {");
		arq.linha("			e.printStackTrace();");
		arq.linha("		}");
		arq.linha("		return obj;");
		arq.linha("	}");
		arq.linha();
		arq.linha();
		for (AtributoEntidade atributo : entidade.getAtributoEntidades()) {
			if (!"id".equals(atributo.getNomeVariavel())) {
				arq.linha("	public void set" + atributo.getNomePropriedade() + "(" + atributo.getTipoJava() + " valor) { ");
				arq.linha("		this." + atributo.getNomeVariavel() + " = valor;");
				arq.linha("	}");
				arq.linha("	public " + atributo.getTipoJava() + " get" + atributo.getNomePropriedade() + "() { ");
				arq.linha("		return this." + atributo.getNomeVariavel() + ";");
				arq.linha("	}");
			}
			
		}
		arq.linha();
		for (RelacionamentoEntidade rel : entidade.getRelacionamentos1()) {
			arq.linha("	public " + rel.getEntidade1().getNome() + " get" + rel.getNome1Propriedade() + "() {");
			arq.linha("		return " +  rel.getNome1() + ";");
			arq.linha("	}");
			arq.linha("	public void set" + rel.getNome1Propriedade() + "(HashMap valor) {");
			arq.linha("		this." + rel.getNome1() + " = new " + rel.getEntidade1().getNome() + "();");
			arq.linha("		BeanUtil.setProperties(this." + rel.getNome1() + ", (Map<String, ? extends Object>) valor, true);");
			arq.linha("	}");
		}
		for (RelacionamentoEntidade rel : entidade.getRelacionamentosN()) {
			arq.linha("	public List<" + rel.getEntidadeN().getNome() + "> get" + rel.getNomeNPropriedade() +"() {");
			arq.linha("		return  " + rel.getNomeN()  + ";");
			arq.linha("	}");
			arq.linha("	public void set" + rel.getNomeNPropriedade() + "(List<" + rel.getEntidadeN().getNome() + "> valores) {");
			arq.linha("		this." + rel.getNomeN()  + " = new ArrayList<" + rel.getEntidadeN().getNome() + ">();");
			arq.linha("		for (int i = 0; i < valores.size(); i++) {");
			arq.linha("			Object objeto = new " + rel.getEntidadeN().getNome() + "();");
			arq.linha("			System.out.println(\" --> ObjetoMap \");");
			arq.linha("			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);");
			arq.linha("			this." + rel.getNomeN()  + ".add((" + rel.getEntidadeN().getNome() + ") objeto);");
			arq.linha("		}");
			arq.linha("	}");
		}
		arq.linha("}");
		arq.fecha();
		
	}

}
