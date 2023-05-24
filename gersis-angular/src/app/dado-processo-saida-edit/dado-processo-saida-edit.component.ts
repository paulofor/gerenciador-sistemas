import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { DadoPassoProcessoSaidaRel, DadoPassoProcessoSaidaRelApi, DadoProcessoApi, Entidade, ProcessoJavaApi } from '../shared/sdk';
import { BaseSelecionaEditComponent } from '../base-component/base-seleciona-component';

@Component({
  selector: 'app-dado-processo-saida-edit',
  templateUrl: './dado-processo-saida-edit.component.html',
  styleUrls: ['./dado-processo-saida-edit.component.css']
})
export class DadoProcessoSaidaEditComponent extends BaseSelecionaEditComponent{

  
  getNomeRelacionamento(): string {
    return "passoProcessoJavaComoSaida";
  }


  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected srvItem: DadoProcessoApi, protected srvRel: DadoPassoProcessoSaidaRelApi
  ) {
    super(dialogRef, data, srvItem, srvRel );
  }  


  getNomePropriedadeRel(): string {
    return "passoProcessoJavaComoSaida";
  }
  criaRelacionamento() {
    return new DadoPassoProcessoSaidaRel();
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
        'relation' : 'passoProcessoJavaComoSaida',
        'scope' : {
          'where' : {'dadoProcessoId' : this.origem.id }
        } 
      }, 'tipoEntidade']
    }
  }

}



