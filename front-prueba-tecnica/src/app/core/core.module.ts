import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppComponent } from './containers/app/app.component';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  imports: [CommonModule, RouterModule, NgbModule.forRoot()],
  declarations: [AppComponent],
  exports: [AppComponent]
})
export class CoreModule {}
