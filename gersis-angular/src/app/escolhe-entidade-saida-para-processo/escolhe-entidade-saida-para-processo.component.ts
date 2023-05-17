import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseSelecionaEditComponent } from '../base-component/base-seleciona-component';
import { EntidadeApi, ProcessoEntidadeSaidaRelApi, ProcessoEntidadeSaidaRel } from '../shared/sdk';

@Component({
  selector: 'app-escolhe-entidade-saida-para-processo',
  templateUrl: './escolhe-entidade-saida-para-processo.component.html',
  styleUrls: ['./escolhe-entidade-saida-para-processo.component.css']
})
export class EscolheEntidadeSaidaParaProcessoComponent extends BaseSelecionaEditComponent{


  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected srvItem: EntidadeApi, protected srvRel: ProcessoEntidadeSaidaRelApi
  ) {
    super(dialogRef, data, srvItem, srvRel );
  }  


  getNomePropriedadeRel(): string {
    return "processoJavaComoSaida";
  }
  criaRelacionamento() {
    return new ProcessoEntidadeSaidaRel();
  }
  getNomeChaveItem(): string {
    return "id";
  }
  getNomeChaveItemNoRelacionamento(): string {
    return "entidadeId";
  }
  getNomeChaveOrigemNoRelacionamento(): string {
    return "processoJavaId";
  }
  getNomeFuncaoAtualizacaoRelacionamento(): string {
    return "AtualizaPorProcesso";
  }

  getFiltro() {
    return {
      'where' : {'sistemaId' : this.origem.sistemaId},
      'order' : 'nome',
      'include' : {
        'relation' : 'processoJavaComoSaida',
        'scope' : {
          'where' : {'entidadeId' : this.origem.id }
        } 
      }
    }
  }

}



