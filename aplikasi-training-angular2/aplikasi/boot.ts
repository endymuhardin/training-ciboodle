import 'reflect-metadata';
import 'zone.js';
import {bootstrap} from 'angular2/platform/browser';
import {HaloComponent} from './halo/halo.component';

console.log("Ini file boot.ts");
bootstrap(HaloComponent);