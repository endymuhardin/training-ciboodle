import 'reflect-metadata';
import 'zone.js';

import {bootstrap} from 'angular2/platform/browser';

import {HTTP_PROVIDERS} from 'angular2/http';

import {ROUTER_PROVIDERS} from 'angular2/router';
import {provide}           from 'angular2/core';
import {LocationStrategy,
        HashLocationStrategy} from 'angular2/router';

import {AplikasiComponent} from './aplikasi';

import {PesertaService} from './peserta/peserta.service';

console.log("Ini file boot.ts");
bootstrap(AplikasiComponent, [
    PesertaService,
    HTTP_PROVIDERS,
    ROUTER_PROVIDERS,
    provide(LocationStrategy, {useClass: HashLocationStrategy})
]);