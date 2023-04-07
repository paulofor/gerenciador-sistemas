import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { ProdutoHotmartApi } from '../shared/sdk';

@Component({
  selector: 'app-produto-hotmart-list',
  templateUrl: './produto-hotmart-list.component.html',
  styleUrls: ['./produto-hotmart-list.component.css']
})
export class ProdutoHotmartListComponent extends BaseListComponent {



  constructor(protected dialog: MatDialog, protected srv:ProdutoHotmartApi) { 
    super(dialog,srv)
  }

  getFiltro() {
    return {
      'limit' : 50,
      'order' : 'temperatura desc'
      };
  }




}
