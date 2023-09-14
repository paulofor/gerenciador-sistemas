/* tslint:disable */
import {
  Sistema,
  ProcessoJava,
  PythonMetodoEntrada,
  PythonMetodoSaida
} from '../index';

declare var Object: any;
export interface ProcessoPythonInterface {
  "nomeArquivo"?: string;
  "tipoExecucao"?: string;
  "cron"?: string;
  "id"?: number;
  "sistemaId"?: number;
  "processoJavaId"?: number;
  sistema?: Sistema;
  processoJava?: ProcessoJava;
  pythonMetodoEntrada?: PythonMetodoEntrada[];
  pythonMetodoSaida?: PythonMetodoSaida[];
}

export class ProcessoPython implements ProcessoPythonInterface {
  "nomeArquivo": string;
  "tipoExecucao": string;
  "cron": string;
  "id": number;
  "sistemaId": number;
  "processoJavaId": number;
  sistema: Sistema;
  processoJava: ProcessoJava;
  pythonMetodoEntrada: PythonMetodoEntrada[];
  pythonMetodoSaida: PythonMetodoSaida[];
  constructor(data?: ProcessoPythonInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ProcessoPython`.
   */
  public static getModelName() {
    return "ProcessoPython";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ProcessoPython for dynamic purposes.
  **/
  public static factory(data: ProcessoPythonInterface): ProcessoPython{
    return new ProcessoPython(data);
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
      name: 'ProcessoPython',
      plural: 'ProcessoPythons',
      path: 'ProcessoPythons',
      idName: 'id',
      properties: {
        "nomeArquivo": {
          name: 'nomeArquivo',
          type: 'string'
        },
        "tipoExecucao": {
          name: 'tipoExecucao',
          type: 'string'
        },
        "cron": {
          name: 'cron',
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
        "processoJavaId": {
          name: 'processoJavaId',
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
        processoJava: {
          name: 'processoJava',
          type: 'ProcessoJava',
          model: 'ProcessoJava',
          relationType: 'belongsTo',
                  keyFrom: 'processoJavaId',
          keyTo: 'id'
        },
        pythonMetodoEntrada: {
          name: 'pythonMetodoEntrada',
          type: 'PythonMetodoEntrada[]',
          model: 'PythonMetodoEntrada',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'processoPythonId'
        },
        pythonMetodoSaida: {
          name: 'pythonMetodoSaida',
          type: 'PythonMetodoSaida[]',
          model: 'PythonMetodoSaida',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'processoPythonId'
        },
      }
    }
  }
}
