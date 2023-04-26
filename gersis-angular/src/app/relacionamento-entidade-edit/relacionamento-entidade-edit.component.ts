import { Component, Inject, OnInit } from '@angular/core';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { RelacionamentoEntidadeApi } from '../shared/sdk';

@Component({
  selector: 'app-relacionamento-entidade-edit',
  templateUrl: './relacionamento-entidade-edit.component.html',
  styleUrls: ['./relacionamento-entidade-edit.component.css']
})
export class RelacionamentoEntidadeEditComponent extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: RelacionamentoEntidadeApi,
  ) {
    super(dialogRef,data,servico);
  }

}
