/* tslint:disable */
import {
  Entidade
} from '../index';

declare var Object: any;
export interface RelacionamentoEntidadeInterface {
  "id"?: number;
  "entidade1Id"?: number;
  "entidadeNId"?: number;
  entidade1?: Entidade;
  entidadeN?: Entidade;
}

export class RelacionamentoEntidade implements RelacionamentoEntidadeInterface {
  "id": number;
  "entidade1Id": number;
  "entidadeNId": number;
  entidade1: Entidade;
  entidadeN: Entidade;
  constructor(data?: RelacionamentoEntidadeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `RelacionamentoEntidade`.
   */
  public static getModelName() {
    return "RelacionamentoEntidade";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of RelacionamentoEntidade for dynamic purposes.
  **/
  public static factory(data: RelacionamentoEntidadeInterface): RelacionamentoEntidade{
    return new RelacionamentoEntidade(data);
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
      name: 'RelacionamentoEntidade',
      plural: 'RelacionamentoEntidades',
      path: 'RelacionamentoEntidades',
      idName: 'id',
      properties: {
        "id": {
          name: 'id',
          type: 'number'
        },
        "entidade1Id": {
          name: 'entidade1Id',
          type: 'number'
        },
        "entidadeNId": {
          name: 'entidadeNId',
          type: 'number'
        },
      },
      relations: {
        entidade1: {
          name: 'entidade1',
          type: 'Entidade',
          model: 'Entidade',
          relationType: 'belongsTo',
                  keyFrom: 'entidade1Id',
          keyTo: 'id'
        },
        entidadeN: {
          name: 'entidadeN',
          type: 'Entidade',
          model: 'Entidade',
          relationType: 'belongsTo',
                  keyFrom: 'entidadeNId',
          keyTo: 'id'
        },
      }
    }
  }
}
