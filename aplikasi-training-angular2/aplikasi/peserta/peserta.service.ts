import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';

import 'rxjs/Rx';

@Injectable()
export class PesertaService {
    
    _serverUrl = '/api/peserta/';
    
    constructor(private http:Http){}
    
    getDaftarPeserta(){
        return this.http.get(this._serverUrl)
        .map((res: Response) => res.json());
    }
    
    hapusPeserta(id: number){
        return this.http.delete(this._serverUrl+"/"+id);
    }
}