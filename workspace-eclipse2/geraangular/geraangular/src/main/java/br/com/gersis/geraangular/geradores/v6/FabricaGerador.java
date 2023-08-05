package br.com.gersis.geraangular.geradores.v6;

import br.com.gersis.geraangular.geradores.v6.detalhe.GeraHtmlDetalhe;
import br.com.gersis.geraangular.geradores.v6.detalhe.GeraTsDetalhe;
import br.com.gersis.geraangular.geradores.v6.detalhe.GeraTsDetalheImpl;
import br.com.gersis.loopback.modelo.TelaFront;

public class FabricaGerador {

	public static GeraHtml criaHtml(TelaFront tela, String diretorio) {
		String nomeArquivo = diretorio + "/" + tela.getNomeHifen() + ".component.html";
		if ("Detalhe".equals(tela.getTipo())) return new GeraHtmlDetalhe(nomeArquivo);
		return new GeraHtml(nomeArquivo);
	}
	
	public static GeraTs criaTs(TelaFront tela, String diretorio) {
		String nomeArquivo = diretorio + "/" + tela.getNomeHifen() + "-base.component.ts";
		if ("Detalhe".equals(tela.getTipo())) return new GeraTsDetalhe(nomeArquivo);
		return new GeraTs(nomeArquivo);
	}
	
	public static GeraTs criaTsImpl(TelaFront tela, String diretorio) {
		String nomeArquivo = diretorio + "/" + tela.getNomeHifen() + ".component.ts";
		if ("Detalhe".equals(tela.getTipo())) return new GeraTsDetalheImpl(nomeArquivo);
		return new GeraTsDetalheImpl(nomeArquivo);
	}

	public static GeraSpecTs criaSpecTs(TelaFront tela, String diretorio) {
		String nomeArquivo = diretorio + "/" + tela.getNomeHifen() + ".component.spec.ts";
		if ("Detalhe".equals(tela.getTipo())) return new GeraSpecTs(nomeArquivo);
		return new GeraSpecTs(nomeArquivo);
	}

	public static GeraCss criaCss(TelaFront tela, String diretorio) {
		String nomeArquivo = diretorio + "/" + tela.getNomeHifen() + ".component.css";
		if ("Detalhe".equals(tela.getTipo())) return new GeraCss(nomeArquivo);
		return new GeraCss(nomeArquivo);
	}
}
