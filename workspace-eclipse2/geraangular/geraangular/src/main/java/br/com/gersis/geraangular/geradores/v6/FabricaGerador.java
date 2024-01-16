package br.com.gersis.geraangular.geradores.v6;

import br.com.gersis.geraangular.geradores.v6.detalhe.GeraHtmlDetalhe;
import br.com.gersis.geraangular.geradores.v6.detalhe.GeraTsDetalhe;
import br.com.gersis.geraangular.geradores.v6.detalhe.GeraTsDetalheImpl;
import br.com.gersis.geraangular.geradores.v6.edit.GeraHtmlEdit;
import br.com.gersis.geraangular.geradores.v6.edit.GeraTsEdit;
import br.com.gersis.geraangular.geradores.v6.edit.GeraTsEditImpl;
import br.com.gersis.geraangular.geradores.v6.lista.GeraHtmlLista;
import br.com.gersis.geraangular.geradores.v6.lista.GeraTsLista;
import br.com.gersis.geraangular.geradores.v6.lista.GeraTsListaImpl;
import br.com.gersis.geraangular.geradores.v6.listasimples.GeraHtmlListaSimples;
import br.com.gersis.geraangular.geradores.v6.listasimples.GeraTsListaSimples;
import br.com.gersis.geraangular.geradores.v6.listasimples.GeraTsListaSimplesImpl;
import br.com.gersis.geraangular.geradores.v6.reledit.GeraHtmlEditRel;
import br.com.gersis.geraangular.geradores.v6.reledit.GeraTsEditRel;
import br.com.gersis.geraangular.geradores.v6.reledit.GeraTsEditRelImpl;
import br.com.gersis.loopback.modelo.TelaFront;

public class FabricaGerador {

	public static GeraHtml criaHtml(TelaFront tela, String diretorio) {
		String nomeArquivo = diretorio + "/" + tela.getNomeHifen() + ".component.html";
		if ("Detalhe".equals(tela.getTipo())) return new GeraHtmlDetalhe(nomeArquivo);
		if ("Lista".equals(tela.getTipo())) return new GeraHtmlLista(nomeArquivo);
		if ("Edicao".equals(tela.getTipo())) return new GeraHtmlEdit(nomeArquivo);
		if ("ListaSimples".equals(tela.getTipo())) return new GeraHtmlListaSimples(nomeArquivo);
		if ("EditRel".equals(tela.getTipo())) return new GeraHtmlEditRel(nomeArquivo);
		return new GeraHtml(nomeArquivo);
	}
	
	public static GeraTs criaTs(TelaFront tela, String diretorio) {
		String nomeArquivo = diretorio + "/" + tela.getNomeHifen() + "-base.component.ts";
		if ("Detalhe".equals(tela.getTipo())) return new GeraTsDetalhe(nomeArquivo);
		if ("Lista".equals(tela.getTipo())) return new GeraTsLista(nomeArquivo);
		if ("Edicao".equals(tela.getTipo())) return new GeraTsEdit(nomeArquivo);
		if ("ListaSimples".equals(tela.getTipo())) return new GeraTsListaSimples(nomeArquivo);
		if ("EditRel".equals(tela.getTipo())) return new GeraTsEditRel(nomeArquivo);
		return new GeraTs(nomeArquivo);
	}
	
	public static GeraTs criaTsImpl(TelaFront tela, String diretorio) {
		String nomeArquivo = diretorio + "/" + tela.getNomeHifen() + ".component.ts";
		if ("Detalhe".equals(tela.getTipo())) return new GeraTsDetalheImpl(nomeArquivo);
		if ("Lista".equals(tela.getTipo())) return new GeraTsListaImpl(nomeArquivo);
		if ("Edicao".equals(tela.getTipo())) return new GeraTsEditImpl(nomeArquivo);
		if ("ListaSimples".equals(tela.getTipo())) return new GeraTsListaSimplesImpl(nomeArquivo);
		if ("EditRel".equals(tela.getTipo())) return new GeraTsEditRelImpl(nomeArquivo);
		return new GeraTsDetalheImpl(nomeArquivo);
	}

	public static GeraSpecTs criaSpecTs(TelaFront tela, String diretorio) {
		String nomeArquivo = diretorio + "/" + tela.getNomeHifen() + ".component.spec.ts";
		if ("Detalhe".equals(tela.getTipo())) return new GeraSpecTs(nomeArquivo);
		if ("Lista".equals(tela.getTipo())) return new GeraSpecTs(nomeArquivo);
		if ("Edicao".equals(tela.getTipo())) return new GeraSpecTs(nomeArquivo);
		if ("ListaSimples".equals(tela.getTipo())) return new GeraSpecTs(nomeArquivo);
		if ("EditRel".equals(tela.getTipo())) return new GeraSpecTs(nomeArquivo);
		return new GeraSpecTs(nomeArquivo);
	}

	public static GeraCss criaCss(TelaFront tela, String diretorio) {
		String nomeArquivo = diretorio + "/" + tela.getNomeHifen() + ".component.css";
		if ("Detalhe".equals(tela.getTipo())) return new GeraCss(nomeArquivo);
		if ("Lista".equals(tela.getTipo())) return new GeraCss(nomeArquivo);
		if ("Edicao".equals(tela.getTipo())) return new GeraCss(nomeArquivo);
		if ("ListaSimples".equals(tela.getTipo())) return new GeraCss(nomeArquivo);
		if ("EditRel".equals(tela.getTipo())) return new GeraCss(nomeArquivo);
		return new GeraCss(nomeArquivo);
	}
}
