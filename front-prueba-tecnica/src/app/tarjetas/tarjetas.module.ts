import { NgModule } from '@angular/core';
import { TarjetasListComponent } from './containers/tarjetas-list/tarjetas-list.component';
import { TarjetasRoutingModule } from './tarjetas-routing.module';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { TarjetasService } from './services/tarjetas.service';
import { TarjetasTableComponent } from './components/tarjetas-table/tarjetas-table.component';
import { TarjetasFormComponent } from './components/tarjetas-form/tarjetas-form.component';
import { MovimientosListComponent } from './containers/movimientos-list/movimientos-list.component';
import { MovimientosTableComponent } from './components/movimientos-table/movimientos-table.component';
import { MovimientosFormComponent } from './components/movimientos-form/movimientos-form.component';
import { MovimientosService } from './services/movimientos.service';

@NgModule({
  declarations: [
    TarjetasListComponent,
    TarjetasTableComponent,
    TarjetasFormComponent,
    MovimientosListComponent,
    MovimientosTableComponent,
    MovimientosFormComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    TarjetasRoutingModule,
    HttpClientModule
  ],
  providers: [TarjetasService, MovimientosService]
})
export class TarjetasModule {}
