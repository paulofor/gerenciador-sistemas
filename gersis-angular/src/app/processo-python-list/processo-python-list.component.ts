import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { BaseListSistemaComponent } from '../base-component/base-list-sistema-component';
import { ProcessoPythonEditComponent } from '../processo-python-edit/processo-python-edit.component';
import { ProcessoPythonApi, SistemaApi } from '../shared/sdk';

@Component({
  selector: 'app-processo-python-list',
  templateUrl: './processo-python-list.component.html',
  styleUrls: ['./processo-python-list.component.css']
})
export class ProcessoPythonListComponent extends BaseListSistemaComponent {

  constructor(protected dialog: MatDialog, protected srv:ProcessoPythonApi, protected router: ActivatedRoute, protected srvSistema:SistemaApi) { 
    super(dialog,srv,router,srvSistema)
  }

  getFiltro() {
    return {
      'order' : 'nomeArquivo'
    }
  }

  getComponente() {
    return ProcessoPythonEditComponent;
  }
}
