/* tslint:disable */
import {
  Sistema,
  PythonMetodoServer,
  PythonEntidadeEntradaRel,
  PythonEntidadeSaidaRel
} from '../index';

declare var Object: any;
export interface ProcessoPythonInterface {
  "nomeArquivo"?: string;
  "id"?: number;
  "sistemaId"?: number;
  sistema?: Sistema;
  pythonMetodoServers?: PythonMetodoServer[];
  pythonEntidadeEntrada?: PythonEntidadeEntradaRel[];
  pythonEntidadeSaida?: PythonEntidadeSaidaRel[];
}

export class ProcessoPython implements ProcessoPythonInterface {
  "nomeArquivo": string;
  "id": number;
  "sistemaId": number;
  sistema: Sistema;
  pythonMetodoServers: PythonMetodoServer[];
  pythonEntidadeEntrada: PythonEntidadeEntradaRel[];
  pythonEntidadeSaida: PythonEntidadeSaidaRel[];
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
        "id": {
          name: 'id',
          type: 'number'
        },
        "sistemaId": {
          name: 'sistemaId',
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
        pythonMetodoServers: {
          name: 'pythonMetodoServers',
          type: 'PythonMetodoServer[]',
          model: 'PythonMetodoServer',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'processoPythonId'
        },
        pythonEntidadeEntrada: {
          name: 'pythonEntidadeEntrada',
          type: 'PythonEntidadeEntradaRel[]',
          model: 'PythonEntidadeEntradaRel',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'processoPythonId'
        },
        pythonEntidadeSaida: {
          name: 'pythonEntidadeSaida',
          type: 'PythonEntidadeSaidaRel[]',
          model: 'PythonEntidadeSaidaRel',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'processoPythonId'
        },
      }
    }
  }
}
