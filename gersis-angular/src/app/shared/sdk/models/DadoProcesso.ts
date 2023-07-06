/* tslint:disable */
import {
  Entidade,
  DadoPassoProcessoEntradaRel,
  DadoPassoProcessoSaidaRel
} from '../index';

declare var Object: any;
export interface DadoProcessoInterface {
  "nome"?: string;
  "tipoSimples"?: string;
  "tipoEntidadeLista"?: number;
  "tipoEntidadeId"?: number;
  "processoJavaId"?: number;
  "id"?: number;
  tipoEntidade?: Entidade;
  passoProcessoJavaComoEntrada?: DadoPassoProcessoEntradaRel[];
  passoProcessoJavaComoSaida?: DadoPassoProcessoSaidaRel[];
}

export class DadoProcesso implements DadoProcessoInterface {
  "nome": string;
  "tipoSimples": string;
  "tipoEntidadeLista": number;
  "tipoEntidadeId": number;
  "processoJavaId": number;
  "id": number;
  tipoEntidade: Entidade;
  passoProcessoJavaComoEntrada: DadoPassoProcessoEntradaRel[];
  passoProcessoJavaComoSaida: DadoPassoProcessoSaidaRel[];
  constructor(data?: DadoProcessoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `DadoProcesso`.
   */
  public static getModelName() {
    return "DadoProcesso";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of DadoProcesso for dynamic purposes.
  **/
  public static factory(data: DadoProcessoInterface): DadoProcesso{
    return new DadoProcesso(data);
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
      name: 'DadoProcesso',
      plural: 'DadoProcessos',
      path: 'DadoProcessos',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "tipoSimples": {
          name: 'tipoSimples',
          type: 'string'
        },
        "tipoEntidadeLista": {
          name: 'tipoEntidadeLista',
          type: 'number'
        },
        "tipoEntidadeId": {
          name: 'tipoEntidadeId',
          type: 'number'
        },
        "processoJavaId": {
          name: 'processoJavaId',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
        tipoEntidade: {
          name: 'tipoEntidade',
          type: 'Entidade',
          model: 'Entidade',
          relationType: 'belongsTo',
                  keyFrom: 'tipoEntidadeId',
          keyTo: 'id'
        },
        passoProcessoJavaComoEntrada: {
          name: 'passoProcessoJavaComoEntrada',
          type: 'DadoPassoProcessoEntradaRel[]',
          model: 'DadoPassoProcessoEntradaRel',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'dadoProcessoId'
        },
        passoProcessoJavaComoSaida: {
          name: 'passoProcessoJavaComoSaida',
          type: 'DadoPassoProcessoSaidaRel[]',
          model: 'DadoPassoProcessoSaidaRel',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'dadoProcessoId'
        },
      }
    }
  }
}
