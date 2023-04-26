import { Component, OnInit } from '@angular/core';
import { SistemaApi } from '../shared/sdk';
import { SistemaEditComponent } from '../sistema-edit/sistema-edit.component';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';

@Component({
  selector: 'app-sistema-list',
  templateUrl: './sistema-list.component.html',
  styleUrls: ['./sistema-list.component.css']
})
export class SistemaListComponent  extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:SistemaApi) {
    super(dialog,srv)
  }

  getComponente() {
    return SistemaEditComponent;
  }

  getFiltro() {
    let filtro = {
      'order' : 'nome'
    }; 
    return filtro;
  }

}
