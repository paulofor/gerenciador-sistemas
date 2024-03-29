import { Component, Inject, OnInit } from '@angular/core';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { AtributoEntidade, AtributoEntidadeApi, Entidade, EntidadeApi, RelacionamentoEntidade, RelacionamentoEntidadeApi } from '../shared/sdk';

@Component({
  selector: 'app-relacionamento-entidade-edit',
  templateUrl: './relacionamento-entidade-edit.component.html',
  styleUrls: ['./relacionamento-entidade-edit.component.css']
})
export class RelacionamentoEntidadeEditComponent extends BaseEditComponent {

  listaEntidade: Entidade[];
  tela = {'cardinal' : null, 'entidadeId': null, 'atributoChaveEstrangeiraId' : null }
  listaAtributo: AtributoEntidade[];

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: RelacionamentoEntidadeApi,
    private srvEntidade:EntidadeApi, private srvAtributo:AtributoEntidadeApi
  ) {
    super(dialogRef,data,servico);
  }

  posItem() {
    if ( this.item.entidade1Id == this.origem.id) {
      this.tela.entidadeId = this.item.entidadeNId; 
      this.tela.cardinal='N'
    } 
    if (this.item.entidadeNId == this.origem.id) {
      this.tela.entidadeId = this.item.entidade1Id;
      this.tela.cardinal='1'
    } 
  }

  onEntidadeSelecionada(entidadeId: number) {
    console.log('Entidade selecionado:' , entidadeId);
    if (this.tela.cardinal=='N' || this.tela.cardinal=='1') {
      // Filtrar a lista de atributos com base no entidadeId selecionado
      this.srvAtributo.find({'where' : {'entidadeId' : entidadeId}})
        .subscribe((result:AtributoEntidade[]) => {
        this.listaAtributo = result;
      })
    // Limpar a seleção do atributo chave estrangeira
    }
    this.tela.atributoChaveEstrangeiraId = null;
  }
  

  preSubmit(): void {
      console.log('Tela:' , this.tela);
      if (this.tela.cardinal=='N') {
        this.item.entidadeNId = this.tela.entidadeId;
        this.item.entidade1Id = this.origem.id;
      } 
      if (this.tela.cardinal=='1') {
        this.item.entidade1Id = this.tela.entidadeId;
        this.item.entidadeNId = this.origem.id;
      } 
      this.item.atributoChaveEstrangeiraId = this.tela.atributoChaveEstrangeiraId;
      delete this.item['entidadeN'];
      delete this.item['entidade1'];
  }

  criaItem() {
      let novo = new RelacionamentoEntidade();
      return novo;
  }

  montaCombos(): void {
      let filtro = {'order' : 'nome', 'where' : {'sistemaId' : this.origem.sistemaId}}
      this.srvEntidade.find(filtro)
        .subscribe((result:Entidade[]) => {
          console.log('listaEntidade' , result);
          this.listaEntidade = result;
        })
  }
}
