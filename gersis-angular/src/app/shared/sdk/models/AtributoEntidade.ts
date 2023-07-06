/* tslint:disable */
import {
  Entidade
} from '../index';

declare var Object: any;
export interface AtributoEntidadeInterface {
  "nome"?: string;
  "tipoBd"?: string;
  "chave"?: number;
  "id"?: number;
  "entidadeId"?: number;
  entidade?: Entidade;
}

export class AtributoEntidade implements AtributoEntidadeInterface {
  "nome": string;
  "tipoBd": string;
  "chave": number;
  "id": number;
  "entidadeId": number;
  entidade: Entidade;
  constructor(data?: AtributoEntidadeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `AtributoEntidade`.
   */
  public static getModelName() {
    return "AtributoEntidade";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of AtributoEntidade for dynamic purposes.
  **/
  public static factory(data: AtributoEntidadeInterface): AtributoEntidade{
    return new AtributoEntidade(data);
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
      name: 'AtributoEntidade',
      plural: 'AtributoEntidades',
      path: 'AtributoEntidades',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "tipoBd": {
          name: 'tipoBd',
          type: 'string'
        },
        "chave": {
          name: 'chave',
          type: 'number'
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
        entidade: {
          name: 'entidade',
          type: 'Entidade',
          model: 'Entidade',
          relationType: 'belongsTo',
                  keyFrom: 'entidadeId',
          keyTo: 'id'
        },
      }
    }
  }
}
