import { Routes } from '@angular/router';
import { HomeComponent } from '../home/home.component';
import { PlataformaListComponent } from '../plataforma-list/plataforma-list.component';
import { ProdutoHotmartListComponent } from '../produto-hotmart-list/produto-hotmart-list.component';



export const routes : Routes = [
    { path: 'home' , component: HomeComponent },

    { path: 'plataforma' , component: PlataformaListComponent },

    { path: 'produtoHotmart' , component : ProdutoHotmartListComponent },

    { path: '',  component: HomeComponent  }
    //{ path: '',          redirectTo: 'home', pathMatch: 'full' }
]