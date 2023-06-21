import { Component, Inject, OnInit } from '@angular/core';
import { Entidade, PassoProcessoJava, PassoProcessoJavaApi, ProcessoJavaApi } from '../shared/sdk';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';

@Component({
  selector: 'app-passo-processo-edit',
  templateUrl: './passo-processo-edit.component.html',
  styleUrls: ['./passo-processo-edit.component.css']
})
export class PassoProcessoEditComponent  extends BaseEditComponent {

  listaEntidadeMetodo;

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: PassoProcessoJavaApi, private srvProcesso:ProcessoJavaApi
  ) {
    super(dialogRef,data,servico);
  }


  atualizarNomeClasse(metodoServerId: any) {
    const metodoSelecionado = this.listaEntidadeMetodo.find(metodo => metodo.id === metodoServerId.value);
    this.item.nomeClasse = metodoSelecionado.nome;
  }


  montaCombos(): void {
    console.log('chamada montaCombo');
    this.srvProcesso.ListaMetodoServerDisponivel(this.origem.id)
      .subscribe((result) => {
        console.log('entrou no result');
        console.log('result' , result);
        this.listaEntidadeMetodo = result.flatMap(entidade =>
          entidade.metodoServers.map(item => ({ "nome": `${entidade.nome}_${item.nome}` , "id" : `${item.id}`}))
        );
        console.log('listaEntidadeMetodo:' , this.listaEntidadeMetodo);
      })
  }

  criaItem() {
    let novo : PassoProcessoJava = new PassoProcessoJava();
    console.log('Origem:' , this.origem);
    novo['processoJavaId'] = this.origem.id;
    novo['ordenacao'] = this.origem.passoProcessoJavas.length + 1;
    return novo;
  }

}
