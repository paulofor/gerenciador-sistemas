import { Component, OnInit } from '@angular/core';
import { LinuxInternetApi } from '../shared/sdk';
import { LinuxInternetEditComponent } from '../linux-internet-edit/linux-internet-edit.component';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';

@Component({
  selector: 'app-linux-internet-list',
  templateUrl: './linux-internet-list.component.html',
  styleUrls: ['./linux-internet-list.component.css']
})
export class LinuxInternetListComponent  extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:LinuxInternetApi) {
    super(dialog,srv)
  }

  getComponente() {
    return LinuxInternetEditComponent;
  }

  getFiltro() {
    let filtro = { 
      
    };
    return filtro;
  }

}
