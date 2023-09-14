/* tslint:disable */
import {
  Sistema
} from '../index';

declare var Object: any;
export interface AtividadeSistemaInterface {
  "nome"?: string;
  "descricao"?: string;
  "melhoria"?: string;
  "ocorrencia"?: string;
  "id"?: number;
  "sistemaId"?: number;
  sistema?: Sistema;
}

export class AtividadeSistema implements AtividadeSistemaInterface {
  "nome": string;
  "descricao": string;
  "melhoria": string;
  "ocorrencia": string;
  "id": number;
  "sistemaId": number;
  sistema: Sistema;
  constructor(data?: AtividadeSistemaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `AtividadeSistema`.
   */
  public static getModelName() {
    return "AtividadeSistema";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of AtividadeSistema for dynamic purposes.
  **/
  public static factory(data: AtividadeSistemaInterface): AtividadeSistema{
    return new AtividadeSistema(data);
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
      name: 'AtividadeSistema',
      plural: 'AtividadeSistemas',
      path: 'AtividadeSistemas',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "descricao": {
          name: 'descricao',
          type: 'string'
        },
        "melhoria": {
          name: 'melhoria',
          type: 'string'
        },
        "ocorrencia": {
          name: 'ocorrencia',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "sistemaId": {
          name: 'sistemaId',
          type: 'number'
        },
      },
      relations: {
        sistema: {
          name: 'sistema',
          type: 'Sistema',
          model: 'Sistema',
          relationType: 'belongsTo',
                  keyFrom: 'sistemaId',
          keyTo: 'id'
        },
      }
    }
  }
}
