/* tslint:disable */
import { Injectable } from '@angular/core';
import { User } from '../../models/User';
import { Sistema } from '../../models/Sistema';
import { AtributoEntidade } from '../../models/AtributoEntidade';
import { MetodoServer } from '../../models/MetodoServer';
import { ParametroMetodoServer } from '../../models/ParametroMetodoServer';
import { ProcessoJava } from '../../models/ProcessoJava';
import { PassoProcessoJava } from '../../models/PassoProcessoJava';
import { LinuxInternet } from '../../models/LinuxInternet';
import { Entidade } from '../../models/Entidade';
import { RelacionamentoEntidade } from '../../models/RelacionamentoEntidade';

export interface Models { [name: string]: any }

@Injectable()
export class SDKModels {

  private models: Models = {
    User: User,
    Sistema: Sistema,
    AtributoEntidade: AtributoEntidade,
    MetodoServer: MetodoServer,
    ParametroMetodoServer: ParametroMetodoServer,
    ProcessoJava: ProcessoJava,
    PassoProcessoJava: PassoProcessoJava,
    LinuxInternet: LinuxInternet,
    Entidade: Entidade,
    RelacionamentoEntidade: RelacionamentoEntidade,
    
  };

  public get(modelName: string): any {
    return this.models[modelName];
  }

  public getAll(): Models {
    return this.models;
  }

  public getModelNames(): string[] {
    return Object.keys(this.models);
  }
}
