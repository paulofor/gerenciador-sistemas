import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { BaseItemIdComponent } from '../base-component/base-item-id-component';
import { ProcessoPythonApi } from '../shared/sdk';
import { EscolheEntidadeEntradaParaPythonComponent } from '../escolhe-entidade-entrada-para-python/escolhe-entidade-entrada-para-python.component';
import { EscolheEntidadeSaidaParaPythonComponent } from '../escolhe-entidade-saida-para-python/escolhe-entidade-saida-para-python.component';

@Component({
  selector: 'app-processo-python-detalhe',
  templateUrl: './processo-python-detalhe.component.html',
  styleUrls: ['./processo-python-detalhe.component.css']
})
export class ProcessoPythonDetalheComponent extends BaseItemIdComponent {

  constructor(protected dialog: MatDialog, protected srv: ProcessoPythonApi, protected router: ActivatedRoute, 
      ) {
    super(dialog, srv, router);
  }

  
  getFiltro() {
    return {
      'include': [ 
        { 'relation' : 'pythonMetodoEntrada', 'scope' : {'include' : {'relation': 'metodoServer' , 'scope' : {'include' : 'entidade'}}}},
        { 'relation' : 'pythonMetodoSaida' , 'scope' : {'include' : {'relation': 'metodoServer' , 'scope' : {'include' : 'entidade'}}}}
      ]
    }
  }

  editaEntidadeSaida(origem,edicao) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(EscolheEntidadeSaidaParaPythonComponent, {
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
    this.dialog.open(EscolheEntidadeEntradaParaPythonComponent, {
      width: '800px',
      data: {
        item: edicao,
        origem: origem
      }
    });
  }
  
}
