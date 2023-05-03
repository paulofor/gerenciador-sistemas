import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditSistemaComponent } from '../base-component/base-edit-sistema-component';
import { MetodoServerApi, MetodoServer } from '../shared/sdk';
import { BaseEditComponent } from '../base-component/base-edit-component';

@Component({
  selector: 'app-metodo-server-edit',
  templateUrl: './metodo-server-edit.component.html',
  styleUrls: ['./metodo-server-edit.component.css']
})
export class MetodoServerEditComponent  extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: MetodoServerApi,
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    let novo : MetodoServer = new MetodoServer();
    console.log('Origem:' , this.origem);
    novo['entidadeId'] = this.origem.id;
    return novo;
  }

}