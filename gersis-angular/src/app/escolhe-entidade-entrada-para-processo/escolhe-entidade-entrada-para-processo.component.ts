import { Component, Inject, OnInit } from '@angular/core';
import { EntidadeApi, ProcessoEntidadeEntradaRel, ProcessoEntidadeEntradaRelApi}  from '../shared/sdk';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseSelecionaEditComponent } from '../base-component/base-seleciona-component';

@Component({
  selector: 'app-escolhe-entidade-entrada-para-processo',
  templateUrl: './escolhe-entidade-entrada-para-processo.component.html',
  styleUrls: ['./escolhe-entidade-entrada-para-processo.component.css']
})
export class EscolheEntidadeEntradaParaProcessoComponent extends BaseSelecionaEditComponent{
  getNomeRelacionamento(): string {
    return "processoJavaComoEntrada";
  }


  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected srvItem: EntidadeApi, protected srvRel: ProcessoEntidadeEntradaRelApi
  ) {
    super(dialogRef, data, srvItem, srvRel );
  }  


  getNomePropriedadeRel(): string {
    return "processoJavaComoEntrada";
  }
  criaRelacionamento() {
    return new ProcessoEntidadeEntradaRel();
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
        'relation' : 'processoJavaComoEntrada',
        'scope' : {
          'where' : {'entidadeId' : this.origem.id }
        } 
      }
    }
  }

}



