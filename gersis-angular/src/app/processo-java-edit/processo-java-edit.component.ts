import { Component, Inject, OnInit } from '@angular/core';
import { LinuxInternet, LinuxInternetApi, ProcessoJava, ProcessoJavaApi } from '../shared/sdk';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditSistemaComponent } from '../base-component/base-edit-sistema-component';

@Component({
  selector: 'app-processo-java-edit',
  templateUrl: './processo-java-edit.component.html',
  styleUrls: ['./processo-java-edit.component.css']
})
export class ProcessoJavaEditComponent extends BaseEditSistemaComponent {

  listaLinux:LinuxInternet[];

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: ProcessoJavaApi, private srvLinux:LinuxInternetApi
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    let novo : ProcessoJava = new ProcessoJava();
    novo['sistemaId'] = this.idSistema;
    novo.linuxInternetId = 0;
    return novo;
  }

  montaCombos(): void {
    let filtro = {'order' : 'nome'};
      this.srvLinux.find(filtro)
        .subscribe((servidores:LinuxInternet[]) => {
          console.log('Linux:' , servidores);
          this.listaLinux = servidores;
        })  
  }

  preSubmit() {
    delete this.item['linuxInternet']
    //if (!this.item.dataCriacao) {
    //  this.item.dataCriacao = new Date();
    //}
  }
}
