import { Component } from '@angular/core';
import { EntidadeApi } from '../shared/sdk';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { BaseItemIdComponent } from '../base-component/base-item-id-component';
import { AtributoEntidadeEditComponent } from '../atributo-entidade-edit/atributo-entidade-edit.component';
import { RelacionamentoEntidadeEditComponent } from '../relacionamento-entidade-edit/relacionamento-entidade-edit.component';
import { MetodoServerEditComponent } from '../metodo-server-edit/metodo-server-edit.component';
import { ParametroMetodoServerEditComponent } from '../parametro-metodo-server-edit/parametro-metodo-server-edit.component';
import { TelaFrontEditComponent } from '../tela-front-edit/tela-front-edit.component';

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
        { 'relation': 'metodoServers', 
          'scope' : {'order' : 'nome' , 'include' : {'relation' : 'parametroMetodoServers' , 'scope' : {'order' : 'posicao'} } } },
        { 'relation': 'relacionamentos1', 'scope': { 'include': ['entidade1','atributoChaveEstrangeira'] } },
        { 'relation': 'relacionamentosN', 'scope': { 'include': ['entidadeN','atributoChaveEstrangeira'] } },
        { 'relation': 'processoJavaComoSaida', 'scope': { 'include': 'processoJava' } },
        { 'relation': 'telaFronts'}
      ]
    }
  }

  editaParametroMetodoServer(origem, edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(ParametroMetodoServerEditComponent, {
      width: '800px',
      data: {
        item: edicao,
        origem: origem
      }
    });
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

  editaTela(edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(TelaFrontEditComponent, {
      width: '800px',
      data: {
        item: edicao,
        origem: this.principal
      }
    });
  }

  editaParametro(edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(ParametroMetodoServerEditComponent, {
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
