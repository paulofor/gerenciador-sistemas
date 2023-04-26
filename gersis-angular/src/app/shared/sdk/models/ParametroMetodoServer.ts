/* tslint:disable */
import {
  MetodoServer
} from '../index';

declare var Object: any;
export interface ParametroMetodoServerInterface {
  "nome"?: string;
  "tipo"?: string;
  "posicao"?: number;
  "id"?: number;
  "metodoServerId"?: number;
  metodoServer?: MetodoServer;
}

export class ParametroMetodoServer implements ParametroMetodoServerInterface {
  "nome": string;
  "tipo": string;
  "posicao": number;
  "id": number;
  "metodoServerId": number;
  metodoServer: MetodoServer;
  constructor(data?: ParametroMetodoServerInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ParametroMetodoServer`.
   */
  public static getModelName() {
    return "ParametroMetodoServer";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ParametroMetodoServer for dynamic purposes.
  **/
  public static factory(data: ParametroMetodoServerInterface): ParametroMetodoServer{
    return new ParametroMetodoServer(data);
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
      name: 'ParametroMetodoServer',
      plural: 'ParametroMetodoServers',
      path: 'ParametroMetodoServers',
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
        "posicao": {
          name: 'posicao',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "metodoServerId": {
          name: 'metodoServerId',
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
