import { Component, Inject, OnInit } from '@angular/core';
import { ProcessoPython, ProcessoPythonApi } from '../shared/sdk';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditSistemaComponent } from '../base-component/base-edit-sistema-component';

@Component({
  selector: 'app-processo-python-edit',
  templateUrl: './processo-python-edit.component.html',
  styleUrls: ['./processo-python-edit.component.css']
})
export class ProcessoPythonEditComponent extends BaseEditSistemaComponent {

  //listaLinux:LinuxInternet[];

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: ProcessoPythonApi
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    let novo : ProcessoPython = new ProcessoPython();
    novo['sistemaId'] = this.idSistema;
    return novo;
  }

 

  preSubmit() {
    //delete this.item['linuxInternet']
  }
}
