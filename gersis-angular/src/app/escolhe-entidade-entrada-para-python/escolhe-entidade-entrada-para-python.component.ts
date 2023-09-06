import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseSelecionaEditComponent } from '../base-component/base-seleciona-component';
import { EntidadeApi, PythonEntidadeEntradaRelApi, PythonEntidadeEntradaRel } from '../shared/sdk';

@Component({
  selector: 'app-escolhe-entidade-entrada-para-python',
  templateUrl: './escolhe-entidade-entrada-para-python.component.html',
  styleUrls: ['./escolhe-entidade-entrada-para-python.component.css']
})
export class EscolheEntidadeEntradaParaPythonComponent extends BaseSelecionaEditComponent{

  getNomeRelacionamento(): string {
    return "processoPythonComoEntrada";
  }


  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected srvItem: EntidadeApi, protected srvRel: PythonEntidadeEntradaRelApi
  ) {
    super(dialogRef, data, srvItem, srvRel );
  }  


  getNomePropriedadeRel(): string {
    return "processoPythonComoEntrada";
  }
  criaRelacionamento() {
    return new PythonEntidadeEntradaRel();
  }
  getNomeChaveItem(): string {
    return "id";
  }
  getNomeChaveItemNoRelacionamento(): string {
    return "entidadeId";
  }
  getNomeChaveOrigemNoRelacionamento(): string {
    return "processoPythonId";
  }
  getNomeFuncaoAtualizacaoRelacionamento(): string {
    return "AtualizaPorProcessoPythonEntrada";
  }

  getFiltro() {
    return {
      'where' : {'sistemaId' : this.origem.sistemaId},
      'order' : 'nome',
      'include' : {
        'relation' : 'processoPythonComoEntrada',
        'scope' : {
          'where' : {'entidadeId' : this.origem.id }
        } 
      }
    }
  }

}



