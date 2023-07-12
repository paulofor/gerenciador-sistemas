package br.com.gersis.geranodeloopback.geradores;

import java.io.IOException;

import br.com.gersis.loopback.modelo.AtributoEntidade;
import br.com.gersis.loopback.modelo.Entidade;
import br.com.gersis.loopback.modelo.RelacionamentoEntidade;

public class GeraJsonClasse extends GeradorArquivo{
	
	Entidade entidade = null;

	public GeraJsonClasse(String nome) {
		super(nome);
	}
	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}
	
	
	public void gerar() throws IOException {
		this.criaArquivo();
		this.linha("{");
		this.linha("	\"name\": \"" + this.entidade.getNome() + "\",");
		this.linha("	\"base\": \"PersistedModel\",");
		this.linha("	\"idInjection\": true,");
		this.linha("	\"options\": {");
		this.linha("		\"validateUpsert\": true");
		this.linha("	},");
		this.linha("  	\"mixins\": {");
		this.linha("    	\"Counts\": true");
		this.linha("  	},");
		this.linha("	\"properties\": {");
		for (int i=0; i<this.entidade.getAtributoEntidades().size() ; i++) {
			AtributoEntidade atributo = this.entidade.getAtributoEntidades().get(i);
			this.linha("		\"" + atributo.getNomeVariavel() + "\": {");
			this.linha("			\"type\": \"" + atributo.getTipoNode() + "\"");
			if ("1".equals(atributo.getChave())) {
				this.linha("			,\"id\": true");
			}
			if (i==(this.entidade.getAtributoEntidades().size()-1) && (this.entidade.getRelacionamentos1().size()==0)) {
				this.linha("		}");
			} else {
				this.linha("		},");
			}
		}
		
		for (int i=0; i<this.entidade.getRelacionamentos1().size() ; i++) {
			RelacionamentoEntidade relatributo = this.entidade.getRelacionamentos1().get(i);
			this.linha("		\"" + relatributo.getNome1Chave() + "\": {");
			this.linha("			\"type\": \"" + relatributo.getNome1TipoChaveNode() + "\"");
			if (i==(this.entidade.getRelacionamentos1().size()-1)) {
				this.linha("		}");
			} else {
				this.linha("		},");
			}
		}
		
		this.linha("	},");
		this.linha("	\"validations\": [],");
		this.linha("	\"relations\": {");
		for (int i=0; i<this.entidade.getRelacionamentos1().size(); i++ ) {
			RelacionamentoEntidade rel = this.entidade.getRelacionamentos1().get(i);
			this.linha("		\"" + rel.getNome1Variavel() + "\": {");
			this.linha("			\"type\": \"belongsTo\",");
			this.linha("			\"model\": \"" + rel.getEntidade1().getNome() + "\",");
			this.linha("			\"foreignKey\": \"\"");
			if (i==(this.entidade.getRelacionamentos1().size()-1) && this.entidade.getRelacionamentosN().size()==0) {
				this.linha("		}");
			} else {
				this.linha("		},");
			}
		}
		for (int i=0; i<this.entidade.getRelacionamentosN().size(); i++ ) {
			RelacionamentoEntidade rel = this.entidade.getRelacionamentosN().get(i);
			this.linha("		\"" + rel.getNomeNVariavel() + "\": {");
			this.linha("			\"type\": \"hasMany\",");
			this.linha("			\"model\": \"" + rel.getEntidadeN().getNome() + "\",");
			this.linha("			\"foreignKey\": \"\"");
			if (i==(this.entidade.getRelacionamentosN().size()-1)) {
				this.linha("		}");
			} else {
				this.linha("		},");
			}
		}
		this.linha("	},");
		this.linha("	\"acls\": [],");
		this.linha("	\"methods\": {}");
		this.linha("}");
		this.fecha();
	}
	
	
}
