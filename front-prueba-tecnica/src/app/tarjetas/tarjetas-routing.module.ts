import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TarjetasListComponent } from './containers/tarjetas-list/tarjetas-list.component';
import { MovimientosListComponent } from './containers/movimientos-list/movimientos-list.component';

const routes: Routes = [
  {
    path: '',
    component: TarjetasListComponent
  },
  {
    path: ':idTarjeta/movimientos',
    component: MovimientosListComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TarjetasRoutingModule {}
