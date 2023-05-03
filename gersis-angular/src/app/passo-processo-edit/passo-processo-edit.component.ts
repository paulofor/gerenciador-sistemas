import { Component, Inject, OnInit } from '@angular/core';
import { PassoProcessoJava, PassoProcessoJavaApi } from '../shared/sdk';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';

@Component({
  selector: 'app-passo-processo-edit',
  templateUrl: './passo-processo-edit.component.html',
  styleUrls: ['./passo-processo-edit.component.css']
})
export class PassoProcessoEditComponent  extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: PassoProcessoJavaApi,
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    let novo : PassoProcessoJava = new PassoProcessoJava();
    console.log('Origem:' , this.origem);
    novo['processoJavaId'] = this.origem.id;
    return novo;
  }

}
