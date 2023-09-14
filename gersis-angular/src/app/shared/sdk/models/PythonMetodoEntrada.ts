/* tslint:disable */
import {
  MetodoServer,
  ProcessoPython
} from '../index';

declare var Object: any;
export interface PythonMetodoEntradaInterface {
  "metodoServerId"?: number;
  "processoPythonId"?: number;
  metodoServer?: MetodoServer;
  processoPython?: ProcessoPython;
}

export class PythonMetodoEntrada implements PythonMetodoEntradaInterface {
  "metodoServerId": number;
  "processoPythonId": number;
  metodoServer: MetodoServer;
  processoPython: ProcessoPython;
  constructor(data?: PythonMetodoEntradaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `PythonMetodoEntrada`.
   */
  public static getModelName() {
    return "PythonMetodoEntrada";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of PythonMetodoEntrada for dynamic purposes.
  **/
  public static factory(data: PythonMetodoEntradaInterface): PythonMetodoEntrada{
    return new PythonMetodoEntrada(data);
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
      name: 'PythonMetodoEntrada',
      plural: 'PythonMetodoEntradas',
      path: 'PythonMetodoEntradas',
      idName: 'metodoServerId',
      properties: {
        "metodoServerId": {
          name: 'metodoServerId',
          type: 'number'
        },
        "processoPythonId": {
          name: 'processoPythonId',
          type: 'number'
        },
      },
      relations: {
        metodoServer: {
          name: 'metodoServer',
          type: 'MetodoServer',
          model: 'MetodoServer',
          relationType: 'belongsTo',
                  keyFrom: 'metodoServerId',
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
