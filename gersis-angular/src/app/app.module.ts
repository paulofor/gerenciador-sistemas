import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';

import { AppComponent } from './app.component';
import { SidebarComponent } from './sidebar/sidebar.component';

import { AppRoutingModule } from './app-routing/app-routing.module';
import { HomeComponent } from './home/home.component';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { SocketConnection } from './shared/sdk/sockets/socket.connections';
import { SocketDriver } from './shared/sdk/sockets/socket.driver';


import { registerLocaleData } from '@angular/common';
import localePt from '@angular/common/locales/pt';
import { SDKBrowserModule, SDKModels, LoopBackAuth, InternalStorage } from './shared/sdk';

import {MatDialogModule} from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatListModule} from '@angular/material/list';
import {MatTabsModule} from '@angular/material/tabs';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatTableModule} from '@angular/material/table';
import { MatFormFieldModule, MatInputModule, MatButtonModule, MatAutocompleteModule, MatCheckbox, MatCheckboxModule, MatDatepickerModule, MatNativeDateModule } from '@angular/material';
import { FormsModule } from '@angular/forms';
//import { MatMomentDateModule } from "@angular/material-moment-adapter";
//import { NgxImgModule } from 'ngx-img';
import { FileDropModule } from 'ngx-file-drop';
//import { UploadModule } from './upload/upload.module';
import { ImageUploadModule } from "angular2-image-upload";
import { ReactiveFormsModule } from '@angular/forms';
import { NgDragDropModule } from 'ng-drag-drop';
import { NgApexchartsModule } from 'ng-apexcharts';
import { SistemaListComponent } from './sistema-list/sistema-list.component';
import { SistemaEditComponent } from './sistema-edit/sistema-edit.component';
import { EntidadeListComponent } from './entidade-list/entidade-list.component';
import { EntidadeEditComponent } from './entidade-edit/entidade-edit.component';
import { EntidadeDetalheComponent } from './entidade-detalhe/entidade-detalhe.component';
import { LinuxInternetListComponent } from './linux-internet-list/linux-internet-list.component';
import { LinuxInternetEditComponent } from './linux-internet-edit/linux-internet-edit.component';
import { MetodoServerEditComponent } from './metodo-server-edit/metodo-server-edit.component';
import { ProcessoJavaListComponent } from './processo-java-list/processo-java-list.component';
import { ProcessoJavaEditComponent } from './processo-java-edit/processo-java-edit.component';
import { AtributoEntidadeEditComponent } from './atributo-entidade-edit/atributo-entidade-edit.component';
import { RelacionamentoEntidadeEditComponent } from './relacionamento-entidade-edit/relacionamento-entidade-edit.component';
import { ProcessoJavaDetalheComponent } from './processo-java-detalhe/processo-java-detalhe.component';
import { PassoProcessoEditComponent } from './passo-processo-edit/passo-processo-edit.component';
import { DadoProcessoEntradaEditComponent } from './dado-processo-entrada-edit/dado-processo-entrada-edit.component';
import { DadoProcessoSaidaEditComponent } from './dado-processo-saida-edit/dado-processo-saida-edit.component';
import { EscolheEntidadeEntradaParaProcessoComponent } from './escolhe-entidade-entrada-para-processo/escolhe-entidade-entrada-para-processo.component';
import { EscolheEntidadeSaidaParaProcessoComponent } from './escolhe-entidade-saida-para-processo/escolhe-entidade-saida-para-processo.component';
import { DadoProcessoEditComponent } from './dado-processo-edit/dado-processo-edit.component';
import { ParametroMetodoServerEditComponent } from './parametro-metodo-server-edit/parametro-metodo-server-edit.component';
import { SaidaMetodoServerEditComponent } from './saida-metodo-server-edit/saida-metodo-server-edit.component';
import { TelaFrontEditComponent } from './tela-front-edit/tela-front-edit.component';
import { ProcessoPythonListComponent } from './processo-python-list/processo-python-list.component';
import { ProcessoPythonEditComponent } from './processo-python-edit/processo-python-edit.component';
import { ProcessoPythonDetalheComponent } from './processo-python-detalhe/processo-python-detalhe.component';
import { EscolheEntidadeSaidaParaPythonComponent } from './escolhe-entidade-saida-para-python/escolhe-entidade-saida-para-python.component';
import { EscolheEntidadeEntradaParaPythonComponent } from './escolhe-entidade-entrada-para-python/escolhe-entidade-entrada-para-python.component';
import { AtividadeSistemaListComponent } from './atividade-sistema-list/atividade-sistema-list.component';
import { AtividadeSistemaEditComponent } from './atividade-sistema-edit/atividade-sistema-edit.component';

//import { MatMomentDateModule, MAT_MOMENT_DATE_ADAPTER_OPTIONS } from '@angular/material-moment-adapter';


registerLocaleData(localePt, 'pt-BR');

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    HomeComponent,
    SistemaListComponent,
    SistemaEditComponent,
    EntidadeListComponent,
    EntidadeEditComponent,
    EntidadeDetalheComponent,
    LinuxInternetListComponent,
    LinuxInternetEditComponent,
    MetodoServerEditComponent,
    ProcessoJavaListComponent,
    ProcessoJavaEditComponent,
    AtributoEntidadeEditComponent,
    RelacionamentoEntidadeEditComponent,
    ProcessoJavaDetalheComponent,
    PassoProcessoEditComponent,
    DadoProcessoEntradaEditComponent,
    DadoProcessoSaidaEditComponent,
    EscolheEntidadeEntradaParaProcessoComponent,
    EscolheEntidadeSaidaParaProcessoComponent,
    DadoProcessoEditComponent,
    ParametroMetodoServerEditComponent,
    SaidaMetodoServerEditComponent,
    TelaFrontEditComponent,
    ProcessoPythonListComponent,
    ProcessoPythonEditComponent,
    ProcessoPythonDetalheComponent,
    EscolheEntidadeSaidaParaPythonComponent,
    EscolheEntidadeEntradaParaPythonComponent,
    AtividadeSistemaListComponent,
    AtividadeSistemaEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule ,
    MatDialogModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    //NgxImgModule.forRoot(),
    FileDropModule,
    //UploadModule,
    ImageUploadModule.forRoot(),
    NgDragDropModule.forRoot(),
    SDKBrowserModule.forRoot(),
    MatExpansionModule,
    MatListModule,
    MatTabsModule,
    MatCardModule,
    MatIconModule,
    MatSelectModule,
    MatSlideToggleModule,
    MatTableModule,
    MatAutocompleteModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    FormsModule,
    MatButtonModule,
    MatDatepickerModule,
    MatNativeDateModule,
    NgApexchartsModule
    //MatMomentDateModule
  ],
  providers: [
    HttpClient, 
    SocketConnection  , 
    SocketDriver,
    SDKModels,
    LoopBackAuth,
    InternalStorage,
    MatNativeDateModule,
    //MatMomentDateModule,
    { provide: LOCALE_ID, useValue: 'pt-BR' } ,
    //{ provide: MAT_MOMENT_DATE_ADAPTER_OPTIONS, useValue: { useUtc: true } }
  ],
  entryComponents : [
    LinuxInternetEditComponent,
    EntidadeEditComponent,
    MetodoServerEditComponent,
    ProcessoJavaEditComponent,
    AtributoEntidadeEditComponent,
    RelacionamentoEntidadeEditComponent,
    PassoProcessoEditComponent,
    DadoProcessoEntradaEditComponent,
    DadoProcessoSaidaEditComponent,
    EscolheEntidadeEntradaParaProcessoComponent,
    EscolheEntidadeSaidaParaProcessoComponent,
    DadoProcessoEditComponent,
    ParametroMetodoServerEditComponent,
    TelaFrontEditComponent,
    ProcessoPythonEditComponent,
    EscolheEntidadeSaidaParaPythonComponent,
    EscolheEntidadeEntradaParaPythonComponent,
    AtividadeSistemaEditComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
