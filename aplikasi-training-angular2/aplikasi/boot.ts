import 'reflect-metadata';
import 'zone.js';

import {bootstrap} from 'angular2/platform/browser';
import {ROUTER_PROVIDERS} from 'angular2/router';
import {provide}           from 'angular2/core';
import {LocationStrategy,
        HashLocationStrategy} from 'angular2/router';

import {AplikasiComponent} from './aplikasi';


console.log("Ini file boot.ts");
bootstrap(AplikasiComponent, [
    ROUTER_PROVIDERS,
    provide(LocationStrategy, {useClass: HashLocationStrategy})
]);