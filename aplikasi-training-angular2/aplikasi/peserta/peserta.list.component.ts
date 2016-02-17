import {Component} from 'angular2/core';
import {Response} from 'angular2/http';

import {Observable} from 'rxjs';


import {PesertaService} from './peserta.service';

@Component({
    selector:'peserta-list',
    templateUrl:'./aplikasi/peserta/peserta.list.component.html'
})
export class PesertaListComponent{
    daftarPeserta: any;
    
    constructor(private ps: PesertaService){
        this.loadPeserta();
    }
    
    loadPeserta(){
        let hasil: Observable<Response> = this.ps.getDaftarPeserta();
        
        hasil.subscribe(
            (data) => {this.daftarPeserta = data.content},
            (err) => {console.log(err)},
            () => {console.log("request selesai")}
        );
    }
    
    editPeserta(peserta){
        console.log("Edit peserta "+peserta.id);
    }
    
    deletePeserta(peserta){
        console.log("Delete peserta "+peserta.id);
        this.ps.hapusPeserta(peserta.id)
        .subscribe(
            (data) => { /* tidak ada return value */ },
            (err) => {console.log(err)},
            () => { this.loadPeserta() }
        );
    }
}