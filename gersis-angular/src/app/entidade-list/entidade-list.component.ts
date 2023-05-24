import { Component, OnInit } from '@angular/core';
import { BaseListSistemaComponent } from '../base-component/base-list-sistema-component';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { EntidadeApi, SistemaApi } from '../shared/sdk';
import { EntidadeEditComponent } from '../entidade-edit/entidade-edit.component';

@Component({
  selector: 'app-entidade-list',
  templateUrl: './entidade-list.component.html',
  styleUrls: ['./entidade-list.component.css']
})
export class EntidadeListComponent extends BaseListSistemaComponent {

  constructor(protected dialog: MatDialog, protected srv:EntidadeApi, protected router: ActivatedRoute,protected srvSistema:SistemaApi) { 
    super(dialog,srv,router,srvSistema)
  }

  getFiltro() {
    return {
      'order' : 'nome'
    }
  }

  getComponente() {
    return EntidadeEditComponent;
  }
}
