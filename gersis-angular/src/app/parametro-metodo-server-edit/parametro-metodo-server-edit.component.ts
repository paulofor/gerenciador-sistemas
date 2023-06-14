import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditSistemaComponent } from '../base-component/base-edit-sistema-component';
import { ParametroMetodoServerApi, ParametroMetodoServer } from '../shared/sdk';

@Component({
  selector: 'app-parametro-metodo-server-edit',
  templateUrl: './parametro-metodo-server-edit.component.html',
  styleUrls: ['./parametro-metodo-server-edit.component.css']
})
export class ParametroMetodoServerEditComponent  extends BaseEditSistemaComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: ParametroMetodoServerApi,
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    let novo : ParametroMetodoServer = new ParametroMetodoServer();
    novo['metodoServerId'] = this.origem.id;
    return novo;
  }

  preSubmit() {
   
  }
}
