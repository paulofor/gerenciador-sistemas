/* tslint:disable */
import {
  Entidade,
  ProcessoPython
} from '../index';

declare var Object: any;
export interface PythonEntidadeSaidaRelInterface {
  "entidadeId"?: number;
  "processoPythonId"?: number;
  entidade?: Entidade;
  processoPython?: ProcessoPython;
}

export class PythonEntidadeSaidaRel implements PythonEntidadeSaidaRelInterface {
  "entidadeId": number;
  "processoPythonId": number;
  entidade: Entidade;
  processoPython: ProcessoPython;
  constructor(data?: PythonEntidadeSaidaRelInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `PythonEntidadeSaidaRel`.
   */
  public static getModelName() {
    return "PythonEntidadeSaidaRel";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of PythonEntidadeSaidaRel for dynamic purposes.
  **/
  public static factory(data: PythonEntidadeSaidaRelInterface): PythonEntidadeSaidaRel{
    return new PythonEntidadeSaidaRel(data);
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
      name: 'PythonEntidadeSaidaRel',
      plural: 'PythonEntidadeSaidaRels',
      path: 'PythonEntidadeSaidaRels',
      idName: 'entidadeId',
      properties: {
        "entidadeId": {
          name: 'entidadeId',
          type: 'number'
        },
        "processoPythonId": {
          name: 'processoPythonId',
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
        processoPython: {
          name: 'processoPython',
          type: 'ProcessoPython',
          model: 'ProcessoPython',
          relationType: 'belongsTo',
                  keyFrom: 'processoPythonId',
          keyTo: 'id'
        },
      }
    }
  }
}
