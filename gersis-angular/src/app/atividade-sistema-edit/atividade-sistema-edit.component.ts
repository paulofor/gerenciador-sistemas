import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditSistemaComponent } from '../base-component/base-edit-sistema-component';
import { AtividadeSistemaApi, AtividadeSistema } from '../shared/sdk';

@Component({
  selector: 'app-atividade-sistema-edit',
  templateUrl: './atividade-sistema-edit.component.html',
  styleUrls: ['./atividade-sistema-edit.component.css']
})
export class AtividadeSistemaEditComponent extends BaseEditSistemaComponent {

  //listaLinux:LinuxInternet[];

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: AtividadeSistemaApi
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    let novo : AtividadeSistema = new AtividadeSistema();
    novo['sistemaId'] = this.idSistema;
    return novo;
  }

 

  preSubmit() {
    //delete this.item['linuxInternet']
  }
}
