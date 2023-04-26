import { Component, Inject, OnInit } from '@angular/core';
import { Entidade, EntidadeApi } from '../shared/sdk';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditSistemaComponent } from '../base-component/base-edit-sistema-component';

@Component({
  selector: 'app-entidade-edit',
  templateUrl: './entidade-edit.component.html',
  styleUrls: ['./entidade-edit.component.css']
})
export class EntidadeEditComponent extends BaseEditSistemaComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: EntidadeApi,
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    let novo : Entidade = new Entidade();
    novo['sistemaId'] = this.idSistema;
    return novo;
  }

  preSubmit() {
    if (!this.item.dataCriacao) {
      this.item.dataCriacao = new Date();
    }
  }
}
