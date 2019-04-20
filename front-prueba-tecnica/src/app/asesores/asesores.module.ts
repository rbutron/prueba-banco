import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AsesoresListComponent } from './containers/asesores-list/asesores-list.component';
import { AsesoresFormComponent } from './components/asesores-form/asesores-form.component';
import { AsesoresTableComponent } from './components/asesores-table/asesores-table.component';
import { AsesoresRoutingModule } from './asesores-routing.module';
import { AsesoresService } from './services/asesores.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AsesoresListComponent,
    AsesoresFormComponent,
    AsesoresTableComponent
  ],
  imports: [
    CommonModule,
    AsesoresRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [AsesoresService]
})
export class AsesoresModule {}
