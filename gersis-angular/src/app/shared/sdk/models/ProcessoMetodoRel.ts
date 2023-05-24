/* tslint:disable */
import {
  MetodoServer,
  ProcessoJava
} from '../index';

declare var Object: any;
export interface ProcessoMetodoRelInterface {
  "metodoServerId"?: number;
  "processoJavaId"?: number;
  metodoServer?: MetodoServer;
  processoJava?: ProcessoJava;
}

export class ProcessoMetodoRel implements ProcessoMetodoRelInterface {
  "metodoServerId": number;
  "processoJavaId": number;
  metodoServer: MetodoServer;
  processoJava: ProcessoJava;
  constructor(data?: ProcessoMetodoRelInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ProcessoMetodoRel`.
   */
  public static getModelName() {
    return "ProcessoMetodoRel";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ProcessoMetodoRel for dynamic purposes.
  **/
  public static factory(data: ProcessoMetodoRelInterface): ProcessoMetodoRel{
    return new ProcessoMetodoRel(data);
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
      name: 'ProcessoMetodoRel',
      plural: 'ProcessoMetodoRels',
      path: 'ProcessoMetodoRels',
      idName: 'metodoServerId',
      properties: {
        "metodoServerId": {
          name: 'metodoServerId',
          type: 'number'
        },
        "processoJavaId": {
          name: 'processoJavaId',
          type: 'number'
        },
      },
      relations: {
        metodoServer: {
          name: 'metodoServer',
          type: 'MetodoServer',
          model: 'MetodoServer',
          relationType: 'belongsTo',
                  keyFrom: 'metodoServerId',
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
      }
    }
  }
}
