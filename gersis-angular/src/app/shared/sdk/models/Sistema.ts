/* tslint:disable */
import {
  ProcessoJava,
  Entidade
} from '../index';

declare var Object: any;
export interface SistemaInterface {
  "nome"?: string;
  "sigla"?: string;
  "nomeBancoDados"?: string;
  "pathProjeto"?: string;
  "urlBackApi"?: string;
  "id"?: number;
  processoJavas?: ProcessoJava[];
  entidades?: Entidade[];
}

export class Sistema implements SistemaInterface {
  "nome": string;
  "sigla": string;
  "nomeBancoDados": string;
  "pathProjeto": string;
  "urlBackApi": string;
  "id": number;
  processoJavas: ProcessoJava[];
  entidades: Entidade[];
  constructor(data?: SistemaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `Sistema`.
   */
  public static getModelName() {
    return "Sistema";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of Sistema for dynamic purposes.
  **/
  public static factory(data: SistemaInterface): Sistema{
    return new Sistema(data);
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
      name: 'Sistema',
      plural: 'Sistemas',
      path: 'Sistemas',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "sigla": {
          name: 'sigla',
          type: 'string'
        },
        "nomeBancoDados": {
          name: 'nomeBancoDados',
          type: 'string'
        },
        "pathProjeto": {
          name: 'pathProjeto',
          type: 'string'
        },
        "urlBackApi": {
          name: 'urlBackApi',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
        processoJavas: {
          name: 'processoJavas',
          type: 'ProcessoJava[]',
          model: 'ProcessoJava',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'sistemaId'
        },
        entidades: {
          name: 'entidades',
          type: 'Entidade[]',
          model: 'Entidade',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'sistemaId'
        },
      }
    }
  }
}
