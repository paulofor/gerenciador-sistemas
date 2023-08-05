/* tslint:disable */

declare var Object: any;
export interface TelaFrontInterface {
  "nome"?: string;
  "tipo"?: string;
  "id"?: number;
  "entidadeId"?: number;
}

export class TelaFront implements TelaFrontInterface {
  "nome": string;
  "tipo": string;
  "id": number;
  "entidadeId": number;
  constructor(data?: TelaFrontInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `TelaFront`.
   */
  public static getModelName() {
    return "TelaFront";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of TelaFront for dynamic purposes.
  **/
  public static factory(data: TelaFrontInterface): TelaFront{
    return new TelaFront(data);
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
      name: 'TelaFront',
      plural: 'TelaFronts',
      path: 'TelaFronts',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "tipo": {
          name: 'tipo',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "entidadeId": {
          name: 'entidadeId',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
