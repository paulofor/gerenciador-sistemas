import { Component } from '@angular/core';
import { EntidadeApi } from '../shared/sdk';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { BaseItemIdComponent } from '../base-component/base-item-id-component';
import { AtributoEntidadeEditComponent } from '../atributo-entidade-edit/atributo-entidade-edit.component';
import { RelacionamentoEntidadeEditComponent } from '../relacionamento-entidade-edit/relacionamento-entidade-edit.component';
import { MetodoServerEditComponent } from '../metodo-server-edit/metodo-server-edit.component';

@Component({
  selector: 'app-entidade-detalhe',
  templateUrl: './entidade-detalhe.component.html',
  styleUrls: ['./entidade-detalhe.component.css']
})
export class EntidadeDetalheComponent extends BaseItemIdComponent {

  constructor(protected dialog: MatDialog, protected srv: EntidadeApi, protected router: ActivatedRoute) {
    super(dialog, srv, router);
  }

  getFiltro() {
    return {
      'include': ['atributoEntidades', 
        { 'relation': 'metodoServers', 'scope' : {'order' : 'nome'} },
        { 'relation': 'relacionamentos1', 'scope': { 'include': 'entidade1' } },
        { 'relation': 'relacionamentosN', 'scope': { 'include': 'entidadeN' } }
      ]
    }
  }


  editaMetodo(edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(MetodoServerEditComponent, {
      width: '800px',
      data: {
        item: edicao,
        origem: this.principal
      }
    });
  }


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

}
