import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { BaseListSistemaComponent } from '../base-component/base-list-sistema-component';
import { ProcessoJavaEditComponent } from '../processo-java-edit/processo-java-edit.component';
import { ProcessoJavaApi, SistemaApi } from '../shared/sdk';

@Component({
  selector: 'app-processo-java-list',
  templateUrl: './processo-java-list.component.html',
  styleUrls: ['./processo-java-list.component.css']
})
export class ProcessoJavaListComponent extends BaseListSistemaComponent {

  constructor(protected dialog: MatDialog, protected srv:ProcessoJavaApi, protected router: ActivatedRoute, protected srvSistema:SistemaApi) { 
    super(dialog,srv,router,srvSistema)
  }

  getFiltro() {
    return {
      'order' : 'nomeClasseMain',
      'include' : ['linuxInternet']
    }
  }

  getComponente() {
    return ProcessoJavaEditComponent;
  }
}
