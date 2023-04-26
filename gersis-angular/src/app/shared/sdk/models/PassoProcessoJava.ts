/* tslint:disable */
import {
  ProcessoJava
} from '../index';

declare var Object: any;
export interface PassoProcessoJavaInterface {
  "nome"?: string;
  "tipo"?: string;
  "ordenacao"?: string;
  "id"?: number;
  "processoJavaId"?: number;
  processoJava?: ProcessoJava;
}

export class PassoProcessoJava implements PassoProcessoJavaInterface {
  "nome": string;
  "tipo": string;
  "ordenacao": string;
  "id": number;
  "processoJavaId": number;
  processoJava: ProcessoJava;
  constructor(data?: PassoProcessoJavaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `PassoProcessoJava`.
   */
  public static getModelName() {
    return "PassoProcessoJava";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of PassoProcessoJava for dynamic purposes.
  **/
  public static factory(data: PassoProcessoJavaInterface): PassoProcessoJava{
    return new PassoProcessoJava(data);
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
      name: 'PassoProcessoJava',
      plural: 'PassoProcessoJavas',
      path: 'PassoProcessoJavas',
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
        "ordenacao": {
          name: 'ordenacao',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "processoJavaId": {
          name: 'processoJavaId',
          type: 'number'
        },
      },
      relations: {
        processoJava: {
          name: 'processoJava',
          type: 'ProcessoJava',
          model: 'ProcessoJava',
          relationType: 'belongsTo',
                  keyFrom: 'processoJavaId',
          keyTo: 'id'
        },
      }
    }
  }
}
