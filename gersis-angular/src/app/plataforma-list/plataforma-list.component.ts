import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { PlataformaEditComponent } from '../plataforma-edit/plataforma-edit.component';
import { PlataformaVenda, PlataformaVendaApi } from '../shared/sdk';

@Component({
  selector: 'app-plataforma-list',
  templateUrl: './plataforma-list.component.html',
  styleUrls: ['./plataforma-list.component.css']
})
export class PlataformaListComponent extends BaseListComponent {



  constructor(protected dialog: MatDialog, protected srv:PlataformaVendaApi) { 
    super(dialog,srv)
  }

  getFiltro() {
    return {
      };
  }

  criaItem() {
    let novo = new PlataformaVenda();
    return novo;
  }

  getComponente() {
    return PlataformaEditComponent;
  }


  


}
