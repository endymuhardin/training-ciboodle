import {Component} from 'angular2/core';

@Component({
    selector:'peserta-list',
    templateUrl:'./aplikasi/peserta/peserta.list.component.html'
})
export class PesertaListComponent{
    daftarPeserta = [
        {id: 10, kode: "P-100", nama: "Peserta 100"},
        {id: 11, kode: "P-101", nama: "Peserta 101"},
        {id: 12, kode: "P-102", nama: "Peserta 102"},
        {id: 13, kode: "P-103", nama: "Peserta 103"},
        {id: 14, kode: "P-104", nama: "Peserta 104"},
        {id: 15, kode: "P-105", nama: "Peserta 105"}
    ]
    
    editPeserta(peserta){
        console.log("Edit peserta "+peserta.id);
    }
    
    deletePeserta(peserta){
        console.log("Delete peserta "+peserta.id);
    }
}