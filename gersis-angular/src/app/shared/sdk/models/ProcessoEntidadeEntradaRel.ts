/* tslint:disable */
import {
  Entidade,
  ProcessoJava
} from '../index';

declare var Object: any;
export interface ProcessoEntidadeEntradaRelInterface {
  "entidadeId"?: number;
  "processoJavaId"?: number;
  entidade?: Entidade;
  processoJava?: ProcessoJava;
}

export class ProcessoEntidadeEntradaRel implements ProcessoEntidadeEntradaRelInterface {
  "entidadeId": number;
  "processoJavaId": number;
  entidade: Entidade;
  processoJava: ProcessoJava;
  constructor(data?: ProcessoEntidadeEntradaRelInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ProcessoEntidadeEntradaRel`.
   */
  public static getModelName() {
    return "ProcessoEntidadeEntradaRel";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ProcessoEntidadeEntradaRel for dynamic purposes.
  **/
  public static factory(data: ProcessoEntidadeEntradaRelInterface): ProcessoEntidadeEntradaRel{
    return new ProcessoEntidadeEntradaRel(data);
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
      name: 'ProcessoEntidadeEntradaRel',
      plural: 'ProcessoEntidadeEntradaRels',
      path: 'ProcessoEntidadeEntradaRels',
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
