import {Component} from 'angular2/core';
import {RouteConfig, ROUTER_DIRECTIVES} from 'angular2/router';
import {PesertaComponent} from './peserta/peserta.component';
import {MateriComponent} from './materi/materi.component';
import {KelasComponent} from './kelas/kelas.component';

@Component({
    selector: 'aplikasi',
    template:`
    <a [routerLink]="['Peserta']">Peserta</a> | 
    <a [routerLink]="['Materi']">Materi</a> | 
    <a [routerLink]="['Kelas']">Kelas</a> 
    
    <div>
        <router-outlet></router-outlet>
    </div>
    `,
    directives: [ROUTER_DIRECTIVES]
})
@RouteConfig([
    {path:"/peserta", name:"Peserta", component:PesertaComponent},
    {path:"/materi", name:"Materi", component:MateriComponent},
    {path:"/kelas", name:"Kelas", component:KelasComponent}
])
export class AplikasiComponent{}