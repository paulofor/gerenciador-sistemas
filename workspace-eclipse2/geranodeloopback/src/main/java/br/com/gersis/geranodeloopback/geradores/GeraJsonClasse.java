package br.com.gersis.geranodeloopback.geradores;

import java.io.IOException;
import java.util.List;

import br.com.gersis.loopback.modelo.AtributoEntidade;
import br.com.gersis.loopback.modelo.Entidade;
import br.com.gersis.loopback.modelo.MetodoServer;
import br.com.gersis.loopback.modelo.ParametroMetodoServer;
import br.com.gersis.loopback.modelo.RelacionamentoEntidade;

public class GeraJsonClasse extends GeradorArquivo{
	
	Entidade entidade = null;

	public GeraJsonClasse(String nome) {
		super(nome);
	}
	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}
	
	public boolean todosEstrangeiro(List<RelacionamentoEntidade> listaRel) {
		for (RelacionamentoEntidade rel : listaRel) {
			if (rel.getAtributoChaveEstrangeira()==null) {
				return false;
			}
		}
		return true;
	}
	public int qtdeEstrangeiro1(Entidade entidade) {
		int i = 0;
		for (RelacionamentoEntidade rel : entidade.getRelacionamentos1()) {
			if (rel.getAtributoChaveEstrangeira()!=null) {
				i++;
			}
		}
		/*
		for (RelacionamentoEntidade rel : entidade.getRelacionamentosN()) {
			if (rel.getAtributoChaveEstrangeira()!=null) {
				i++;
			}
		}
		*/
		return i;
	}
	
	
	public void gerar() throws IOException {
		this.criaArquivo();
		this.linha("{");
		this.linha("	\"name\": \"" + this.entidade.getNome() + "\",");
		//this.linha("	\"plural\": \"" + this.entidade.getNome() + "s\",");
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
			
			/*
			boolean temProximo = false;
			for (int k=0; k<this.entidade.getRelacionamentos1().size() ; k++) {
				RelacionamentoEntidade relatributo = this.entidade.getRelacionamentos1().get(k);
				if (relatributo.getAtributoChaveEstrangeira()==null) {
					temProximo = true;
					break;
				}
			}
			*/
			
			
			if (i==(this.entidade.getAtributoEntidades().size()-1) &&  
					((this.entidade.getRelacionamentos1().size()==0) || (this.todosEstrangeiro(this.entidade.getRelacionamentos1())) )) {
				this.linhaBuffer1("		}");
			} else {
				this.linhaBuffer1("		},");
			}
			if (i<this.entidade.getAtributoEntidades().size()-1)
				this.flush1();
		}
		
		int qtde = this.entidade.getRelacionamentos1().size()-this.qtdeEstrangeiro1(this.entidade);
		//System.out.println("Qtde: " + qtde + " Qtde Estrangeiro:" + this.qtdeEstrangeiro1(this.entidade) + ", Rel1:" + this.entidade.getRelacionamentos1().size());
		for (int i=0; i<this.entidade.getRelacionamentos1().size() ; i++) {
			RelacionamentoEntidade relatributo = this.entidade.getRelacionamentos1().get(i);
			if (!existeAtributo(relatributo,this.entidade.getAtributoEntidades())) {
			//System.out.println(qtde + ") " + relatributo.getNome1Chave() );
				if (relatributo.getAtributoChaveEstrangeira()==null) {
					this.flush1();
					this.linha("		\"" + relatributo.getNome1Chave() + "\": {");
					this.linha("			\"type\": \"" + relatributo.getNome1TipoChaveNode() + "\"");
					if (--qtde==0) {
						this.linhaBuffer1("		}");
					} else {
						this.linhaBuffer1("		},");
					}
				}
			}
		}
		if (!this.executouFlush1()) {
			this.linha("		}");
		}
		this.linha("	},");
		this.linha("	\"validations\": [],");
		this.linha("	\"relations\": {");
		for (int i=0; i<this.entidade.getRelacionamentos1().size(); i++ ) {
			RelacionamentoEntidade rel = this.entidade.getRelacionamentos1().get(i);
			this.linha("		\"" + rel.getNome1Variavel() + "\": {");
			this.linha("			\"type\": \"belongsTo\",");
			this.linha("			\"model\": \"" + rel.getEntidade1().getNome() + "\",");
			if (rel.getAtributoChaveEstrangeira()==null) {
				this.linha("			\"foreignKey\": \"\"");
			} else {
				this.linha("			\"foreignKey\": \"" + rel.getAtributoChaveEstrangeira().getNomeVariavel() +"\"");
			}
			if (i==(this.entidade.getRelacionamentos1().size()-1) && this.entidade.getRelacionamentosN().size()==0){
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
			if (rel.getAtributoChaveEstrangeira()==null) {
				this.linha("			\"foreignKey\": \"\"");
			} else {
				this.linha("			\"foreignKey\": \"" + rel.getAtributoChaveEstrangeira().getNomeVariavel() +"\"");
			}
			if (i==(this.entidade.getRelacionamentosN().size()-1)) {
				this.linha("		}");
			} else {
				this.linha("		},");
			}
		}
		this.linha("	},");
		this.linha("	\"acls\": [],");
		this.linha("	\"methods\": {");
		for (int i=0; i<this.entidade.getMetodoServers().size(); i++) {
			MetodoServer metodo = this.entidade.getMetodoServers().get(i);
			if (metodo.getTipoMetodo() == null) {
				throw new RuntimeException("Método " + entidade.getNome() + "." + metodo.getNome() + " sem tipo (GET/POST) definido.");
			}
			this.linha("		\"" + metodo.getNome() + "\": {");
			this.linha("			\"accepts\": [");
			for (int j=0; j<metodo.getParametroMetodoServers().size(); j++) {
				ParametroMetodoServer param = metodo.getParametroMetodoServers().get(j);
				this.linha("				{");
				this.linha("					\"arg\": \"" + param.getNome() + "\",");
				this.linha("					\"type\": \"" + param.getTipoNode() + "\",");
				this.linha("   					\"required\": false,");
				this.linha("    				\"description\": \"\"");
				if (j==(metodo.getParametroMetodoServers().size()-1)) {
					this.linha("				}");
				} else {
					this.linha("				},");
				}
			}
			this.linha("			],");
			this.linha("			\"returns\": [");
			this.linha(" 				{");
			this.linha("     				\"arg\": \"resultado\",");
			this.linha("     				\"type\": \"" + metodo.getRetornoTipoNode() + "\",");
			this.linha("   					\"root\": true,");
			this.linha("    				\"description\": \"\"");
			this.linha("   				}");
			this.linha("			],");
			this.linha("			\"description\": \"\",");
			this.linha("			\"http\": [");
			this.linha("         		{");
			this.linha("          			\"path\": \"/" + metodo.getNomeHungara().trim() + "\",");
			this.linha("   					\"verb\": \"" + metodo.getTipoMetodo().toLowerCase() + "\"");
			this.linha(" 				}");
			this.linha(" 			]");
			if (i==(this.entidade.getMetodoServers().size()-1)) {
				this.linha("		}");
			} else {
				this.linha("		},");
			}
		}
		this.linha("	}");
		this.linha("}");
		this.fecha();
	}
	private boolean existeAtributo(RelacionamentoEntidade relatributo, List<AtributoEntidade> list ) {
		for (AtributoEntidade atributo : list) {
			if (atributo.getNome().compareTo(relatributo.getNome1Chave())==0) {
				return true;
			}
		}
		return false;
	}
	
	
}
