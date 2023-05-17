/* tslint:disable */
import {
  PassoProcessoJava,
  DadoProcesso
} from '../index';

declare var Object: any;
export interface DadoPassoProcessoEntradaRelInterface {
  "passoProcessoJavaId"?: number;
  "dadoProcessoId"?: number;
  passoProcessoJava?: PassoProcessoJava;
  dadoProcesso?: DadoProcesso;
}

export class DadoPassoProcessoEntradaRel implements DadoPassoProcessoEntradaRelInterface {
  "passoProcessoJavaId": number;
  "dadoProcessoId": number;
  passoProcessoJava: PassoProcessoJava;
  dadoProcesso: DadoProcesso;
  constructor(data?: DadoPassoProcessoEntradaRelInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `DadoPassoProcessoEntradaRel`.
   */
  public static getModelName() {
    return "DadoPassoProcessoEntradaRel";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of DadoPassoProcessoEntradaRel for dynamic purposes.
  **/
  public static factory(data: DadoPassoProcessoEntradaRelInterface): DadoPassoProcessoEntradaRel{
    return new DadoPassoProcessoEntradaRel(data);
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
      name: 'DadoPassoProcessoEntradaRel',
      plural: 'DadoPassoProcessoEntradaRels',
      path: 'DadoPassoProcessoEntradaRels',
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
