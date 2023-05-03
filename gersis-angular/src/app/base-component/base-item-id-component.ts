import { OnInit } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { ActivatedRoute } from "@angular/router";
import { BaseLoopBackApi } from "../shared/sdk";

export class BaseItemIdComponent implements OnInit {

    principal: any

    constructor(protected dialog: MatDialog, protected srv:BaseLoopBackApi, protected router: ActivatedRoute) { }


    ngOnInit() {
        this.preCarregaTela();
        this.carregaTela();
    }

    preCarregaTela() {}
    posCarregaLista() {}

    

    carregaTela() {
        this.router.params.subscribe((params) => {
            let id = params['id'];
            console.log('ID:' , id);
            this.srv.findById(id, this.getFiltro())
              .subscribe((result: any) => {
                console.log('Principal:' , result);
                this.principal = result;
                this.posCarregaLista();
              })
          })
        
    }

    getFiltro() {
        return {}
    }
}