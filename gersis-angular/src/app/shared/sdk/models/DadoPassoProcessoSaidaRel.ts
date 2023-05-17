/* tslint:disable */
import {
  PassoProcessoJava,
  DadoProcesso
} from '../index';

declare var Object: any;
export interface DadoPassoProcessoSaidaRelInterface {
  "passoProcessoJavaId"?: number;
  "dadoProcessoId"?: number;
  passoProcessoJava?: PassoProcessoJava;
  dadoProcesso?: DadoProcesso;
}

export class DadoPassoProcessoSaidaRel implements DadoPassoProcessoSaidaRelInterface {
  "passoProcessoJavaId": number;
  "dadoProcessoId": number;
  passoProcessoJava: PassoProcessoJava;
  dadoProcesso: DadoProcesso;
  constructor(data?: DadoPassoProcessoSaidaRelInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `DadoPassoProcessoSaidaRel`.
   */
  public static getModelName() {
    return "DadoPassoProcessoSaidaRel";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of DadoPassoProcessoSaidaRel for dynamic purposes.
  **/
  public static factory(data: DadoPassoProcessoSaidaRelInterface): DadoPassoProcessoSaidaRel{
    return new DadoPassoProcessoSaidaRel(data);
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
      name: 'DadoPassoProcessoSaidaRel',
      plural: 'DadoPassoProcessoSaidaRels',
      path: 'DadoPassoProcessoSaidaRels',
      idName: 'passoProcessoJavaId',
      properties: {
        "passoProcessoJavaId": {
          name: 'passoProcessoJavaId',
          type: 'number'
        },
        "dadoProcessoId": {
          name: 'dadoProcessoId',
          type: 'number'
        },
      },
      relations: {
        passoProcessoJava: {
          name: 'passoProcessoJava',
          type: 'PassoProcessoJava',
          model: 'PassoProcessoJava',
          relationType: 'belongsTo',
                  keyFrom: 'passoProcessoJavaId',
          keyTo: 'id'
        },
        dadoProcesso: {
          name: 'dadoProcesso',
          type: 'DadoProcesso',
          model: 'DadoProcesso',
          relationType: 'belongsTo',
                  keyFrom: 'dadoProcessoId',
          keyTo: 'id'
        },
      }
    }
  }
}
