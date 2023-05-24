import { Component, Inject, OnInit } from '@angular/core';
import { DadoPassoProcessoEntradaRel, DadoPassoProcessoEntradaRelApi, DadoProcessoApi, Entidade } from '../shared/sdk';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { ProcessoJavaApi } from '../shared/sdk/services/custom/ProcessoJava';
import { BaseSelecionaEditComponent } from '../base-component/base-seleciona-component';

@Component({
  selector: 'app-dado-processo-entrada-edit',
  templateUrl: './dado-processo-entrada-edit.component.html',
  styleUrls: ['./dado-processo-entrada-edit.component.css']
})
export class DadoProcessoEntradaEditComponent extends BaseSelecionaEditComponent{


  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected srvItem: DadoProcessoApi, protected srvRel: DadoPassoProcessoEntradaRelApi
  ) {
    super(dialogRef, data, srvItem, srvRel );
  }  

  
  getNomeRelacionamento(): string {
    return "passoProcessoJavaComoEntrada";
  }

  getNomePropriedadeRel(): string {
    return "passoProcessoJavaComoEntrada";
  }
  criaRelacionamento() {
    return new DadoPassoProcessoEntradaRel();
  }
  getNomeChaveItem(): string {
    return "id";
  }
  getNomeChaveItemNoRelacionamento(): string {
    return "dadoProcessoId";
  }
  getNomeChaveOrigemNoRelacionamento(): string {
    return "passoProcessoJavaId";
  }
  getNomeFuncaoAtualizacaoRelacionamento(): string {
    return "AtualizaPorPassoProcesso";
  }

  getFiltro() {
    return {
      'where' : {'processoJavaId' : this.origem.processoJavaId},
      'order' : 'nome',
      'include' : [{
        'relation' : 'passoProcessoJavaComoEntrada',
        'scope' : {
          'where' : {'dadoProcessoId' : this.origem.id }
        } 
      }, 'tipoEntidade']
    }
  }

}



