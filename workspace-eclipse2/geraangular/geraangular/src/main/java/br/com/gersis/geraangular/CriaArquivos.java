package br.com.gersis.geraangular;

import java.io.File;
import java.io.IOException;

import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.DummyDaoBase;
import br.com.gersis.geraangular.geradores.v6.FabricaGerador;
import br.com.gersis.geraangular.geradores.v6.GeraCss;
import br.com.gersis.geraangular.geradores.v6.GeraHtml;
import br.com.gersis.geraangular.geradores.v6.GeraSpecTs;
import br.com.gersis.geraangular.geradores.v6.GeraTs;
import br.com.gersis.geraangular.loopback.DaoAplicacao;
import br.com.gersis.geraangular.loopback.DatasetGersis;
import br.com.gersis.loopback.modelo.Entidade;
import br.com.gersis.loopback.modelo.Sistema;
import br.com.gersis.loopback.modelo.TelaFront;

public class CriaArquivos extends DaoAplicacao{
	
	
	public CriaArquivos() {
		this.dummy = new DummyDaoBase();
	}

	@Override
	protected void executaImpl() {
		DatasetGersis ds = (DatasetGersis) this.getComum();
		Sistema sistema = ds.getSistema();
		String pathPadrao = "loopback-angular6/src/app";
		//String pathArquivos = sistema.getPathProjeto() + File.separator + pathPadrao + File.separator;
		
		String dirComponente = "";
		try {
			this.verificaECriaSubdiretorios(sistema.getPathProjeto(),pathPadrao);
			for (Entidade entidade : sistema.getEntidades()) {
				
				for (TelaFront tela : entidade.getTelaFronts()) {
					
					dirComponente = tela.getNomeHifen();
					this.verificaECriaSubdiretorios(sistema.getPathProjeto() + File.separator + pathPadrao,dirComponente, tela);
					String diretorio = sistema.getPathProjeto() + File.separator + pathPadrao + File.separator + dirComponente;

					GeraTs gerador1 = FabricaGerador.criaTs(tela, diretorio);
					gerador1.setEntidade(entidade);
					gerador1.setTela(tela);
					gerador1.gerar();
					
					GeraTs gerador5 = FabricaGerador.criaTsImpl(tela, diretorio);
					gerador5.setEntidade(entidade);
					gerador5.setTela(tela);
					gerador5.gerarSeNaoExiste();
					
					GeraHtml gerador2 = FabricaGerador.criaHtml(tela, diretorio);
					gerador2.setEntidade(entidade);
					gerador2.setTela(tela);
					gerador2.gerarSeNaoExiste();
					
					GeraSpecTs gerador3 = FabricaGerador.criaSpecTs(tela, diretorio);
					gerador3.setEntidade(entidade);
					gerador3.setTela(tela);
					gerador3.gerar();
					
					GeraCss gerador4 = FabricaGerador.criaCss(tela, diretorio);
					gerador4.setEntidade(entidade);
					gerador4.setTela(tela);
					gerador4.gerarSeNaoExiste();
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finalizar();
	}
	
	private void verificaECriaSubdiretorios(String principal, String caminho, TelaFront tela) throws InterruptedException, IOException {
	   File diretorio = new File(principal);
       // Cria os subdiretórios
       String[] subdiretorios = caminho.split("/");
       String rootProjeto =  principal.replace("/src/app", "");
       for (String subdiretorio : subdiretorios) {
           diretorio = new File(diretorio, subdiretorio);
           if (!diretorio.exists()) {
        	   String comando;
               if (diretorio.mkdir()) {
            	   comando = "cd " + rootProjeto;
                   ProcessBuilder pb1 = new ProcessBuilder().command("bash", "-c", comando);
                   pb1.start().waitFor();

                   // Segundo comando
                   comando = "ng g component " + tela.getNome();
                   ProcessBuilder pb2 = new ProcessBuilder().command("bash", "-c", comando);
                   pb2.start().waitFor();

                   // Terceiro comando
                   comando = "rm -f src/app/" + tela.getNomeHifen() + "/*";
                   ProcessBuilder pb3 = new ProcessBuilder().command("bash", "-c", comando);
                   pb3.start().waitFor();
            	   //System.out.println("Subdiretório '" + subdiretorio + "' criado.");
               } else {
            	   //System.out.println("Subdiretório '" + subdiretorio + "' não criado.");
               }
           } else {
               //System.out.println("Subdiretório '" + subdiretorio + "' já existe.");
           }
       }
	}

	private void verificaECriaSubdiretorios(String principal, String caminho) throws InterruptedException, IOException {
		 File diretorio = new File(principal);
      // Cria os subdiretórios
      String[] subdiretorios = caminho.split("/");
      for (String subdiretorio : subdiretorios) {
          diretorio = new File(diretorio, subdiretorio);
          if (!diretorio.exists()) {
              if (diretorio.mkdir()) {
                 
           	   //System.out.println("Subdiretório '" + subdiretorio + "' criado.");
              } else {
           	   //System.out.println("Subdiretório '" + subdiretorio + "' não criado.");
              }
          } else {
              //System.out.println("Subdiretório '" + subdiretorio + "' já existe.");
          }
      }
	}
	
	@Override
	protected DaoBase getProximo() {
		return this.dummy;
	}

}
