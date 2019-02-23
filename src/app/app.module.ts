import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CarListComponent } from './car-list/car-list.component';
import { HttpClientModule } from '@angular/common/http';
import { Catalog } from './services/catalog';
import { CarDetailsComponent } from './car-details/car-details.component';
import { AppRoutingModule } from './app.routing.module';
import { CarOrderingComponent } from './car-ordering/car-ordering.component';

@NgModule({
  declarations: [
    AppComponent,
    CarListComponent,
    CarDetailsComponent,
    CarOrderingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    Catalog
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
