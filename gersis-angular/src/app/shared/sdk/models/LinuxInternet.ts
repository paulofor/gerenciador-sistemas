/* tslint:disable */
import {
  ProcessoJava
} from '../index';

declare var Object: any;
export interface LinuxInternetInterface {
  "nome"?: string;
  "fornecedor"?: string;
  "id"?: number;
  processoJavas?: ProcessoJava[];
}

export class LinuxInternet implements LinuxInternetInterface {
  "nome": string;
  "fornecedor": string;
  "id": number;
  processoJavas: ProcessoJava[];
  constructor(data?: LinuxInternetInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `LinuxInternet`.
   */
  public static getModelName() {
    return "LinuxInternet";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of LinuxInternet for dynamic purposes.
  **/
  public static factory(data: LinuxInternetInterface): LinuxInternet{
    return new LinuxInternet(data);
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
      name: 'LinuxInternet',
      plural: 'LinuxInternets',
      path: 'LinuxInternets',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "fornecedor": {
          name: 'fornecedor',
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
          keyTo: 'linuxInternetId'
        },
      }
    }
  }
}
