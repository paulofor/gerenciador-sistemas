import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseSelecionaEditComponent } from '../base-component/base-seleciona-component';
import { MetodoServerApi, PythonMetodoEntradaApi, PythonMetodoEntrada } from '../shared/sdk';



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
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected srvItem: MetodoServerApi, protected srvRel: PythonMetodoEntradaApi
  ) {
    super(dialogRef, data, srvItem, srvRel );
  }  


  getNomePropriedadeRel(): string {
    return "processoPythonComoEntrada";
  }
  criaRelacionamento() {
    return new PythonMetodoEntrada();
  }
  getNomeChaveItem(): string {
    return "id";
  }
  getNomeChaveItemNoRelacionamento(): string {
    return "metodoServerId";
  }
  getNomeChaveOrigemNoRelacionamento(): string {
    return "processoPythonId";
  }
  getNomeFuncaoAtualizacaoRelacionamento(): string {
    return "AtualizaPorProcessoEntrada";
  }

  getFiltro() {
    return {
      'where' : {'sistemaId' : this.origem.sistemaId},
      'order' : 'nome',
      'include' : ['entidade', {
        'relation' : 'processoPythonComoEntrada',
        'scope' : {
          'where' : {'processoPythonId' : this.origem.id }
        } 
      }]
    }
  }

}



