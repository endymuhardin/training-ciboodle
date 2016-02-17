import {Component} from 'angular2/core';

import {PesertaListComponent} from './peserta.list.component';

@Component({
  selector: 'peserta',
  templateUrl: './aplikasi/peserta/peserta.component.html',
  directives:[PesertaListComponent]
})
export class PesertaComponent{}