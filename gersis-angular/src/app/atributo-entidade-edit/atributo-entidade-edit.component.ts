import { Component, Inject, OnInit } from '@angular/core';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { AtributoEntidadeApi } from '../shared/sdk';

@Component({
  selector: 'app-atributo-entidade-edit',
  templateUrl: './atributo-entidade-edit.component.html',
  styleUrls: ['./atributo-entidade-edit.component.css']
})
export class AtributoEntidadeEditComponent extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: AtributoEntidadeApi,
  ) {
    super(dialogRef,data,servico);
  }

}
