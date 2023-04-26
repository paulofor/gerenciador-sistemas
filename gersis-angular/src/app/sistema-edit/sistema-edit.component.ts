import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { SistemaApi, Sistema } from '../shared/sdk';

@Component({
  selector: 'app-sistema-edit',
  templateUrl: './sistema-edit.component.html',
  styleUrls: ['./sistema-edit.component.css']
})
export class SistemaEditComponent extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: SistemaApi,
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    return new Sistema();
  }

  preSubmit() {
    if (!this.item.dataCriacao) {
      this.item.dataCriacao = new Date();
    }
  }
}
