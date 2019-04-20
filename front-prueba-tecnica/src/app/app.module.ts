import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './core/containers/app/app.component';
import { CoreModule } from './core/core.module';

import { AppRoutingModule } from './app-routing.module';

@NgModule({
    imports: [BrowserModule, AppRoutingModule, CoreModule, NgbModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
