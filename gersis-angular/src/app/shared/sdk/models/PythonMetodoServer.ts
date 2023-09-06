/* tslint:disable */
import {
  MetodoServer
} from '../index';

declare var Object: any;
export interface PythonMetodoServerInterface {
  "metodoServerId"?: number;
  "processoPythonId"?: number;
  metodoServer?: MetodoServer;
}

export class PythonMetodoServer implements PythonMetodoServerInterface {
  "metodoServerId": number;
  "processoPythonId": number;
  metodoServer: MetodoServer;
  constructor(data?: PythonMetodoServerInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `PythonMetodoServer`.
   */
  public static getModelName() {
    return "PythonMetodoServer";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of PythonMetodoServer for dynamic purposes.
  **/
  public static factory(data: PythonMetodoServerInterface): PythonMetodoServer{
    return new PythonMetodoServer(data);
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
      name: 'PythonMetodoServer',
      plural: 'PythonMetodoServers',
      path: 'PythonMetodoServers',
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
      }
    }
  }
}
