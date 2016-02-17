import {Component} from 'angular2/core';

@Component({
  selector: 'halo',
  templateUrl: './aplikasi/halo/halo.component.html'
})
export class HaloComponent {
    public nama: string;
    
    
    updateNama(x: string){
        console.log("Menjalankan method updatenama dengan argumen "+x);
        this.nama = x;
        console.log('Nama : '+this.nama);
    }
}
