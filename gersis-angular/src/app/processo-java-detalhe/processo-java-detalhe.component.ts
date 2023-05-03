import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { BaseItemIdComponent } from '../base-component/base-item-id-component';
import { ProcessoJavaApi } from '../shared/sdk';
import { PassoProcessoEditComponent } from '../passo-processo-edit/passo-processo-edit.component';

@Component({
  selector: 'app-processo-java-detalhe',
  templateUrl: './processo-java-detalhe.component.html',
  styleUrls: ['./processo-java-detalhe.component.css']
})
export class ProcessoJavaDetalheComponent extends BaseItemIdComponent {

  constructor(protected dialog: MatDialog, protected srv: ProcessoJavaApi, protected router: ActivatedRoute) {
    super(dialog, srv, router);
  }

  
  getFiltro() {
    return {
      'include': [ 
        { 'relation': 'passoProcessoJavas', 'scope' : {'order' : 'ordenacao'} }
      ]
    }
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
