import { Component, Inject, OnInit } from '@angular/core';
import { DadoProcesso, Entidade, ProcessoJavaApi } from '../shared/sdk';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { DadoProcessoApi } from '../shared/sdk/services/custom/DadoProcesso';

@Component({
  selector: 'app-dado-processo-edit',
  templateUrl: './dado-processo-edit.component.html',
  styleUrls: ['./dado-processo-edit.component.css']
})
export class DadoProcessoEditComponent extends BaseEditComponent {

  listaEntidade:Entidade[];

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: DadoProcessoApi, private srvProcesso:ProcessoJavaApi
  ) {
    super(dialogRef,data,servico);
  }

  montaCombos(): void {
      this.srvProcesso.ListaEntidadeDisponivel(this.origem.id)
        .subscribe((result:Entidade[]) => {
          this.listaEntidade = result;
        })
  }

  criaItem() {
    let novo : DadoProcesso = new DadoProcesso();
    console.log('Origem:' , this.origem);
    novo['processoJavaId'] = this.origem.id;
    return novo;
  }

  preSubmit(): void {
      delete this.item['tipoEntidade']
  }

}
