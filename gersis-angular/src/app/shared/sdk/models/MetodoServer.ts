/* tslint:disable */
import {
  ParametroMetodoServer,
  Entidade
} from '../index';

declare var Object: any;
export interface MetodoServerInterface {
  "nome"?: string;
  "id"?: number;
  "entidadeId"?: number;
  parametroMetodoServers?: ParametroMetodoServer[];
  entidade?: Entidade;
}

export class MetodoServer implements MetodoServerInterface {
  "nome": string;
  "id": number;
  "entidadeId": number;
  parametroMetodoServers: ParametroMetodoServer[];
  entidade: Entidade;
  constructor(data?: MetodoServerInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `MetodoServer`.
   */
  public static getModelName() {
    return "MetodoServer";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of MetodoServer for dynamic purposes.
  **/
  public static factory(data: MetodoServerInterface): MetodoServer{
    return new MetodoServer(data);
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
      name: 'MetodoServer',
      plural: 'MetodoServers',
      path: 'MetodoServers',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "entidadeId": {
          name: 'entidadeId',
          type: 'number'
        },
      },
      relations: {
        parametroMetodoServers: {
          name: 'parametroMetodoServers',
          type: 'ParametroMetodoServer[]',
          model: 'ParametroMetodoServer',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'metodoServerId'
        },
        entidade: {
          name: 'entidade',
          type: 'Entidade',
          model: 'Entidade',
          relationType: 'belongsTo',
                  keyFrom: 'entidadeId',
          keyTo: 'id'
        },
      }
    }
  }
}
