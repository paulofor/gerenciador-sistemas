import { Routes } from '@angular/router';
import { HomeComponent } from '../home/home.component';
import { SistemaListComponent } from '../sistema-list/sistema-list.component';
import { LinuxInternetListComponent } from '../linux-internet-list/linux-internet-list.component';
import { EntidadeListComponent } from '../entidade-list/entidade-list.component';

import { ProcessoJavaListComponent } from '../processo-java-list/processo-java-list.component';
import { EntidadeDetalheComponent } from '../entidade-detalhe/entidade-detalhe.component';
import { ProcessoJavaDetalheComponent } from '../processo-java-detalhe/processo-java-detalhe.component';
import { ProcessoPythonListComponent } from '../processo-python-list/processo-python-list.component';
import { ProcessoPythonDetalheComponent } from '../processo-python-detalhe/processo-python-detalhe.component';
import { AtividadeSistemaListComponent } from '../atividade-sistema-list/atividade-sistema-list.component';




export const routes : Routes = [
    { path: 'home' , component: HomeComponent },

    { path: 'sistema' , component: SistemaListComponent },
    { path: 'linuxInternet' , component: LinuxInternetListComponent },

    { path: 'entidade/:idSistema' , component: EntidadeListComponent },
    { path: 'processoJava/:idSistema', component: ProcessoJavaListComponent },
    { path: 'processoPython/:idSistema', component: ProcessoPythonListComponent },
    { path: 'atividadeSistema/:idSistema' , component : AtividadeSistemaListComponent },

    { path: 'entidadeDetalhe/:id' , component : EntidadeDetalheComponent },
    { path: 'processoJavaDetalhe/:id' , component : ProcessoJavaDetalheComponent },
    { path: 'processoPythonDetalhe/:id' , component : ProcessoPythonDetalheComponent },
 

    { path: '',  component: HomeComponent  }
    //{ path: '',          redirectTo: 'home', pathMatch: 'full' }
]