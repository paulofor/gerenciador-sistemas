import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { LinuxInternetApi, LinuxInternet } from '../shared/sdk';

@Component({
  selector: 'app-linux-internet-edit',
  templateUrl: './linux-internet-edit.component.html',
  styleUrls: ['./linux-internet-edit.component.css']
})
export class LinuxInternetEditComponent extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: LinuxInternetApi,
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    return new LinuxInternet();
  }

  preSubmit() {
    if (!this.item.dataCriacao) {
      this.item.dataCriacao = new Date();
    }
  }
}
