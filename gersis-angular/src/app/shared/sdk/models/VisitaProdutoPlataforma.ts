/* tslint:disable */

declare var Object: any;
export interface VisitaProdutoPlataformaInterface {
  "plataformaVendaId"?: number;
  "produtoPlataformaId"?: number;
  "dataVisita"?: Date;
}

export class VisitaProdutoPlataforma implements VisitaProdutoPlataformaInterface {
  "plataformaVendaId": number;
  "produtoPlataformaId": number;
  "dataVisita": Date;
  constructor(data?: VisitaProdutoPlataformaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `VisitaProdutoPlataforma`.
   */
  public static getModelName() {
    return "VisitaProdutoPlataforma";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of VisitaProdutoPlataforma for dynamic purposes.
  **/
  public static factory(data: VisitaProdutoPlataformaInterface): VisitaProdutoPlataforma{
    return new VisitaProdutoPlataforma(data);
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
      name: 'VisitaProdutoPlataforma',
      plural: 'VisitaProdutoPlataformas',
      path: 'VisitaProdutoPlataformas',
      idName: 'plataformaVendaId',
      properties: {
        "plataformaVendaId": {
          name: 'plataformaVendaId',
          type: 'number'
        },
        "produtoPlataformaId": {
          name: 'produtoPlataformaId',
          type: 'number'
        },
        "dataVisita": {
          name: 'dataVisita',
          type: 'Date'
        },
      },
      relations: {
      }
    }
  }
}
