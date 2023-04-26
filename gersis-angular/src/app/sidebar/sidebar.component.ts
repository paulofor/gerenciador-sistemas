import { Component, OnInit } from '@angular/core';
import { BASE_URL } from '../constantes/base.url';
import { Sistema, SistemaApi } from '../shared/sdk';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  listaSistema:Sistema[];

  ambiente: string = '';

  sistemaId;

  constructor(private srv:SistemaApi) { }

  ngOnInit() {
    this.montaCombos();
  }

  montaCombos() {
    let filtro = {'order' : 'nome'}
    this.srv.find(filtro)
      .subscribe((result:Sistema[])=> {
        console.log('Listasistema' , result);
        this.listaSistema = result;
      })
  }

  onChangeSistema(evento) {
    console.log('Evento:' , evento);
    this.sistemaId = evento.value;
  }

}
