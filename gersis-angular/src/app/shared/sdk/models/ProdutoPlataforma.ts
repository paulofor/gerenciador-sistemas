/* tslint:disable */
import {
  PlataformaVenda,
  VisitaProdutoPlataforma
} from '../index';

declare var Object: any;
export interface ProdutoPlataformaInterface {
  "nome"?: string;
  "id"?: number;
  "plataformaVendaId"?: number;
  plataformaVenda?: PlataformaVenda;
  visitaProdutoPlataformas?: VisitaProdutoPlataforma[];
}

export class ProdutoPlataforma implements ProdutoPlataformaInterface {
  "nome": string;
  "id": number;
  "plataformaVendaId": number;
  plataformaVenda: PlataformaVenda;
  visitaProdutoPlataformas: VisitaProdutoPlataforma[];
  constructor(data?: ProdutoPlataformaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ProdutoPlataforma`.
   */
  public static getModelName() {
    return "ProdutoPlataforma";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ProdutoPlataforma for dynamic purposes.
  **/
  public static factory(data: ProdutoPlataformaInterface): ProdutoPlataforma{
    return new ProdutoPlataforma(data);
  }
  /**
  * @method getModelDefinition
  * @author Julien Ledun
  * @license MIT
  * This method returns an object that represents some of the model
  * definitions.
  **/
  public static getModelDefinition() {
    return {
      name: 'ProdutoPlataforma',
      plural: 'ProdutoPlataformas',
      path: 'ProdutoPlataformas',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "plataformaVendaId": {
          name: 'plataformaVendaId',
          type: 'number'
        },
      },
      relations: {
        plataformaVenda: {
          name: 'plataformaVenda',
          type: 'PlataformaVenda',
          model: 'PlataformaVenda',
          relationType: 'belongsTo',
                  keyFrom: 'plataformaVendaId',
          keyTo: 'id'
        },
        visitaProdutoPlataformas: {
          name: 'visitaProdutoPlataformas',
          type: 'VisitaProdutoPlataforma[]',
          model: 'VisitaProdutoPlataforma',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'produtoPlataformaId'
        },
      }
    }
  }
}
