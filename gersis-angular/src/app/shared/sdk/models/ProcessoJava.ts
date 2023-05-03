/* tslint:disable */
import {
  Sistema,
  PassoProcessoJava,
  LinuxInternet
} from '../index';

declare var Object: any;
export interface ProcessoJavaInterface {
  "nomeClasseMain"?: string;
  "pacoteClasseMain"?: string;
  "projeto"?: string;
  "jar"?: string;
  "crontab"?: string;
  "id"?: number;
  "sistemaId"?: number;
  "linuxInternetId"?: number;
  sistema?: Sistema;
  passoProcessoJavas?: PassoProcessoJava[];
  linuxInternet?: LinuxInternet;
}

export class ProcessoJava implements ProcessoJavaInterface {
  "nomeClasseMain": string;
  "pacoteClasseMain": string;
  "projeto": string;
  "jar": string;
  "crontab": string;
  "id": number;
  "sistemaId": number;
  "linuxInternetId": number;
  sistema: Sistema;
  passoProcessoJavas: PassoProcessoJava[];
  linuxInternet: LinuxInternet;
  constructor(data?: ProcessoJavaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ProcessoJava`.
   */
  public static getModelName() {
    return "ProcessoJava";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ProcessoJava for dynamic purposes.
  **/
  public static factory(data: ProcessoJavaInterface): ProcessoJava{
    return new ProcessoJava(data);
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
      name: 'ProcessoJava',
      plural: 'ProcessoJavas',
      path: 'ProcessoJavas',
      idName: 'id',
      properties: {
        "nomeClasseMain": {
          name: 'nomeClasseMain',
          type: 'string'
        },
        "pacoteClasseMain": {
          name: 'pacoteClasseMain',
          type: 'string'
        },
        "projeto": {
          name: 'projeto',
          type: 'string'
        },
        "jar": {
          name: 'jar',
          type: 'string'
        },
        "crontab": {
          name: 'crontab',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "sistemaId": {
          name: 'sistemaId',
          type: 'number'
        },
        "linuxInternetId": {
          name: 'linuxInternetId',
          type: 'number'
        },
      },
      relations: {
        sistema: {
          name: 'sistema',
          type: 'Sistema',
          model: 'Sistema',
          relationType: 'belongsTo',
                  keyFrom: 'sistemaId',
          keyTo: 'id'
        },
        passoProcessoJavas: {
          name: 'passoProcessoJavas',
          type: 'PassoProcessoJava[]',
          model: 'PassoProcessoJava',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'processoJavaId'
        },
        linuxInternet: {
          name: 'linuxInternet',
          type: 'LinuxInternet',
          model: 'LinuxInternet',
          relationType: 'belongsTo',
                  keyFrom: 'linuxInternetId',
          keyTo: 'id'
        },
      }
    }
  }
}
