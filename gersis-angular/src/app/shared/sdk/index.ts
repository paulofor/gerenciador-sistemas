/* tslint:disable */
/**
* @module SDKModule
* @author Jonathan Casarrubias <t:@johncasarrubias> <gh:jonathan-casarrubias>
* @license MIT 2016 Jonathan Casarrubias
* @version 2.1.0
* @description
* The SDKModule is a generated Software Development Kit automatically built by
* the LoopBack SDK Builder open source module.
*
* The SDKModule provides Angular 2 >= RC.5 support, which means that NgModules
* can import this Software Development Kit as follows:
*
*
* APP Route Module Context
* ============================================================================
* import { NgModule }       from '@angular/core';
* import { BrowserModule }  from '@angular/platform-browser';
* // App Root 
* import { AppComponent }   from './app.component';
* // Feature Modules
* import { SDK[Browser|Node|Native]Module } from './shared/sdk/sdk.module';
* // Import Routing
* import { routing }        from './app.routing';
* @NgModule({
*  imports: [
*    BrowserModule,
*    routing,
*    SDK[Browser|Node|Native]Module.forRoot()
*  ],
*  declarations: [ AppComponent ],
*  bootstrap:    [ AppComponent ]
* })
* export class AppModule { }
*
**/
import { ErrorHandler } from './services/core/error.service';
import { LoopBackAuth } from './services/core/auth.service';
import { LoggerService } from './services/custom/logger.service';
import { SDKModels } from './services/custom/SDKModels';
import { InternalStorage, SDKStorage } from './storage/storage.swaps';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { NgModule, ModuleWithProviders } from '@angular/core';
import { CookieBrowser } from './storage/cookie.browser';
import { StorageBrowser } from './storage/storage.browser';
import { SocketBrowser } from './sockets/socket.browser';

import { SocketConnection } from './sockets/socket.connections';
import { RealTime } from './services/core/real.time';
import { UserApi } from './services/custom/User';
import { SistemaApi } from './services/custom/Sistema';
import { AtributoEntidadeApi } from './services/custom/AtributoEntidade';
import { MetodoServerApi } from './services/custom/MetodoServer';
import { ParametroMetodoServerApi } from './services/custom/ParametroMetodoServer';
import { ProcessoJavaApi } from './services/custom/ProcessoJava';
import { PassoProcessoJavaApi } from './services/custom/PassoProcessoJava';
import { LinuxInternetApi } from './services/custom/LinuxInternet';
import { EntidadeApi } from './services/custom/Entidade';
import { RelacionamentoEntidadeApi } from './services/custom/RelacionamentoEntidade';
import { ProcessoEntidadeEntradaRelApi } from './services/custom/ProcessoEntidadeEntradaRel';
import { ProcessoEntidadeSaidaRelApi } from './services/custom/ProcessoEntidadeSaidaRel';
import { DadoProcessoApi } from './services/custom/DadoProcesso';
import { DadoPassoProcessoEntradaRelApi } from './services/custom/DadoPassoProcessoEntradaRel';
import { DadoPassoProcessoSaidaRelApi } from './services/custom/DadoPassoProcessoSaidaRel';
import { ProcessoMetodoRelApi } from './services/custom/ProcessoMetodoRel';
import { TelaFrontApi } from './services/custom/TelaFront';
import { ProcessoPythonApi } from './services/custom/ProcessoPython';
import { AtividadeSistemaApi } from './services/custom/AtividadeSistema';
import { PythonMetodoEntradaApi } from './services/custom/PythonMetodoEntrada';
import { PythonMetodoSaidaApi } from './services/custom/PythonMetodoSaida';
/**
* @module SDKBrowserModule
* @description
* This module should be imported when building a Web Application in the following scenarios:
*
*  1.- Regular web application
*  2.- Angular universal application (Browser Portion)
*  3.- Progressive applications (Angular Mobile, Ionic, WebViews, etc)
**/
@NgModule({
  imports:      [ CommonModule, HttpClientModule ],
  declarations: [ ],
  exports:      [ ],
  providers:    [
    ErrorHandler,
    SocketConnection
  ]
})
export class SDKBrowserModule {
  static forRoot(internalStorageProvider: any = {
    provide: InternalStorage,
    useClass: CookieBrowser
  }): ModuleWithProviders {
    return {
      ngModule  : SDKBrowserModule,
      providers : [
        LoopBackAuth,
        LoggerService,
        SDKModels,
        RealTime,
        UserApi,
        SistemaApi,
        AtributoEntidadeApi,
        MetodoServerApi,
        ParametroMetodoServerApi,
        ProcessoJavaApi,
        PassoProcessoJavaApi,
        LinuxInternetApi,
        EntidadeApi,
        RelacionamentoEntidadeApi,
        ProcessoEntidadeEntradaRelApi,
        ProcessoEntidadeSaidaRelApi,
        DadoProcessoApi,
        DadoPassoProcessoEntradaRelApi,
        DadoPassoProcessoSaidaRelApi,
        ProcessoMetodoRelApi,
        TelaFrontApi,
        ProcessoPythonApi,
        AtividadeSistemaApi,
        PythonMetodoEntradaApi,
        PythonMetodoSaidaApi,
        internalStorageProvider,
        { provide: SDKStorage, useClass: StorageBrowser }
      ]
    };
  }
}
/**
* Have Fun!!!
* - Jon
**/
export * from './models/index';
export * from './services/index';
export * from './lb.config';
export * from './storage/storage.swaps';
export { CookieBrowser } from './storage/cookie.browser';
export { StorageBrowser } from './storage/storage.browser';

