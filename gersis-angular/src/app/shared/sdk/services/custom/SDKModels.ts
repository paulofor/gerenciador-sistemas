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
import { ProcessoEntidadeEntradaRel } from '../../models/ProcessoEntidadeEntradaRel';
import { ProcessoEntidadeSaidaRel } from '../../models/ProcessoEntidadeSaidaRel';
import { DadoProcesso } from '../../models/DadoProcesso';
import { DadoPassoProcessoEntradaRel } from '../../models/DadoPassoProcessoEntradaRel';
import { DadoPassoProcessoSaidaRel } from '../../models/DadoPassoProcessoSaidaRel';
import { ProcessoMetodoRel } from '../../models/ProcessoMetodoRel';
import { TelaFront } from '../../models/TelaFront';

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
    ProcessoEntidadeEntradaRel: ProcessoEntidadeEntradaRel,
    ProcessoEntidadeSaidaRel: ProcessoEntidadeSaidaRel,
    DadoProcesso: DadoProcesso,
    DadoPassoProcessoEntradaRel: DadoPassoProcessoEntradaRel,
    DadoPassoProcessoSaidaRel: DadoPassoProcessoSaidaRel,
    ProcessoMetodoRel: ProcessoMetodoRel,
    TelaFront: TelaFront,
    
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
