import {Component} from 'angular2/core';

import {PesertaService} from './peserta.service';

@Component({
    selector:'peserta-list',
    templateUrl:'./aplikasi/peserta/peserta.list.component.html'
})
export class PesertaListComponent{
    daftarPeserta: any;
    
    constructor(private ps: PesertaService){
        this.daftarPeserta = ps.getDaftarPeserta();
    }
    
    editPeserta(peserta){
        console.log("Edit peserta "+peserta.id);
    }
    
    deletePeserta(peserta){
        console.log("Delete peserta "+peserta.id);
    }
}