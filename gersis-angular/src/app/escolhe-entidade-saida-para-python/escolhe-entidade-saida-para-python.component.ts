import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseSelecionaEditComponent } from '../base-component/base-seleciona-component';
import { EntidadeApi, PythonEntidadeSaidaRelApi, PythonEntidadeSaidaRel } from '../shared/sdk';

@Component({
  selector: 'app-escolhe-entidade-saida-para-python',
  templateUrl: './escolhe-entidade-saida-para-python.component.html',
  styleUrls: ['./escolhe-entidade-saida-para-python.component.css']
})
export class EscolheEntidadeSaidaParaPythonComponent extends BaseSelecionaEditComponent{


  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected srvItem: EntidadeApi, protected srvRel: PythonEntidadeSaidaRelApi
  ) {
    super(dialogRef, data, srvItem, srvRel );
  }  


  getNomePropriedadeRel(): string {
    return "processoPythonComoSaida";
  }
  criaRelacionamento() {
    return new PythonEntidadeSaidaRel();
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
    return "AtualizaPorProcessoPythonSaida";
  }

  getFiltro() {
    return {
      'where' : {'sistemaId' : this.origem.sistemaId},
      'order' : 'nome',
      'include' : {
        'relation' : 'processoPythonComoSaida',
        'scope' : {
          'where' : {'entidadeId' : this.origem.id }
        } 
      }
    }
  }

}



