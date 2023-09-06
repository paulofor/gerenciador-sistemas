/* tslint:disable */
import {
  Sistema,
  AtributoEntidade,
  MetodoServer,
  RelacionamentoEntidade,
  ProcessoEntidadeEntradaRel,
  ProcessoEntidadeSaidaRel,
  TelaFront,
  PythonEntidadeEntradaRel,
  PythonEntidadeSaidaRel
} from '../index';

declare var Object: any;
export interface EntidadeInterface {
  "nome"?: string;
  "usado"?: number;
  "id"?: number;
  "sistemaId"?: number;
  sistema?: Sistema;
  atributoEntidades?: AtributoEntidade[];
  metodoServers?: MetodoServer[];
  relacionamentos1?: RelacionamentoEntidade[];
  relacionamentosN?: RelacionamentoEntidade[];
  processoJavaComoEntrada?: ProcessoEntidadeEntradaRel[];
  processoJavaComoSaida?: ProcessoEntidadeSaidaRel[];
  telaFronts?: TelaFront[];
  processoPythonComoEntrada?: PythonEntidadeEntradaRel[];
  processoPythonComoSaida?: PythonEntidadeSaidaRel[];
}

export class Entidade implements EntidadeInterface {
  "nome": string;
  "usado": number;
  "id": number;
  "sistemaId": number;
  sistema: Sistema;
  atributoEntidades: AtributoEntidade[];
  metodoServers: MetodoServer[];
  relacionamentos1: RelacionamentoEntidade[];
  relacionamentosN: RelacionamentoEntidade[];
  processoJavaComoEntrada: ProcessoEntidadeEntradaRel[];
  processoJavaComoSaida: ProcessoEntidadeSaidaRel[];
  telaFronts: TelaFront[];
  processoPythonComoEntrada: PythonEntidadeEntradaRel[];
  processoPythonComoSaida: PythonEntidadeSaidaRel[];
  constructor(data?: EntidadeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `Entidade`.
   */
  public static getModelName() {
    return "Entidade";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of Entidade for dynamic purposes.
  **/
  public static factory(data: EntidadeInterface): Entidade{
    return new Entidade(data);
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
      name: 'Entidade',
      plural: 'Entidades',
      path: 'Entidades',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "usado": {
          name: 'usado',
          type: 'number'
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
        atributoEntidades: {
          name: 'atributoEntidades',
          type: 'AtributoEntidade[]',
          model: 'AtributoEntidade',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'entidadeId'
        },
        metodoServers: {
          name: 'metodoServers',
          type: 'MetodoServer[]',
          model: 'MetodoServer',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'entidadeId'
        },
        relacionamentos1: {
          name: 'relacionamentos1',
          type: 'RelacionamentoEntidade[]',
          model: 'RelacionamentoEntidade',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'entidadeNId'
        },
        relacionamentosN: {
          name: 'relacionamentosN',
          type: 'RelacionamentoEntidade[]',
          model: 'RelacionamentoEntidade',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'entidade1Id'
        },
        processoJavaComoEntrada: {
          name: 'processoJavaComoEntrada',
          type: 'ProcessoEntidadeEntradaRel[]',
          model: 'ProcessoEntidadeEntradaRel',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'entidadeId'
        },
        processoJavaComoSaida: {
          name: 'processoJavaComoSaida',
          type: 'ProcessoEntidadeSaidaRel[]',
          model: 'ProcessoEntidadeSaidaRel',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'entidadeId'
        },
        telaFronts: {
          name: 'telaFronts',
          type: 'TelaFront[]',
          model: 'TelaFront',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'entidadeId'
        },
        processoPythonComoEntrada: {
          name: 'processoPythonComoEntrada',
          type: 'PythonEntidadeEntradaRel[]',
          model: 'PythonEntidadeEntradaRel',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'entidadeId'
        },
        processoPythonComoSaida: {
          name: 'processoPythonComoSaida',
          type: 'PythonEntidadeSaidaRel[]',
          model: 'PythonEntidadeSaidaRel',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'entidadeId'
        },
      }
    }
  }
}
