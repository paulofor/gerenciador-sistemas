import { Component, Inject, OnInit } from '@angular/core';
import { MetodoServer, MetodoServerApi, TelaFront, TelaFrontApi } from '../shared/sdk';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';

@Component({
  selector: 'app-tela-front-edit',
  templateUrl: './tela-front-edit.component.html',
  styleUrls: ['./tela-front-edit.component.css']
})
export class TelaFrontEditComponent extends BaseEditComponent {

  private listaMetodo : MetodoServer[];

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: TelaFrontApi,private srvMetodo:MetodoServerApi
  ) {
    super(dialogRef,data,servico);
  }


  montaCombos() {
    let filtro = {
      'where' : {'entidadeId' : this.origem.id}
    }
    this.srvMetodo.find(filtro)
      .subscribe((result:MetodoServer[]) => {
        console.log('listaMetodo:' , result);
        this.listaMetodo = result;
      }) 
  }

  criaItem() {
    let novo = new TelaFront();
    novo['entidadeId'] = this.origem.id;
    return novo;
  }

  onChange(event) {
    console.log('event:' ,event);
    if (event.value=='Lista') {
      this.item.nome = this.origem.nome + "List";
    }
    if (event.value=='ListaSimples') {
      this.item.nome = this.origem.nome + "ListSimples";
    }
    if (event.value=='Edicao') {
      this.item.nome = this.origem.nome + "Edit";
    }
    if (event.value=='Detalhe') {
      this.item.nome = this.origem.nome + "Detalhe";
    }
    if (event.value=='EditRel') {
      this.item.nome = this.origem.nome + "EditRel";
    }
  }
}
