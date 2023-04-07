/* tslint:disable */
import {
  ProdutoPlataforma,
  VisitaProdutoPlataforma
} from '../index';

declare var Object: any;
export interface PlataformaVendaInterface {
  "nome"?: string;
  "id"?: number;
  produtoPlataformas?: ProdutoPlataforma[];
  visitaProdutoPlataformas?: VisitaProdutoPlataforma[];
}

export class PlataformaVenda implements PlataformaVendaInterface {
  "nome": string;
  "id": number;
  produtoPlataformas: ProdutoPlataforma[];
  visitaProdutoPlataformas: VisitaProdutoPlataforma[];
  constructor(data?: PlataformaVendaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `PlataformaVenda`.
   */
  public static getModelName() {
    return "PlataformaVenda";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of PlataformaVenda for dynamic purposes.
  **/
  public static factory(data: PlataformaVendaInterface): PlataformaVenda{
    return new PlataformaVenda(data);
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
      name: 'PlataformaVenda',
      plural: 'PlataformaVendas',
      path: 'PlataformaVendas',
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
      },
      relations: {
        produtoPlataformas: {
          name: 'produtoPlataformas',
          type: 'ProdutoPlataforma[]',
          model: 'ProdutoPlataforma',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'plataformaVendaId'
        },
        visitaProdutoPlataformas: {
          name: 'visitaProdutoPlataformas',
          type: 'VisitaProdutoPlataforma[]',
          model: 'VisitaProdutoPlataforma',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'plataformaVendaId'
        },
      }
    }
  }
}
