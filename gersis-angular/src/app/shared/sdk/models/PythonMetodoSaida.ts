/* tslint:disable */
import {
  MetodoServer,
  ProcessoPython
} from '../index';

declare var Object: any;
export interface PythonMetodoSaidaInterface {
  "metodoServerId"?: number;
  "processoPythonId"?: number;
  metodoServer?: MetodoServer;
  processoPython?: ProcessoPython;
}

export class PythonMetodoSaida implements PythonMetodoSaidaInterface {
  "metodoServerId": number;
  "processoPythonId": number;
  metodoServer: MetodoServer;
  processoPython: ProcessoPython;
  constructor(data?: PythonMetodoSaidaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `PythonMetodoSaida`.
   */
  public static getModelName() {
    return "PythonMetodoSaida";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of PythonMetodoSaida for dynamic purposes.
  **/
  public static factory(data: PythonMetodoSaidaInterface): PythonMetodoSaida{
    return new PythonMetodoSaida(data);
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
      name: 'PythonMetodoSaida',
      plural: 'PythonMetodoSaidas',
      path: 'PythonMetodoSaidas',
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
