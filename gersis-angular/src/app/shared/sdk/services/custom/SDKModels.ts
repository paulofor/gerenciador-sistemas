/* tslint:disable */
import { Injectable } from '@angular/core';
import { User } from '../../models/User';
import { PlataformaVenda } from '../../models/PlataformaVenda';
import { ProdutoPlataforma } from '../../models/ProdutoPlataforma';
import { VisitaProdutoPlataforma } from '../../models/VisitaProdutoPlataforma';
import { ProdutoHotmart } from '../../models/ProdutoHotmart';

export interface Models { [name: string]: any }

@Injectable()
export class SDKModels {

  private models: Models = {
    User: User,
    PlataformaVenda: PlataformaVenda,
    ProdutoPlataforma: ProdutoPlataforma,
    VisitaProdutoPlataforma: VisitaProdutoPlataforma,
    ProdutoHotmart: ProdutoHotmart,
    
  };

  public get(modelName: string): any {
    return this.models[modelName];
  }

  public getAll(): Models {
    return this.models;
  }

  public getModelNames(): string[] {
    return Object.keys(this.models);
  }
}
