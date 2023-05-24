import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { BaseItemIdComponent } from '../base-component/base-item-id-component';
import { DadoPassoProcessoEntradaRel, DadoPassoProcessoSaidaRel, PassoProcessoJava, PassoProcessoJavaApi, ProcessoJavaApi } from '../shared/sdk';
import { PassoProcessoEditComponent } from '../passo-processo-edit/passo-processo-edit.component';
import { DadoProcessoSaidaEditComponent } from '../dado-processo-saida-edit/dado-processo-saida-edit.component';
import { DadoProcessoEntradaEditComponent } from '../dado-processo-entrada-edit/dado-processo-entrada-edit.component';
import { EscolheEntidadeEntradaParaProcessoComponent } from '../escolhe-entidade-entrada-para-processo/escolhe-entidade-entrada-para-processo.component';
import { EscolheEntidadeSaidaParaProcessoComponent } from '../escolhe-entidade-saida-para-processo/escolhe-entidade-saida-para-processo.component';
import { DadoProcessoEditComponent } from '../dado-processo-edit/dado-processo-edit.component';

@Component({
  selector: 'app-processo-java-detalhe',
  templateUrl: './processo-java-detalhe.component.html',
  styleUrls: ['./processo-java-detalhe.component.css']
})
export class ProcessoJavaDetalheComponent extends BaseItemIdComponent {

  constructor(protected dialog: MatDialog, protected srv: ProcessoJavaApi, protected router: ActivatedRoute, 
      protected srvPasso: PassoProcessoJavaApi) {
    super(dialog, srv, router);
  }

  
  getFiltro() {
    return {
      'include': [ 
        { 'relation': 'passoProcessoJavas', 'scope' : {'order' : 'ordenacao', 'include' : 
          [ 
            {'relation' : 'dadoPassoEntrada' , 'scope' : {'include' : {'relation':'dadoProcesso', 'scope' : {'include' : 'tipoEntidade'}} }},
            {'relation' : 'dadoPassoSaida' , 'scope' : {'include' : {'relation':'dadoProcesso', 'scope' : {'include' : 'tipoEntidade'}} }}
          ]} },
        { 'relation' : 'processoEntidadeEntrada', 'scope' : {'include' : 'entidade'}},
        { 'relation' : 'processoEntidadeSaida' , 'scope' : {'include' : 'entidade'}},
        { 'relation' : 'dadoProcessos' , 'scope' : {'include' : 'tipoEntidade'}},
        'linuxInternet'
      ]
    }
  }


  subirItem(item:PassoProcessoJava) {
    this.srvPasso.DesceItem(item.id) 
      .subscribe((result) => {
        this.carregaTela();
      })
  }

  editaDadoProcesso(origem,edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(DadoProcessoEditComponent, {
      width: '800px',
      data: {
        item: edicao,
        origem: origem
      }
    });
  }


  editaEntidadeSaida(origem,edicao) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(EscolheEntidadeSaidaParaProcessoComponent, {
      width: '800px',
      data: {
        item: edicao,
        origem: origem
      }
    });
  }
  editaEntidadeEntrada(origem,edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(EscolheEntidadeEntradaParaProcessoComponent, {
      width: '800px',
      data: {
        item: edicao,
        origem: origem
      }
    });
  }


  novaEntrada(edicao) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(DadoProcessoEntradaEditComponent, {
      width: '800px',
      data: {
        item: null,
        origem: edicao
      }
    });
  }

  editaDadoEntrada(dado:DadoPassoProcessoEntradaRel, passo:PassoProcessoJava) {
    passo.processoJava = this.principal;
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(DadoProcessoEntradaEditComponent, {
      width: '800px',
      data: {
        item: dado,
        origem: passo
      }
    });
  }
  editaDadoSaida(dado:DadoPassoProcessoSaidaRel, passo:PassoProcessoJava) {
    passo.processoJava = this.principal;
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(DadoProcessoSaidaEditComponent, {
      width: '800px',
      data: {
        item: dado,
        origem: passo
      }
    });
  }


  novaSaida(edicao) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(DadoProcessoSaidaEditComponent, {
      width: '800px',
      data: {
        item: null,
        origem: edicao
      }
    });
  }

  editaPasso(edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(PassoProcessoEditComponent, {
      width: '800px',
      data: {
        item: edicao,
        origem: this.principal
      }
    });
  }

  /*

  editaAtributo(edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(AtributoEntidadeEditComponent, {
      width: '800px',
      data: {
        item: edicao,
        origem: this.principal
      }
    });
  }


  editaRelacionamento(edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(RelacionamentoEntidadeEditComponent, {
      width: '800px',
      data: {
        item: edicao,
        origem: this.principal
      }
    });
  }

  */
}
