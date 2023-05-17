/* tslint:disable */
import {
  Entidade,
  ProcessoJava
} from '../index';

declare var Object: any;
export interface ProcessoEntidadeSaidaRelInterface {
  "entidadeId"?: number;
  "processoJavaId"?: number;
  entidade?: Entidade;
  processoJava?: ProcessoJava;
}

export class ProcessoEntidadeSaidaRel implements ProcessoEntidadeSaidaRelInterface {
  "entidadeId": number;
  "processoJavaId": number;
  entidade: Entidade;
  processoJava: ProcessoJava;
  constructor(data?: ProcessoEntidadeSaidaRelInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ProcessoEntidadeSaidaRel`.
   */
  public static getModelName() {
    return "ProcessoEntidadeSaidaRel";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ProcessoEntidadeSaidaRel for dynamic purposes.
  **/
  public static factory(data: ProcessoEntidadeSaidaRelInterface): ProcessoEntidadeSaidaRel{
    return new ProcessoEntidadeSaidaRel(data);
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
      name: 'ProcessoEntidadeSaidaRel',
      plural: 'ProcessoEntidadeSaidaRels',
      path: 'ProcessoEntidadeSaidaRels',
      idName: 'entidadeId',
      properties: {
        "entidadeId": {
          name: 'entidadeId',
          type: 'number'
        },
        "processoJavaId": {
          name: 'processoJavaId',
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
