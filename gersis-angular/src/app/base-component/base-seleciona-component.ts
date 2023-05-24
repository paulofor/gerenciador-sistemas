import { Inject, OnInit } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

export abstract class BaseSelecionaEditComponent implements OnInit{

    listaItem:any[];

    item: any;
    origem: any;

    constructor(protected dialogRef: MatDialogRef<any>
        , @Inject(MAT_DIALOG_DATA) protected data: any, protected srvItem: any, protected srvRel: any
      ) {
      }
    

  ngOnInit() {
    console.log("Parametro entrada", this.data);
    if (this.data.origem) {
      this.origem = this.data.origem;
    }
    let filtro = this.getFiltro();
    console.log('filtro' , JSON.stringify(filtro));
    console.log('Api:' , this.srvItem);
    console.log('Origem:' + JSON.stringify(this.origem));
    this.srvItem.find(filtro)
      .subscribe((result: any[]) => {
        console.log('result:' , result);
        this.listaItem = result;
        for (let i=0; i<this.listaItem.length;i++) {
          let atual = this.listaItem[i];
          console.log('atual:' , atual);
          if (atual[this.getNomePropriedadeRel()].length > 0) {
            console.log('[0]' ,atual[this.getNomePropriedadeRel()][0] )
            if (atual[this.getNomePropriedadeRel()][0][this.getNomeChaveOrigemNoRelacionamento()] != this.origem.id) {
              console.log('entrou', i);
              this.listaItem[i][this.getNomePropriedadeRel()] = []
              this.listaItem[i][this.getNomePropriedadeRel()].splice(0, this.listaItem[i][this.getNomePropriedadeRel()].length);
            }
          }
        }
        console.log('listaItem(seleciona):' , this.listaItem);
        /*        
        this.listaItem.forEach(item => {
          console.log('item:', item);
          //console.log('valor: ', item[this.getNomePropriedadeRel()][0][this.getNomeChaveItemNoRelacionamento()] );
          console.log('origemid', this.origem.id);
          if (item[this.getNomePropriedadeRel()][0] && item[this.getNomePropriedadeRel()][0][this.getNomeChaveItemNoRelacionamento()] != this.origem.id) {
            item[this.getNomePropriedadeRel()] = [];
            console.log('entrou: ', item[this.getNomePropriedadeRel()][0][this.getNomeChaveItemNoRelacionamento()] );
          }
        });
        */
      })

  }

   
  onChange(event, index, item : any) {
    if (event.checked) {
      let relNovo = this.criaRelacionamento();
      relNovo[this.getNomeChaveOrigemNoRelacionamento()] = this.origem.id;
      relNovo[this.getNomeChaveItemNoRelacionamento()] = item[this.getNomeChaveItem()];
      item[this.getNomePropriedadeRel()].push(relNovo);
    } else {
      item[this.getNomePropriedadeRel()] = [];
    }
  }
  
  onSubmit() {
    let listaEnvio:any[] = [];
    for(let i=0;i<this.listaItem.length;i++) {
      if (this.listaItem[i][this.getNomePropriedadeRel()].length>0) {
        listaEnvio.push(this.listaItem[i][this.getNomePropriedadeRel()][0]);
      }
    };
    if (!this.srvRel[this.getNomeFuncaoAtualizacaoRelacionamento()]) {
      console.log('Não existe ' , this.getNomeFuncaoAtualizacaoRelacionamento() , ' em ' , this.srvRel);
    }
    this.srvRel[this.getNomeFuncaoAtualizacaoRelacionamento()](this.origem.id, listaEnvio)
      .subscribe((resultado) => {
        this.dialogRef.close('Pizza!');
      })
  }
  getCheck(item:any) : boolean {
    return (item[this.getNomePropriedadeRel()].length>0);
  }

  abstract getNomePropriedadeRel(): string;
  abstract criaRelacionamento();
  abstract getNomeChaveItem(): string;
  abstract getNomeChaveItemNoRelacionamento(): string;
  abstract getNomeChaveOrigemNoRelacionamento(): string;
  abstract getNomeFuncaoAtualizacaoRelacionamento() : string;

  getFiltro() {
      return {};
  }

 
 
}