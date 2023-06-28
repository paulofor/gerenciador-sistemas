package br.com.gersis.gerajava.geradores;

import java.io.IOException;

import br.com.gersis.loopback.modelo.PassoProcessoJava;
import br.com.gersis.loopback.modelo.ProcessoJava;

public class GeradorPassoProcessoImpl  extends GeradorPassoProcesso {

	public GeradorPassoProcessoImpl(String nome, PassoProcessoJava passo, PassoProcessoJava passoProximo,
			ProcessoJava processo, int posicaoPasso) throws IOException {
		super(nome, passo, passoProximo, processo, posicaoPasso);
	}

	@Override
	public void gerar() throws IOException {
		if (super.criaArquivoSeNaoExiste()) {
			this.linha();
			this.linha("import gerador." + this.processo.getNomeClasseMain().toLowerCase() + ".passo.*;");
			this.linha();
			this.linha();
			this.linha();
			this.linha("public class " + this.getNomeClasse() + " extends " + this.getNomeClasse().substring(0, this.getNomeClasse().length() - 4) + " { ");
			this.linha();
			this.linha();
			this.linha("}");
			this.linha();
			this.fecha();
		}
	}
	
	

	
}
