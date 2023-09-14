import { Component, OnInit } from '@angular/core';
import { AtividadeSistemaApi, SistemaApi } from '../shared/sdk';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { AtividadeSistemaEditComponent } from '../atividade-sistema-edit/atividade-sistema-edit.component';
import { BaseListSistemaComponent } from '../base-component/base-list-sistema-component';

@Component({
  selector: 'app-atividade-sistema-list',
  templateUrl: './atividade-sistema-list.component.html',
  styleUrls: ['./atividade-sistema-list.component.css']
})
export class AtividadeSistemaListComponent extends BaseListSistemaComponent {

  constructor(protected dialog: MatDialog, protected srv:AtividadeSistemaApi, protected router: ActivatedRoute, protected srvSistema:SistemaApi) { 
    super(dialog,srv,router,srvSistema)
  }

  getFiltro() {
    return {
      'order' : 'nome',
    }
  }

  getComponente() {
    return AtividadeSistemaEditComponent;
  }
}
