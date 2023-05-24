/* tslint:disable */
import {
  ParametroMetodoServer,
  PassoProcessoJava,
  Entidade,
  ProcessoMetodoRel
} from '../index';

declare var Object: any;
export interface MetodoServerInterface {
  "nome"?: string;
  "resposta"?: string;
  "tipoResposta"?: string;
  "tipoMetodo"?: string;
  "id"?: number;
  "entidadeId"?: number;
  parametroMetodoServers?: ParametroMetodoServer[];
  passoProcessoJavas?: PassoProcessoJava[];
  entidade?: Entidade;
  processoMetodoRels?: ProcessoMetodoRel[];
}

export class MetodoServer implements MetodoServerInterface {
  "nome": string;
  "resposta": string;
  "tipoResposta": string;
  "tipoMetodo": string;
  "id": number;
  "entidadeId": number;
  parametroMetodoServers: ParametroMetodoServer[];
  passoProcessoJavas: PassoProcessoJava[];
  entidade: Entidade;
  processoMetodoRels: ProcessoMetodoRel[];
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
        "resposta": {
          name: 'resposta',
          type: 'string'
        },
        "tipoResposta": {
          name: 'tipoResposta',
          type: 'string'
        },
        "tipoMetodo": {
          name: 'tipoMetodo',
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
        passoProcessoJavas: {
          name: 'passoProcessoJavas',
          type: 'PassoProcessoJava[]',
          model: 'PassoProcessoJava',
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
        processoMetodoRels: {
          name: 'processoMetodoRels',
          type: 'ProcessoMetodoRel[]',
          model: 'ProcessoMetodoRel',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'metodoServerId'
        },
      }
    }
  }
}
