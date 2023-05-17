/* tslint:disable */
import {
  ProcessoJava,
  MetodoServer,
  DadoPassoProcessoEntradaRel,
  DadoPassoProcessoSaidaRel
} from '../index';

declare var Object: any;
export interface PassoProcessoJavaInterface {
  "nomeClasse"?: string;
  "pacoteClasse"?: string;
  "tipo"?: string;
  "ordenacao"?: number;
  "dentroLoop"?: number;
  "id"?: number;
  "processoJavaId"?: number;
  "metodoServerId"?: number;
  processoJava?: ProcessoJava;
  metodoServer?: MetodoServer;
  dadoPassoEntrada?: DadoPassoProcessoEntradaRel[];
  dadoPassoSaida?: DadoPassoProcessoSaidaRel[];
}

export class PassoProcessoJava implements PassoProcessoJavaInterface {
  "nomeClasse": string;
  "pacoteClasse": string;
  "tipo": string;
  "ordenacao": number;
  "dentroLoop": number;
  "id": number;
  "processoJavaId": number;
  "metodoServerId": number;
  processoJava: ProcessoJava;
  metodoServer: MetodoServer;
  dadoPassoEntrada: DadoPassoProcessoEntradaRel[];
  dadoPassoSaida: DadoPassoProcessoSaidaRel[];
  constructor(data?: PassoProcessoJavaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `PassoProcessoJava`.
   */
  public static getModelName() {
    return "PassoProcessoJava";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of PassoProcessoJava for dynamic purposes.
  **/
  public static factory(data: PassoProcessoJavaInterface): PassoProcessoJava{
    return new PassoProcessoJava(data);
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
      name: 'PassoProcessoJava',
      plural: 'PassoProcessoJavas',
      path: 'PassoProcessoJavas',
      idName: 'id',
      properties: {
        "nomeClasse": {
          name: 'nomeClasse',
          type: 'string'
        },
        "pacoteClasse": {
          name: 'pacoteClasse',
          type: 'string'
        },
        "tipo": {
          name: 'tipo',
          type: 'string'
        },
        "ordenacao": {
          name: 'ordenacao',
          type: 'number'
        },
        "dentroLoop": {
          name: 'dentroLoop',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "processoJavaId": {
          name: 'processoJavaId',
          type: 'number'
        },
        "metodoServerId": {
          name: 'metodoServerId',
          type: 'number'
        },
      },
      relations: {
        processoJava: {
          name: 'processoJava',
          type: 'ProcessoJava',
          model: 'ProcessoJava',
          relationType: 'belongsTo',
                  keyFrom: 'processoJavaId',
          keyTo: 'id'
        },
        metodoServer: {
          name: 'metodoServer',
          type: 'MetodoServer',
          model: 'MetodoServer',
          relationType: 'belongsTo',
                  keyFrom: 'metodoServerId',
          keyTo: 'id'
        },
        dadoPassoEntrada: {
          name: 'dadoPassoEntrada',
          type: 'DadoPassoProcessoEntradaRel[]',
          model: 'DadoPassoProcessoEntradaRel',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'passoProcessoJavaId'
        },
        dadoPassoSaida: {
          name: 'dadoPassoSaida',
          type: 'DadoPassoProcessoSaidaRel[]',
          model: 'DadoPassoProcessoSaidaRel',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'passoProcessoJavaId'
        },
      }
    }
  }
}
